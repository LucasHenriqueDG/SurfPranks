package me.luhen.surfPranks.utils

import me.luhen.surfPranks.SurfPranks
import org.bukkit.entity.Player

object TimeUtils {

    fun isPlayerInDelay(player: Player): Boolean{

        val delay = SurfPranks.instance.config.getInt("prank-delay")

        val currentTime = System.currentTimeMillis()

        val playerTime = SurfPranks.instance.prankDelay[player] ?: 0L

        return if((currentTime - playerTime) > 1000 * delay) {

            SurfPranks.instance.prankDelay[player] = currentTime

            true

        } else {

            false

        }

    }

}