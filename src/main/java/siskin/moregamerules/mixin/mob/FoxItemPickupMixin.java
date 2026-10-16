
package siskin.moregamerules.mixin.mob;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.animal.fox.Fox;
import net.minecraft.world.entity.item.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(Fox.class)
public class FoxItemPickupMixin {

    @Inject(
            method = "pickUpItem",
            at = @At("HEAD"),
            cancellable = true
    )
    private void moreGameRules$disableFoxItemPickup(
            ServerLevel level,
            ItemEntity entity,
            CallbackInfo ci
    ) {
        if (level.getGameRules().get(ModGameRules.DISABLE_FOX_ITEM_PICKUP)) {
            ci.cancel();
        }
    }
}
