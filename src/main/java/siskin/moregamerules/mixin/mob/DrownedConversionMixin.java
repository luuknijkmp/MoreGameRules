
package siskin.moregamerules.mixin.mob;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.monster.zombie.Zombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(Zombie.class)
public class DrownedConversionMixin {

    @Inject(
            method = "convertsInWater",
            at = @At("HEAD"),
            cancellable = true
    )
    private void moreGameRules$disableDrownedConversion(
            CallbackInfoReturnable<Boolean> cir
    ) {
        Zombie zombie = (Zombie) (Object) this;

        if (zombie.level() instanceof ServerLevel level
                && level.getGameRules().get(ModGameRules.DISABLE_DROWNED_CONVERSION)) {
            cir.setReturnValue(false);
        }
    }
}
