package me.luhen.surfPranks.tasks

import me.luhen.surfPranks.SurfPranks
import org.bukkit.Bukkit
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.TNTPrimed
import org.bukkit.scheduler.BukkitTask

object TntTasks {

    val tnts = mutableListOf<TNTPrimed>()

    private var tntRemove: BukkitTask? = null

    fun removeBomb(tnt: TNTPrimed){

        tntRemove = Bukkit.getScheduler().runTaskLater(SurfPranks.instance, Runnable {

            tnt.remove()
            tnts.remove(tnt)

            tnt.location.world!!.playSound(tnt.location, Sound.ENTITY_GENERIC_EXPLODE, 0.8f, 0.8f)
            tnt.location.world!!.spawnParticle(Particle.EXPLOSION, tnt.location, 5, 0.5,0.5,0.5,0.0)

        }, 60L)

    }

}