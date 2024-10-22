package me.luhen.surfPranks.tasks

import me.luhen.surfPranks.SurfPranks
import org.bukkit.Bukkit
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Creeper
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitTask

object FakeCreeper {

    private var fakeCreeperTask: BukkitTask? = null

    fun fakeCreeper(player: Player, creeper: Creeper){

        fakeCreeperTask = Bukkit.getScheduler().runTaskLater(SurfPranks.instance, Runnable {

            player.location.world!!.playSound(player.location, Sound.ENTITY_GENERIC_EXPLODE, 0.8f, 0.8f)
            player.location.world!!.spawnParticle(Particle.EXPLOSION, player.location, 5, 0.5,0.5,0.5,0.0)

            creeper.remove()

        }, 40L)

    }

}