package me.luhen.surfPranks.pranks

import me.luhen.surfPranks.utils.TimeUtils
import org.bukkit.Sound
import org.bukkit.entity.LlamaSpit
import org.bukkit.entity.Player

object Spit {

    fun spit(player: Player){

        if(TimeUtils.isPlayerInDelay(player)){

            player.launchProjectile(LlamaSpit::class.java)

            player.playSound(player.location, Sound.ENTITY_LLAMA_SPIT, 0.5f,0.5f)

        }

    }

}