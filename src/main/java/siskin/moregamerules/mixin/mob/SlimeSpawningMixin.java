
package siskin.moregamerules.mixin.mob;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.cubemob.Slime;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(Slime.class)
public class SlimeSpawningMixin {

    @Inject(
            method = "checkSlimeSpawnRules",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void moreGameRules$disableSlimeSpawning(
            EntityType<Slime> type,
            LevelAccessor level,
            EntitySpawnReason spawnReason,
            BlockPos pos,
            RandomSource random,
            CallbackInfoReturnable<Boolean> cir
    ) {
        if (spawnReason == EntitySpawnReason.NATURAL
                && level instanceof ServerLevel serverLevel
                && serverLevel.getGameRules().get(ModGameRules.DISABLE_SLIME_SPAWNING)) {
            cir.setReturnValue(false);
        }
    }
}
