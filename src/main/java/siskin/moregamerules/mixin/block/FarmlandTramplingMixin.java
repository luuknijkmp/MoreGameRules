
package siskin.moregamerules.mixin.block;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FarmlandBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(FarmlandBlock.class)
public class FarmlandTramplingMixin {

    @WrapWithCondition(
            method = "fallOn",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/FarmlandBlock;turnToDirt(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;)V"
            )
    )
    private boolean moreGameRules$allowTrampling(
            Entity sourceEntity,
            BlockState state,
            Level level,
            BlockPos pos
    ) {
        return !(level instanceof ServerLevel serverLevel
                && serverLevel.getGameRules()
                .get(ModGameRules.DISABLE_FARMLAND_TRAMPLING));
    }
}
