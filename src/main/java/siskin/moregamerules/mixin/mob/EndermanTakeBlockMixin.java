
package siskin.moregamerules.mixin.mob;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.monster.EnderMan;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(targets = "net.minecraft.world.entity.monster.EnderMan$EndermanTakeBlockGoal")
public class EndermanTakeBlockMixin {

    @Shadow @Final
    private EnderMan enderman;

    @Inject(method = "canUse", at = @At("HEAD"), cancellable = true)
    private void moreGameRules$disablePickup(
            CallbackInfoReturnable<Boolean> cir
    ) {
        if (((ServerLevel) this.enderman.level())
                .getGameRules()
                .get(ModGameRules.DISABLE_ENDERMAN_GRIEFING)) {
            cir.setReturnValue(false);
        }

    }
}
