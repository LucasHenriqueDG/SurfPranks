package me.luhen.surfPranks.pranks

import me.luhen.surfPranks.utils.TimeUtils
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Player

object Fart {

    fun playerFart(player: Player) {

        if (TimeUtils.isPlayerInDelay(player)) {

            val fartDirection = player.location.direction.clone().normalize()
            val fartLoc = player.location.clone().add(fartDirection.multiply(-0.5))

            player.world.spawnParticle(Particle.CAMPFIRE_SIGNAL_SMOKE, fartLoc, 2, 0.2, 0.2, 0.2, 0.0)

            player.playSound(player.location, Sound.ENTITY_ZOMBIE_STEP, 0.5f, 0.5f)

        }

    }

}
