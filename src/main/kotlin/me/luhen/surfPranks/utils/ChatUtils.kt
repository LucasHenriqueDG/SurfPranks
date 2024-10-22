package me.luhen.surfPranks.utils

import org.bukkit.ChatColor

object ChatUtils {

    fun colors(input: String): String{

        return ChatColor.translateAlternateColorCodes('&', input)

    }

    fun replacePlaceholders(input: String, placeholders: Pair<String, String>): String{

        return input.replace(placeholders.first, placeholders.second)

    }

}