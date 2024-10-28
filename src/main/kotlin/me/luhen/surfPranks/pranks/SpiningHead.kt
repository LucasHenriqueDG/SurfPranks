package me.luhen.surfPranks.pranks

import me.luhen.surfPranks.SurfPranks
import me.luhen.surfPranks.tasks.SpiningHeadTasks
import me.luhen.surfPranks.utils.ChatUtils
import me.luhen.surfPranks.utils.TimeUtils
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.ArmorStand
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

object SpiningHead {

    fun spawnHead(sender: Player, player: Player) {

        val econ = SurfPranks.instance.econ
        val prankCost = SurfPranks.instance.config.getDouble("prank-cost")
        if(econ == null || (econ.has(Bukkit.getOfflinePlayer(sender.uniqueId), prankCost))) {

            if (TimeUtils.isPlayerInDelay(player)) {

                if (SurfPranks.instance.disabledWorlds.contains(player.world.name)) {

                    sender.sendMessage(
                        ChatUtils.colors(
                            SurfPranks.instance.config.getString("disabled-world-message").toString()
                        )
                    )

                } else {

                    val world = player.world
                    val direction = player.location.direction.clone().normalize()
                    val headLoc = player.location.clone().add(direction.multiply(6.1))
                    val targetLoc = player.location.toVector().subtract(headLoc.toVector()).normalize()

                    val armorStand: Entity = world.spawn(headLoc, ArmorStand::class.java) { stand ->

                        stand.isVisible = false
                        stand.isMarker = true
                        stand.setGravity(false)
                        stand.isSmall = false
                        stand.isInvulnerable = true

                        val equipment = stand.equipment
                        equipment?.helmet = ItemStack(Material.WITHER_SKELETON_SKULL)

                    }

                    SpiningHeadTasks.spinningHead(armorStand, player, targetLoc)

                    econ?.withdrawPlayer(Bukkit.getOfflinePlayer(sender.uniqueId), prankCost)

                }

            }

        } else {

            sender.sendMessage(ChatUtils.colors(SurfPranks.instance.config.getString("not-enough-money").toString()))

        }

    }

}