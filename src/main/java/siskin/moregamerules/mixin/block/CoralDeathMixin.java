package siskin.moregamerules.mixin.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.CoralBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(CoralBlock.class)
public class CoralDeathMixin {

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void moreGameRules$disableCoralDeath(
            BlockState state,
            ServerLevel level,
            BlockPos pos,
            RandomSource random,
            CallbackInfo ci
    ) {
        if (level.getGameRules().get(ModGameRules.DISABLE_CORAL_DEATH)) {
            ci.cancel();
        }
    }
}