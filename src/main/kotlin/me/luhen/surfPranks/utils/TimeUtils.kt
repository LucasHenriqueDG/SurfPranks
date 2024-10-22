package me.luhen.surfPranks.utils

import me.luhen.surfPranks.SurfPranks
import org.bukkit.entity.Player

object TimeUtils {

    fun isPlayerInDelay(player: Player): Boolean{

        val currentTime = System.currentTimeMillis()

        val playerTime = SurfPranks.instance.prankDelay[player] ?: 0L

        return if((currentTime - playerTime) > 1000) {

            SurfPranks.instance.prankDelay[player] = currentTime

            true

        } else {

            false

        }

    }

}