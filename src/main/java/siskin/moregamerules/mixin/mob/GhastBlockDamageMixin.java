
package siskin.moregamerules.mixin.mob;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.projectile.hurtingprojectile.LargeFireball;
import net.minecraft.world.level.Level.ExplosionInteraction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(LargeFireball.class)
public class GhastBlockDamageMixin {

    @ModifyExpressionValue(
            method = "onHit",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/world/level/Level$ExplosionInteraction;MOB:Lnet/minecraft/world/level/Level$ExplosionInteraction;"
            )
    )
    private ExplosionInteraction moreGameRules$disableGhastBlockDamage(
            ExplosionInteraction original
    ) {
        LargeFireball fireball = (LargeFireball) (Object) this;

        if (fireball.level() instanceof ServerLevel level
                && level.getGameRules()
                .get(ModGameRules.DISABLE_GHAST_BLOCK_DAMAGE)) {
            return ExplosionInteraction.NONE;
        }

        return original;
    }
}
