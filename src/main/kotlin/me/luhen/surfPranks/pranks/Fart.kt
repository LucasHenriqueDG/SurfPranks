package me.luhen.surfPranks.pranks

import me.luhen.surfPranks.SurfPranks
import me.luhen.surfPranks.utils.ChatUtils
import me.luhen.surfPranks.utils.TimeUtils
import org.bukkit.Bukkit
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object Fart {

    fun playerFart(sender: Player, player: Player) {

        val fartPoison = SurfPranks.instance.config.getBoolean("fart-poison", true)

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

                    val fartDirection = player.location.direction.clone().normalize()
                    val fartLoc = player.location.clone().add(fartDirection.multiply(-0.5))

                    player.world.spawnParticle(Particle.CAMPFIRE_SIGNAL_SMOKE, fartLoc, 2, 0.2, 0.2, 0.2, 0.0)

                    player.playSound(player.location, Sound.ENTITY_ZOMBIE_STEP, 0.5f, 0.5f)

                    if (fartPoison) {

                        player.world.getNearbyEntities(player.location.clone(), 5.0, 5.0, 5.0).forEach {

                            if (it is Player) {

                                it.addPotionEffect(PotionEffect(PotionEffectType.POISON, 40, 1))

                            }

                        }

                    }

                    econ?.withdrawPlayer(Bukkit.getOfflinePlayer(sender.uniqueId), prankCost)

                }

            }

        } else {

            sender.sendMessage(ChatUtils.colors(SurfPranks.instance.config.getString("not-enough-money").toString()))

        }

    }

}
