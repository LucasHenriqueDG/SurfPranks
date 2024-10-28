package me.luhen.surfPranks.utils

import me.luhen.surfPranks.SurfPranks

object ConfigUtils {

    fun addValues(){

        val config = SurfPranks.instance.config

        config.addDefault("command-usage-message", "&b[Surf Pranks] &dTry /prank &f<prankname>")

        config.addDefault("wrong-command-usage-message",  "&b[Surf Pranks] &cWrong argument, try &a/pranks")

        config.addDefault("prank-list", "&b[Surf Pranks] &dCurrent available pranks: &6%prank_list%")

        config.addDefault("no-permission-message", "&b[Surf Pranks] &cYou do not have permission to use this command.")

        config.addDefault("player-not-found-message", "&b[Surf Pranks] &cThis player is not currently online or does not exist.")

        config.addDefault("not-enough-money", "&b[Surf Pranks] &cYou don't have enough money to use this command.")

        config.addDefault("disabled-world-message", "&b[Surf Pranks] &dThis player is in a world with pranks disabled.")

        config.addDefault("disabled-worlds", listOf<String>())

        config.addDefault("prank-delay", 60)

        config.addDefault("prank-cost", 0.0)

        config.addDefault("fart-poison", true)


        config.options().copyDefaults(true)
        SurfPranks.instance.saveConfig()

    }

}