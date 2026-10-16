
package siskin.moregamerules.mixin.entity;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(PrimedTnt.class)
public class TntBlockDamageMixin {

    @ModifyExpressionValue(
            method = "explode",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/world/level/Level$ExplosionInteraction;TNT:Lnet/minecraft/world/level/Level$ExplosionInteraction;"
            )
    )
    private Level.ExplosionInteraction moreGameRules$disableTntBlockDamage(
            Level.ExplosionInteraction original
    ) {
        PrimedTnt tnt = (PrimedTnt) (Object) this;

        if (tnt.level() instanceof ServerLevel level
                && level.getGameRules().get(ModGameRules.DISABLE_TNT_BLOCK_DAMAGE)) {
            return Level.ExplosionInteraction.NONE;
        }

        return original;
    }
}
