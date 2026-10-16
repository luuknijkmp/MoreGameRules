# MoreGameRules

[Download on Modrinth](https://modrinth.com/project/moregamerules)

MoreGameRules is a lightweight, server-side Fabric mod that adds extra gamerules to Minecraft, giving you more control over world mechanics, block interactions, and mob behavior.

All gamerules are disabled by default, meaning Minecraft behaves normally until you choose to enable other behavior.

## Installation

1. Install Minecraft 26.2 with Fabric Loader.
2. Install the compatible Fabric API version.
3. [Download MoreGameRules from Modrinth](https://modrinth.com/project/moregamerules)
4. Place the MoreGameRules JAR in your `mods` folder.
5. Launch Minecraft and configure your gamerules!

### ⭐ Features

- Adds 25 new gamerules for finer control over Minecraft.
- Customize world mechanics, block behavior, and mob interactions independently.
- All gamerules are disabled by default, preserving vanilla behavior.
- Server-side only. Players do not need to install the mod to join a server using MoreGameRules.
- No configuration files required; everything is controlled through Minecraft's `/gamerule` command.
- Gamerules can be changed at any time without restarting the server.

## Available Gamerules

All gamerules use the `moregamerules:` namespace and accept `true` or `false`.

Setting a gamerule to `true` disables the specified mechanic. Setting it to `false` restores normal vanilla behavior.

### World & Environment

| Gamerule | Description |
|---|---|
| `disable_spruce_podzol` | Prevents large spruce trees from converting nearby grass and dirt into podzol. |
| `disable_ice_formation` | Prevents water from naturally freezing into ice. |
| `disable_bamboo_growth` | Prevents bamboo from growing naturally. |
| `disable_leaf_decay` | Prevents leaves from naturally decaying when no longer connected to logs. |
| `disable_grass_spread` | Prevents grass blocks from spreading to nearby dirt. |
| `disable_mycelium_spread` | Prevents mycelium from spreading to nearby dirt. |
| `disable_coral_death` | Prevents coral blocks, fans, and wall fans from dying when outside water. |

### Blocks & Redstone

| Gamerule | Description |
|---|---|
| `disable_farmland_trampling` | Prevents farmland from turning into dirt when entities jump or fall onto it. |
| `disable_concrete_hardening` | Prevents concrete powder from hardening into concrete when touching water. |
| `disable_copper_oxidation` | Prevents copper blocks from naturally oxidizing over time. |
| `disable_piston_block_breaking` | Prevents pistons from breaking blocks during movement. |
| `disable_observer_updates` | Prevents observers from producing redstone pulses when detecting block updates. |
| `disable_tnt_block_damage` | Prevents TNT explosions from destroying blocks while preserving their other effects. |

### Mobs

| Gamerule | Description |
|---|---|
| `disable_enderman_griefing` | Prevents endermen from picking up and placing blocks. |
| `disable_creeper_block_damage` | Prevents creeper explosions from destroying blocks while still allowing them to damage entities. |
| `disable_ghast_block_damage` | Prevents ghast fireball explosions from destroying blocks. |
| `disable_ghast_fire` | Prevents ghast fireball explosions from creating fire. |
| `disable_slime_spawning` | Prevents slimes from spawning naturally. |
| `disable_drowned_conversion` | Prevents zombies from converting into drowned when submerged in water. |
| `disable_zombie_villager_conversion` | Prevents zombies from converting villagers into zombie villagers. |
| `disable_zombie_door_breaking` | Prevents zombies from breaking wooden doors. |
| `disable_villager_crop_harvesting` | Prevents villagers from harvesting crops on farmland. |
| `disable_fox_item_pickup` | Prevents foxes from picking up dropped items. |
| `disable_wolf_teleporting` | Prevents tamed wolves from teleporting to their owners. |
| `disable_cat_teleporting` | Prevents tamed cats from teleporting to their owners. |

## Configuration

MoreGameRules uses Minecraft's built-in `/gamerule` command. No external configuration files are needed.

For example, to prevent creepers from destroying blocks:

`/gamerule moregamerules:disable_creeper_block_damage true`

To prevent copper from oxidizing:

`/gamerule moregamerules:disable_copper_oxidation true`

To prevent tamed wolves from teleporting:

`/gamerule moregamerules:disable_wolf_teleporting true`

To restore normal behavior, set the corresponding gamerule to `false`:

`/gamerule moregamerules:disable_wolf_teleporting false`

**All gamerules are set to `false` by default.** You can enable only the mechanics you want to change.

Gamerule settings are saved with your world and persist across restarts.

## Server-Side Support

MoreGameRules is designed to run entirely on the server.

- Works in singleplayer and on dedicated Fabric servers.
- Players can connect using an unmodified vanilla client, so no client-side installation is required.
- Gamerules are managed by server operators or players with the appropriate permissions.

## Bug Reports & Suggestions

If you encounter a bug, please open an issue in the
[GitHub Issues](https://github.com/luuknijkmp/MoreGameRules/issues) section.

When reporting a bug, please include:
- Your NoMorePodzol version
- Your Minecraft version
- Steps to reproduce the issue
- Relevant logs or screenshots, if available