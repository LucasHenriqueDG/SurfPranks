package me.luhen.surfPranks.utils

import org.bukkit.ChatColor

object ChatUtils {

    fun colors(input: String): String{

        return ChatColor.translateAlternateColorCodes('&', input)

    }

}