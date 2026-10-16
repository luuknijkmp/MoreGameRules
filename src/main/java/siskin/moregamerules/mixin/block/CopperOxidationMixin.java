
package siskin.moregamerules.mixin.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(ChangeOverTimeBlock.class)
public interface CopperOxidationMixin {

    @Inject(
            method = "changeOverTime",
            at = @At("HEAD"),
            cancellable = true
    )
    private void moreGameRules$disableCopperOxidation(
            BlockState state,
            ServerLevel level,
            BlockPos pos,
            RandomSource random,
            CallbackInfo ci
    ) {
        if (state.getBlock() instanceof WeatheringCopper
                && level.getGameRules().get(ModGameRules.DISABLE_COPPER_OXIDATION)) {
            ci.cancel();
        }
    }
}
