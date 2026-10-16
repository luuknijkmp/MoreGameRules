package siskin.moregamerules.gamerule;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;

public final class ModGameRules {

    private static GameRule<Boolean> register(String name) {
        return GameRuleBuilder.forBoolean(false)
                .category(GameRuleCategory.MISC)
                .buildAndRegister(
                        Identifier.fromNamespaceAndPath(
                                "moregamerules", name
                        )
                );
    }

    // World and environment
    public static final GameRule<Boolean> DISABLE_SPRUCE_PODZOL =
            register("disable_spruce_podzol");
    public static final GameRule<Boolean> DISABLE_ICE_FORMATION =
            register("disable_ice_formation");
    public static final GameRule<Boolean> DISABLE_BAMBOO_GROWTH =
            register("disable_bamboo_growth");
    public static final GameRule<Boolean> DISABLE_LEAF_DECAY =
            register("disable_leaf_decay");
    public static final GameRule<Boolean> DISABLE_GRASS_SPREAD =
            register("disable_grass_spread");
    public static final GameRule<Boolean> DISABLE_MYCELIUM_SPREAD =
            register("disable_mycelium_spread");
    public static final GameRule<Boolean> DISABLE_CORAL_DEATH =
            register("disable_coral_death");

    // Blocks and redstone
    public static final GameRule<Boolean> DISABLE_FARMLAND_TRAMPLING =
            register("disable_farmland_trampling");
    public static final GameRule<Boolean> DISABLE_CONCRETE_HARDENING =
            register("disable_concrete_hardening");
    public static final GameRule<Boolean> DISABLE_COPPER_OXIDATION =
            register("disable_copper_oxidation");
    public static final GameRule<Boolean> DISABLE_PISTON_BLOCK_BREAKING =
            register("disable_piston_block_breaking");
    public static final GameRule<Boolean> DISABLE_OBSERVER_UPDATES =
            register("disable_observer_updates");
    public static final GameRule<Boolean> DISABLE_TNT_BLOCK_DAMAGE =
            register("disable_tnt_block_damage");

    // Mobs
    public static final GameRule<Boolean> DISABLE_ENDERMAN_GRIEFING =
            register("disable_enderman_griefing");
    public static final GameRule<Boolean> DISABLE_CREEPER_BLOCK_DAMAGE =
            register("disable_creeper_block_damage");
    public static final GameRule<Boolean> DISABLE_GHAST_BLOCK_DAMAGE =
            register("disable_ghast_block_damage");
    public static final GameRule<Boolean> DISABLE_GHAST_FIRE =
            register("disable_ghast_fire");
    public static final GameRule<Boolean> DISABLE_SLIME_SPAWNING =
            register("disable_slime_spawning");
    public static final GameRule<Boolean> DISABLE_DROWNED_CONVERSION =
            register("disable_drowned_conversion");
    public static final GameRule<Boolean> DISABLE_ZOMBIE_VILLAGER_CONVERSION =
            register("disable_zombie_villager_conversion");
    public static final GameRule<Boolean> DISABLE_ZOMBIE_DOOR_BREAKING =
            register("disable_zombie_door_breaking");
    public static final GameRule<Boolean> DISABLE_VILLAGER_CROP_HARVESTING =
            register("disable_villager_crop_harvesting");
    public static final GameRule<Boolean> DISABLE_FOX_ITEM_PICKUP =
            register("disable_fox_item_pickup");
    public static final GameRule<Boolean> DISABLE_WOLF_TELEPORTING =
            register("disable_wolf_teleporting");
    public static final GameRule<Boolean> DISABLE_CAT_TELEPORTING =
            register("disable_cat_teleporting");

    // Items and players
    //public static final GameRule<Boolean> DISABLE_ANVIL_DAMAGE =
    //        register("disable_anvil_damage");
    //public static final GameRule<Boolean> DISABLE_ANVIL_TOO_EXPENSIVE =
    //        register("disable_anvil_too_expensive");
    //public static final GameRule<Boolean> DISABLE_ITEM_DESPAWN =
    //        register("disable_item_despawn");
    //public static final GameRule<Boolean> DISABLE_EXPERIENCE_DESPAWN =
    //        register("disable_experience_despawn");
    //public static final GameRule<Boolean> DISABLE_HUNGER =
    //        register("disable_hunger");
    //public static final GameRule<Boolean> DISABLE_TOOL_DURABILITY =
    //        register("disable_tool_durability");
    //public static final GameRule<Boolean> DISABLE_ELYTRA_DURABILITY =
    //        register("disable_elytra_durability");

    public static void initialize() {
        // Forces static gamerule registration.
    }

    private ModGameRules() {
    }
}
