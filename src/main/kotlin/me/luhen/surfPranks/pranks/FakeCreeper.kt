package me.luhen.surfPranks.pranks

import me.luhen.surfPranks.SurfPranks
import me.luhen.surfPranks.tasks.FakeCreeperTasks
import me.luhen.surfPranks.utils.ChatUtils
import me.luhen.surfPranks.utils.TimeUtils
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.entity.Creeper
import org.bukkit.entity.Player

object FakeCreeper {

    fun spawnFakeCreeper(sender: Player, player: Player) {

        val econ = SurfPranks.instance.econ
        val prankCost = SurfPranks.instance.config.getDouble("prank-cost")
        if(econ == null || (econ.has(Bukkit.getOfflinePlayer(sender.uniqueId), prankCost))) {

            if (TimeUtils.isPlayerInDelay(player)) {

                val creeper = player.world.spawn(player.location, Creeper::class.java) {

                    it.isInvulnerable = true
                    it.isSilent = true
                    it.isPowered = false
                    it.isAware = false

                }

                player.playSound(player.location, Sound.ENTITY_CREEPER_PRIMED, 0.8f, 0.8f)

                FakeCreeperTasks.fakeCreeper(player, creeper)

                econ?.withdrawPlayer(Bukkit.getOfflinePlayer(sender.uniqueId), prankCost)

            }

        } else {

                sender.sendMessage(ChatUtils.colors(SurfPranks.instance.config.getString("not-enough-money").toString()))

        }

    }

}