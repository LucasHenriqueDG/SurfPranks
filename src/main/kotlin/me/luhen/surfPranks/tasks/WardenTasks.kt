package me.luhen.surfPranks.tasks

import me.luhen.surfPranks.SurfPranks
import me.luhen.surfPranks.pranks.FakeWarden
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.entity.Warden
import org.bukkit.scheduler.BukkitTask

object WardenTasks {

    private var angerTask: BukkitTask? = null

    fun anger(player: Player, warden: Warden){

        angerTask = Bukkit.getScheduler().runTaskLater(SurfPranks.instance, Runnable {

            warden.isAware = true
            warden.setAnger(player, 150)
            removeWarden(warden)

        }, 20L)

    }

    private var removeWardenTask: BukkitTask? = null

    fun removeWarden(warden: Warden){

        removeWardenTask = Bukkit.getScheduler().runTaskLater(SurfPranks.instance, Runnable {

            warden.remove()
            FakeWarden.wardens.remove(warden)

        }, 60L)

    }

}