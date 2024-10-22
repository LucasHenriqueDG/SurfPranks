package me.luhen.surfPranks.commands

import me.luhen.surfPranks.utils.ChatUtils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object PranksCommand:CommandExecutor {
    override fun onCommand(sender: CommandSender, p1: Command, p2: String, args: Array<out String>): Boolean {

        if(sender is Player){

            sender.sendMessage(ChatUtils.colors("&b[Surf Pranks] &dCurrent available pranks: &6fart."))

        }

        return true

    }
}