
package siskin.moregamerules.mixin.mob;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.npc.villager.Villager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(Zombie.class)
public class ZombieVillagerConversionMixin {

    @WrapOperation(
            method = "killedEntity",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/monster/zombie/Zombie;convertVillagerToZombieVillager(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/npc/villager/Villager;)Z"
            )
    )
    private boolean moreGameRules$disableZombieVillagerConversion(
            Zombie zombie,
            ServerLevel level,
            Villager villager,
            Operation<Boolean> original
    ) {
        if (level.getGameRules().get(ModGameRules.DISABLE_ZOMBIE_VILLAGER_CONVERSION)) {
            return false;
        }

        return original.call(zombie, level, villager);
    }
}
