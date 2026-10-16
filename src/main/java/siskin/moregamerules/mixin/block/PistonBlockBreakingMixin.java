
package siskin.moregamerules.mixin.block;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.piston.PistonStructureResolver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(PistonBaseBlock.class)
public class PistonBlockBreakingMixin {

    @ModifyExpressionValue(
            method = "moveBlocks",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/piston/PistonStructureResolver;resolve()Z"
            )
    )
    private boolean moreGameRules$preventPistonBreaking(
            boolean original,
            Level level,
            @Local PistonStructureResolver resolver
    ) {
        if (!original) {
            return false;
        }

        if (level instanceof ServerLevel serverLevel
                && serverLevel.getGameRules().get(ModGameRules.DISABLE_PISTON_BLOCK_BREAKING)
                && !resolver.getToDestroy().isEmpty()) {
            return false;
        }

        return true;
    }
}
