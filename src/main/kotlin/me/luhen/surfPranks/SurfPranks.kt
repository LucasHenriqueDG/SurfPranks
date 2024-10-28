package me.luhen.surfPranks

import me.luhen.surfPranks.commands.PrankCommand
import me.luhen.surfPranks.commands.PranksCommand
import me.luhen.surfPranks.commands.SpCommand
import me.luhen.surfPranks.listeners.FakeDiamondListener
import me.luhen.surfPranks.listeners.WardenListener
import me.luhen.surfPranks.utils.ConfigUtils
import net.milkbowl.vault.economy.Economy
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class SurfPranks : JavaPlugin() {

    var econ: Economy? = null

    val disabledWorlds = mutableListOf<String>()

    companion object {

        lateinit var instance: SurfPranks

    }

    init {

        instance = this

    }

    val prankDelay = mutableMapOf<Player, Long>()

    override fun onEnable() {

        if(Bukkit.getPluginManager().getPlugin("Vault") != null){

            logger.info("[Surf Pranks] Vault hooked.")
            val rsp = server.servicesManager.getRegistration(Economy::class.java)
            econ = rsp?.provider

        } else {

            logger.warning("[Surf Pranks] Vault no found. Some features are not going to be enabled.")

        }

        saveDefaultConfig()
        ConfigUtils.addValues()

        getCommand("prank")!!.setExecutor(PrankCommand)
        getCommand("pranks")!!.setExecutor(PranksCommand)
        getCommand("surfpranks")!!.setExecutor(SpCommand)

        server.pluginManager.registerEvents(FakeDiamondListener, this)
        server.pluginManager.registerEvents(WardenListener, this)

        config.getStringList("disabled-worlds").forEach{

            disabledWorlds.add(it)

        }


    }

    override fun onDisable() {
    }
}
