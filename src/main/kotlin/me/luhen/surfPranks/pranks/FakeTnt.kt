package me.luhen.surfPranks.pranks

import me.luhen.surfPranks.SurfPranks
import me.luhen.surfPranks.tasks.TntTasks
import me.luhen.surfPranks.utils.ChatUtils
import me.luhen.surfPranks.utils.TimeUtils
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.entity.TNTPrimed

object FakeTnt {

    fun fakeTnt(sender: Player, player: Player){

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

                    val loc = player.getLineOfSight(setOf(Material.AIR), 5).last().location
                    val tnt = player.world.spawn(loc, TNTPrimed::class.java).apply {

                        fuseTicks = 80

                    }

                    tnt.location.world!!.playSound(tnt.location, Sound.ENTITY_TNT_PRIMED, 0.8f, 0.8f)

                    TntTasks.tnts.add(tnt)
                    TntTasks.removeBomb(tnt)


                    econ?.withdrawPlayer(Bukkit.getOfflinePlayer(sender.uniqueId), prankCost)


                }

            }

        } else {

            sender.sendMessage(ChatUtils.colors(SurfPranks.instance.config.getString("not-enough-money").toString()))

        }


    }

}