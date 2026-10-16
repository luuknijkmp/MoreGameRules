
package siskin.moregamerules.mixin.mob;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.behavior.HarvestFarmland;
import net.minecraft.world.entity.npc.villager.Villager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(HarvestFarmland.class)
public class VillagerCropHarvestingMixin {

    @Inject(
            method = "checkExtraStartConditions",
            at = @At("HEAD"),
            cancellable = true
    )
    private void moreGameRules$preventFarmingStart(
            ServerLevel level,
            Villager villager,
            CallbackInfoReturnable<Boolean> cir
    ) {
        if (level.getGameRules().get(ModGameRules.DISABLE_VILLAGER_CROP_HARVESTING)) {
            cir.setReturnValue(false);
        }
    }

    @Inject(
            method = "canStillUse",
            at = @At("HEAD"),
            cancellable = true
    )
    private void moreGameRules$stopFarming(
            ServerLevel level,
            Villager villager,
            long timestamp,
            CallbackInfoReturnable<Boolean> cir
    ) {
        if (level.getGameRules().get(ModGameRules.DISABLE_VILLAGER_CROP_HARVESTING)) {
            cir.setReturnValue(false);
        }
    }
}
