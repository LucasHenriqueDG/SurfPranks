package me.luhen.surfPranks.pranks

import me.luhen.surfPranks.SurfPranks
import me.luhen.surfPranks.utils.ChatUtils
import me.luhen.surfPranks.utils.TimeUtils
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class FakeDiamond {

    fun spawnFakeDiamond(sender: Player, player: Player){

        val econ = SurfPranks.instance.econ
        val prankCost = SurfPranks.instance.config.getDouble("prank-cost")
        if(econ == null || (econ.has(Bukkit.getOfflinePlayer(sender.uniqueId), prankCost))) {

            if(TimeUtils.isPlayerInDelay(sender)) {

                if (SurfPranks.instance.disabledWorlds.contains(player.world.name)) {

                    sender.sendMessage(
                        ChatUtils.colors(
                            SurfPranks.instance.config.getString("disabled-world-message").toString()
                        )
                    )

                } else {

                    val diamond = ItemStack(Material.DIAMOND)
                    val meta = diamond.itemMeta

                    val lore = mutableListOf("Fake diamond")

                    meta?.lore = lore
                    diamond.itemMeta = meta

                    val spawnLocation = player.getLineOfSight(setOf(Material.AIR), 5).last().location

                    spawnLocation.world?.dropItem(spawnLocation, diamond)

                    econ?.withdrawPlayer(Bukkit.getOfflinePlayer(sender.uniqueId), prankCost)


                }

            }

        } else {

            sender.sendMessage(ChatUtils.colors(SurfPranks.instance.config.getString("not-enough-money").toString()))

        }


    }

}