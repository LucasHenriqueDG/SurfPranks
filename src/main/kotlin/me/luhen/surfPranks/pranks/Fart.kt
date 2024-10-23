package me.luhen.surfPranks.pranks

import me.luhen.surfPranks.SurfPranks
import me.luhen.surfPranks.utils.TimeUtils
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object Fart {

    fun playerFart(player: Player) {

        val fartPoison = SurfPranks.instance.config.getBoolean("fart-poison", true)

        if (TimeUtils.isPlayerInDelay(player)) {

            val fartDirection = player.location.direction.clone().normalize()
            val fartLoc = player.location.clone().add(fartDirection.multiply(-0.5))

            player.world.spawnParticle(Particle.CAMPFIRE_SIGNAL_SMOKE, fartLoc, 2, 0.2, 0.2, 0.2, 0.0)

            player.playSound(player.location, Sound.ENTITY_ZOMBIE_STEP, 0.5f, 0.5f)

            if(fartPoison){

                player.world.getNearbyEntities(player.location.clone(), 5.0,5.0,5.0).forEach{

                    if(it is Player){

                        it.addPotionEffect(PotionEffect(PotionEffectType.POISON, 40, 1))

                    }

                }

            }

        }

    }

}
