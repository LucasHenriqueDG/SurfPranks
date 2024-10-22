package me.luhen.surfPranks.pranks

import me.luhen.surfPranks.tasks.FakeCreeper
import org.bukkit.Sound
import org.bukkit.entity.Creeper
import org.bukkit.entity.Player

object FakeCreeper {

    fun spawnFakeCreeper(player: Player){

        val creeper = player.world.spawn(player.location, Creeper::class.java) {

            it.isInvulnerable = true
            it.isSilent = true
            it.isPowered = false
            it.isAware = false

        }

        player.playSound(player.location, Sound.ENTITY_CREEPER_PRIMED, 0.8f, 0.8f)

        FakeCreeper.fakeCreeper(player, creeper)

    }

}