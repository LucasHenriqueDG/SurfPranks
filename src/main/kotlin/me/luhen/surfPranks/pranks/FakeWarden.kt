package me.luhen.surfPranks.pranks

import me.luhen.surfPranks.SurfPranks
import me.luhen.surfPranks.tasks.WardenTasks
import me.luhen.surfPranks.utils.ChatUtils
import me.luhen.surfPranks.utils.TimeUtils
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.entity.Warden
import org.bukkit.util.Vector

object FakeWarden {

    val wardens = mutableListOf<Warden>()

    fun spawnWarden(sender: Player, player: Player){

        val econ = SurfPranks.instance.econ
        val prankCost = SurfPranks.instance.config.getDouble("prank-cost")
        if((econ == null) || (econ.has(Bukkit.getOfflinePlayer(sender.uniqueId), prankCost))) {

            if (TimeUtils.isPlayerInDelay(sender)) {

                val line = player.getLineOfSight(setOf(Material.AIR), 7)
                val spawnLoc = line.last().location.add(Vector(0.0,1.0,0.0))

                val warden = player.world.spawn(spawnLoc, Warden::class.java)

                warden.isInvulnerable = true
                warden.isAware = false

                wardens.add(warden)
                WardenTasks.anger(player, warden)

                econ?.withdrawPlayer(Bukkit.getOfflinePlayer(sender.uniqueId), prankCost)

            }

        } else {

            sender.sendMessage(ChatUtils.colors(SurfPranks.instance.config.getString("not-enough-money").toString()))

        }

    }

}