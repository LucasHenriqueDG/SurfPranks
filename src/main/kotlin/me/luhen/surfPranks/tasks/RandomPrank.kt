package me.luhen.surfPranks.tasks

import me.luhen.surfPranks.SurfPranks
import me.luhen.surfPranks.pranks.Fart
import org.bukkit.Bukkit
import org.bukkit.scheduler.BukkitTask

object RandomPrank {

    private var randomPrankTask: BukkitTask? = null

    fun cancelRandomPrankTask(){

        randomPrankTask?.cancel()

    }

    fun randomPrank(time: Int){

        randomPrankTask = Bukkit.getScheduler().runTaskTimer(SurfPranks.instance, Runnable{

            val player = Bukkit.getOnlinePlayers().random()

            Fart.playerFart(player)

        }, time* 20L, time* 20L)

    }

}