
package siskin.moregamerules.mixin.mob;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.projectile.hurtingprojectile.LargeFireball;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(LargeFireball.class)
public class GhastFireMixin {

    @ModifyArgs(
            method = "onHit",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;explode(Lnet/minecraft/world/entity/Entity;DDDFZLnet/minecraft/world/level/Level$ExplosionInteraction;)V"
            )
    )
    private void moreGameRules$disableGhastFire(Args args) {
        LargeFireball fireball = (LargeFireball) (Object) this;

        if (fireball.level() instanceof ServerLevel level
                && level.getGameRules()
                .get(ModGameRules.DISABLE_GHAST_FIRE)) {
            args.set(5, false);
        }
    }
}
