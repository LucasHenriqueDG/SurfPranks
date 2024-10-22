package me.luhen.surfPranks.commands

import me.luhen.surfPranks.pranks.Fart
import me.luhen.surfPranks.utils.ChatUtils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object PrankCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender, p1: Command, p2: String, args: Array<out String>): Boolean {

        if(sender is Player){

            if(args.size == 1){

                if(args[0] == "fart"){

                    Fart.playerFart(sender)

                } else {

                    sender.sendMessage(ChatUtils.colors("&b[Surf Pranks] &cWrong argument, try &a/pranks"))

                }

            } else {

                sender.sendMessage(ChatUtils.colors("&b[Surf Pranks] &dTry /prank &f<prankname>"))

            }

        }

        return true

    }

}