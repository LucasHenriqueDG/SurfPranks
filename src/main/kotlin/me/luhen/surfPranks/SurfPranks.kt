package me.luhen.surfPranks

import me.luhen.surfPranks.commands.PrankCommand
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

        getCommand("prank")!!.setExecutor(PrankCommand)
        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
