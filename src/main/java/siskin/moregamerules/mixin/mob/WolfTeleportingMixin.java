
package siskin.moregamerules.mixin.mob;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.feline.Cat;
import net.minecraft.world.entity.animal.wolf.Wolf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(TamableAnimal.class)
public abstract class WolfTeleportingMixin {

    @Inject(
            method = "shouldTryTeleportToOwner",
            at = @At("HEAD"),
            cancellable = true
    )
    private void moreGameRules$disablePetTeleporting(
            CallbackInfoReturnable<Boolean> cir
    ) {
        TamableAnimal animal = (TamableAnimal) (Object) this;

        if (!(animal.level() instanceof ServerLevel level)) {
            return;
        }

        if (animal instanceof Wolf
                && level.getGameRules().get(ModGameRules.DISABLE_WOLF_TELEPORTING)) {
            cir.setReturnValue(false);
        } else if (animal instanceof Cat
                && level.getGameRules().get(ModGameRules.DISABLE_CAT_TELEPORTING)) {
            cir.setReturnValue(false);
        }
    }
}
