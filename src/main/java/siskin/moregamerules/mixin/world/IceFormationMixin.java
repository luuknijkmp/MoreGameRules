
package siskin.moregamerules.mixin.world;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import siskin.moregamerules.gamerule.ModGameRules;

@Mixin(ServerLevel.class)
public class IceFormationMixin {

    @ModifyExpressionValue(
            method = "tickPrecipitation",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/biome/Biome;shouldFreeze(Lnet/minecraft/world/level/LevelReader;Lnet/minecraft/core/BlockPos;)Z"
            )
    )
    private boolean moreGameRules$disableIceFormation(boolean original) {
        ServerLevel level = (ServerLevel) (Object) this;

        if (level.getGameRules()
                .get(ModGameRules.DISABLE_ICE_FORMATION)) {
            return false;
        }

        return original;
    }
}
