package me.luhen.surfPranks

import me.luhen.surfPranks.commands.PrankCommand
import me.luhen.surfPranks.commands.PranksCommand
import me.luhen.surfPranks.commands.SpCommand
import me.luhen.surfPranks.tasks.RandomPrankTasks
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class SurfPranks : JavaPlugin() {

    companion object {

        lateinit var instance: SurfPranks

    }

    init {

        instance = this

    }

    val prankDelay = mutableMapOf<Player, Long>()

    override fun onEnable() {

        saveDefaultConfig()

        getCommand("prank")!!.setExecutor(PrankCommand)
        getCommand("pranks")!!.setExecutor(PranksCommand)
        getCommand("surfpranks")!!.setExecutor(SpCommand)

        if(config.getBoolean("random-pranks", false))
            RandomPrankTasks.randomPrank(config.getInt("random-prank-interval"))

    }

    override fun onDisable() {
    }
}
