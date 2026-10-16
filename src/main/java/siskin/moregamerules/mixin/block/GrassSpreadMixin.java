
package siskin.moregamerules.mixin.block;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SpreadingSnowyBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(SpreadingSnowyBlock.class)
public class GrassSpreadMixin {

    @WrapWithCondition(
            method = "randomTick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/level/ServerLevel;setBlockAndUpdate(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Z"
            ),
            slice = @Slice(
                    from = @At(
                            value = "INVOKE",
                            target = "Lnet/minecraft/world/level/block/SpreadingSnowyBlock;canPropagate(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/LevelReader;Lnet/minecraft/core/BlockPos;)Z"
                    )
            )
    )
    private boolean moreGameRules$allowGrassSpread(
            ServerLevel level,
            BlockPos pos,
            BlockState newState
    ) {
        if (newState.is(Blocks.GRASS_BLOCK)) {
            return !level.getGameRules().get(ModGameRules.DISABLE_GRASS_SPREAD);
        }

        if (newState.is(Blocks.MYCELIUM)) {
            return !level.getGameRules().get(ModGameRules.DISABLE_MYCELIUM_SPREAD);
        }

        return true;
    }
}
