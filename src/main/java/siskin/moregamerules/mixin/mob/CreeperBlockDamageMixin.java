
package siskin.moregamerules.mixin.mob;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level.ExplosionInteraction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(Creeper.class)
public class CreeperBlockDamageMixin {

    @ModifyExpressionValue(
            method = "explodeCreeper",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/world/level/Level$ExplosionInteraction;MOB:Lnet/minecraft/world/level/Level$ExplosionInteraction;"
            )
    )
    private ExplosionInteraction moreGameRules$disableCreeperBlockDamage(
            ExplosionInteraction original
    ) {
        Creeper creeper = (Creeper) (Object) this;

        if (((ServerLevel) creeper.level())
                .getGameRules()
                .get(ModGameRules.DISABLE_CREEPER_BLOCK_DAMAGE)) {
            return ExplosionInteraction.NONE;
        }

        return original;
    }
}
