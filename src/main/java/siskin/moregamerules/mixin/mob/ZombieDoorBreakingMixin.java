
package siskin.moregamerules.mixin.mob;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.BreakDoorGoal;
import net.minecraft.world.entity.monster.zombie.Zombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(BreakDoorGoal.class)
public class ZombieDoorBreakingMixin {

    @Inject(method = "canUse", at = @At("HEAD"), cancellable = true)
    private void moreGameRules$preventDoorBreakingStart(
            CallbackInfoReturnable<Boolean> cir
    ) {
        Mob mob = ((DoorInteractGoalAccessor) this).moreGameRules$getMob();

        if (mob instanceof Zombie
                && mob.level() instanceof ServerLevel level
                && level.getGameRules().get(ModGameRules.DISABLE_ZOMBIE_DOOR_BREAKING)) {
            cir.setReturnValue(false);
        }
    }

    @Inject(method = "canContinueToUse", at = @At("HEAD"), cancellable = true)
    private void moreGameRules$stopDoorBreaking(
            CallbackInfoReturnable<Boolean> cir
    ) {
        Mob mob = ((DoorInteractGoalAccessor) this).moreGameRules$getMob();

        if (mob instanceof Zombie
                && mob.level() instanceof ServerLevel level
                && level.getGameRules().get(ModGameRules.DISABLE_ZOMBIE_DOOR_BREAKING)) {
            cir.setReturnValue(false);
        }
    }
}
