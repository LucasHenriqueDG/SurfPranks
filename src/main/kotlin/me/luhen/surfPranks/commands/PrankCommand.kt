package me.luhen.surfPranks.commands

import me.luhen.surfPranks.SurfPranks
import me.luhen.surfPranks.pranks.Fart
import me.luhen.surfPranks.pranks.Spit
import me.luhen.surfPranks.utils.ChatUtils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object PrankCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender, p1: Command, p2: String, args: Array<out String>): Boolean {

        if(sender is Player){

            if(args.size == 1) {

                when (args[0]) {

                    "fart" -> {

                        Fart.playerFart(sender)

                    }

                    "spit" -> {

                        Spit.spit(sender)

                    }

                    else -> {

                        sender.sendMessage(
                            ChatUtils.colors(
                                SurfPranks.instance.config.getString("wrong-command-usage-message").toString()
                            )
                        )

                    }

                }

            } else {

                sender.sendMessage(ChatUtils.colors(
                    SurfPranks.instance.config.getString("command-usage-message").toString())
                )

            }

        }

        return true

    }

}