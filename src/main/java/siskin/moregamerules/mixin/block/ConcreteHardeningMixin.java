
package siskin.moregamerules.mixin.block;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.ConcretePowderBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(ConcretePowderBlock.class)
public class ConcreteHardeningMixin {

    @ModifyExpressionValue(
            method = "getStateForPlacement",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/ConcretePowderBlock;shouldSolidify(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Z"
            )
    )
    private boolean moreGameRules$preventPlacementHardening(
            boolean original,
            net.minecraft.world.item.context.BlockPlaceContext context
    ) {
        if (context.getLevel() instanceof ServerLevel level
                && level.getGameRules().get(ModGameRules.DISABLE_CONCRETE_HARDENING)) {
            return false;
        }

        return original;
    }

    @ModifyExpressionValue(
            method = "updateShape",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/ConcretePowderBlock;touchesLiquid(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)Z"
            )
    )
    private boolean moreGameRules$preventWaterHardening(
            boolean original,
            BlockState state,
            LevelReader level,
            net.minecraft.world.level.ScheduledTickAccess ticks,
            BlockPos pos
    ) {
        if (level instanceof ServerLevel serverLevel
                && serverLevel.getGameRules().get(ModGameRules.DISABLE_CONCRETE_HARDENING)) {
            return false;
        }

        return original;
    }

    @ModifyExpressionValue(
            method = "onLand",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/ConcretePowderBlock;shouldSolidify(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Z"
            )
    )
    private boolean moreGameRules$preventFallingHardening(
            boolean original,
            Level level
    ) {
        if (level instanceof ServerLevel serverLevel
                && serverLevel.getGameRules().get(ModGameRules.DISABLE_CONCRETE_HARDENING)) {
            return false;
        }

        return original;
    }
}
