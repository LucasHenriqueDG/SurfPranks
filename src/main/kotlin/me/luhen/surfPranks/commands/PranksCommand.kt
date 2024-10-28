package me.luhen.surfPranks.commands

import me.luhen.surfPranks.SurfPranks
import me.luhen.surfPranks.utils.ChatUtils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object PranksCommand:CommandExecutor {
    override fun onCommand(sender: CommandSender, p1: Command, p2: String, args: Array<out String>): Boolean {

        if(sender is Player){

            val pranks = "fart, spit, creeper, skull, diamond, warden"

            sender.sendMessage(ChatUtils.colors(ChatUtils.replacePlaceholders(
                SurfPranks.instance.config.getString("prank-list").toString(), Pair("%prank_list%", pranks)))
            )

        }

        return true

    }

}