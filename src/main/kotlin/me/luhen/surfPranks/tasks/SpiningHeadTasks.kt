package me.luhen.surfPranks.tasks

import me.luhen.surfPranks.SurfPranks
import org.bukkit.Bukkit
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitTask
import org.bukkit.util.Vector

object SpiningHeadTasks {

    private val spinningHeads = mutableMapOf<Player, BukkitTask>()

    private var spinningHeadTask: BukkitTask? = null

    private fun cancelSpinningHeadTask(player: Player){

        spinningHeads[player]?.cancel()
        spinningHeads.remove(player)

    }

    fun spinningHead(stand: Entity, player: Player, direction: Vector){

        var count = 0

        player.playSound(player.location, Sound.ENTITY_WITHER_HURT, 0.8f,0.8f)

        cancelSpinningHeadTask(player)

        val dirNorm = direction.multiply(0.1)

        spinningHeadTask = Bukkit.getScheduler().runTaskTimer(SurfPranks.instance, Runnable {

            val newYaw = stand.location.yaw + 10
            val newLoc = (stand.location.clone().add(dirNorm))
            newLoc.yaw = newYaw

            stand.teleport(newLoc)

            count += 1

            if(count >= 60){

                stand.remove()
                cancelSpinningHeadTask(player)

                player.location.world?.spawnParticle(Particle.EXPLOSION, newLoc, 5, 0.5,0.5,0.5,0.0)
                player.location.world?.playSound(player.location, Sound.ENTITY_GENERIC_EXPLODE, 0.8f, 0.8f)

            }

        },1L, 1L)

        spinningHeads[player] = spinningHeadTask!!

    }

}