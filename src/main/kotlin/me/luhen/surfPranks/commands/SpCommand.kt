package me.luhen.surfPranks.commands

import me.luhen.surfPranks.SurfPranks
import me.luhen.surfPranks.utils.ChatUtils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object SpCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender, p1: Command, p2: String, args: Array<out String>): Boolean {

        if(args.size == 1) {

            if(args[0] == "reload") {

                if (sender.hasPermission("surfpranks.adm")) {

                    SurfPranks.instance.reloadConfig()

                    SurfPranks.instance.let {

                        it.disabledWorlds.clear()

                        it.config.getStringList("disabled-worlds").forEach{ world ->

                            it.disabledWorlds.add(world)

                        }

                    }

                    if (sender is Player) {

                        sender.sendMessage(ChatUtils.colors("&b[Surf Pranks] &dConfig file reloaded!"))

                    } else {

                        SurfPranks.instance.logger.info("[Surf Pranks] Config file reloaded!")

                    }

                }

            } else {

                sender.sendMessage("&b[Surf Pranks] &cWrong command usage.")

            }

        } else {

            sender.sendMessage("&b[Surf Pranks] &cWrong command usage.")

        }

        return true

    }

}