package me.luhen.surfPranks.commands

import me.luhen.surfPranks.SurfPranks
import me.luhen.surfPranks.pranks.FakeCreeper
import me.luhen.surfPranks.pranks.Fart
import me.luhen.surfPranks.pranks.SpiningHead
import me.luhen.surfPranks.pranks.Spit
import me.luhen.surfPranks.utils.ChatUtils
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object PrankCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender, p1: Command, p2: String, args: Array<out String>): Boolean {

        if(sender is Player){

            if(args.isNotEmpty()) {

                when (args[0]) {

                    "fart" -> {

                        if(args.size == 1) {

                            if(sender.hasPermission("surfpranks.self")) Fart.playerFart(sender)
                            else sender.sendMessage(ChatUtils.colors(
                                SurfPranks.instance.config.getString("no-permission-message").toString())
                            )

                        } else {

                            val targetPlayer = Bukkit.getPlayer(args[1])

                            targetPlayer?.let{

                                if(sender.hasPermission("surfpranks.others")) Fart.playerFart(it)
                                    else sender.sendMessage(ChatUtils.colors(
                                    SurfPranks.instance.config.getString("no-permission-message").toString())
                                )

                            } ?: sender.sendMessage(ChatUtils.colors(
                                SurfPranks.instance.config.getString("player-not-found-message").toString())
                            )

                        }

                    }

                    "spit" -> {

                        if(args.size == 1) {

                            if(sender.hasPermission("surfpranks.self")) Spit.spit(sender)
                            else sender.sendMessage(ChatUtils.colors(
                                SurfPranks.instance.config.getString("no-permission-message").toString())
                            )

                        } else {

                            val targetPlayer = Bukkit.getPlayer(args[1])

                            targetPlayer?.let{

                                if(sender.hasPermission("surfpranks.others")) Spit.spit(it)
                                    else sender.sendMessage(ChatUtils.colors(
                                    SurfPranks.instance.config.getString("no-permission-message").toString())
                                )

                            } ?: sender.sendMessage(ChatUtils.colors(
                                SurfPranks.instance.config.getString("player-not-found-message").toString())
                            )

                        }

                    }

                    "creeper" -> {

                        if(args.size == 1) {

                            if(sender.hasPermission("surfpranks.self")) FakeCreeper.spawnFakeCreeper(sender)
                            else sender.sendMessage(ChatUtils.colors(
                                SurfPranks.instance.config.getString("no-permission-message").toString())
                            )

                        } else {

                            val targetPlayer = Bukkit.getPlayer(args[1])

                            targetPlayer?.let{

                                if(sender.hasPermission("surfpranks.others")) FakeCreeper.spawnFakeCreeper(it)
                                    else sender.sendMessage(ChatUtils.colors(
                                    SurfPranks.instance.config.getString("no-permission-message").toString())
                                )

                            } ?: sender.sendMessage(ChatUtils.colors(
                                SurfPranks.instance.config.getString("player-not-found-message").toString())
                            )

                        }

                    }

                    "skull" -> {

                        if(args.size == 1) {

                            if(sender.hasPermission("surfpranks.self")) SpiningHead.spawnHead(sender)
                            else sender.sendMessage(ChatUtils.colors(
                                SurfPranks.instance.config.getString("no-permission-message").toString())
                            )


                        } else {

                            val targetPlayer = Bukkit.getPlayer(args[1])

                            targetPlayer?.let{

                                if(sender.hasPermission("surfpranks.others")) SpiningHead.spawnHead(it)
                                    else sender.sendMessage(ChatUtils.colors(
                                    SurfPranks.instance.config.getString("no-permission-message").toString())
                                )

                            } ?: sender.sendMessage(ChatUtils.colors(
                                SurfPranks.instance.config.getString("player-not-found-message").toString())
                            )

                        }

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