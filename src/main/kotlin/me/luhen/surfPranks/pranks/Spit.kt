package me.luhen.surfPranks.pranks

import me.luhen.surfPranks.SurfPranks
import me.luhen.surfPranks.utils.ChatUtils
import me.luhen.surfPranks.utils.TimeUtils
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.entity.LlamaSpit
import org.bukkit.entity.Player

object Spit {

    fun spit(sender: Player, player: Player){

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

                    player.launchProjectile(LlamaSpit::class.java)

                    player.playSound(player.location, Sound.ENTITY_LLAMA_SPIT, 0.5f, 0.5f)

                    econ?.withdrawPlayer(Bukkit.getOfflinePlayer(sender.uniqueId), prankCost)

                }

            }

        } else {

            sender.sendMessage(ChatUtils.colors(SurfPranks.instance.config.getString("not-enough-money").toString()))

        }

    }

}