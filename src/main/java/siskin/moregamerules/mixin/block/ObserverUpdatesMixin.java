
package siskin.moregamerules.mixin.block;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.ObserverBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(ObserverBlock.class)
public class ObserverUpdatesMixin {

    @WrapWithCondition(
            method = "updateShape",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/ObserverBlock;startSignal(Lnet/minecraft/world/level/LevelReader;Lnet/minecraft/world/level/ScheduledTickAccess;Lnet/minecraft/core/BlockPos;)V"
            )
    )
    private boolean moreGameRules$allowObserverUpdates(
            ObserverBlock observer,
            LevelReader level,
            ScheduledTickAccess ticks,
            BlockPos pos
    ) {
        return !(level instanceof ServerLevel serverLevel
                && serverLevel.getGameRules()
                .get(ModGameRules.DISABLE_OBSERVER_UPDATES));
    }
}
