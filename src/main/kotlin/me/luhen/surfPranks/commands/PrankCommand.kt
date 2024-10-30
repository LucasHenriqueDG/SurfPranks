package me.luhen.surfPranks.commands

import me.luhen.surfPranks.SurfPranks
import me.luhen.surfPranks.pranks.*
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

                            if(sender.hasPermission("surfpranks.self")) Fart.playerFart(sender, sender)
                            else sender.sendMessage(ChatUtils.colors(
                                SurfPranks.instance.config.getString("no-permission-message").toString())
                            )

                        } else {

                            val targetPlayer = Bukkit.getPlayer(args[1])

                            targetPlayer?.let{

                                if(sender.hasPermission("surfpranks.others")) Fart.playerFart(sender, it)
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

                            if(sender.hasPermission("surfpranks.self")) Spit.spit(sender, sender)
                            else sender.sendMessage(ChatUtils.colors(
                                SurfPranks.instance.config.getString("no-permission-message").toString())
                            )

                        } else {

                            val targetPlayer = Bukkit.getPlayer(args[1])

                            targetPlayer?.let{

                                if(sender.hasPermission("surfpranks.others")) Spit.spit(sender, it)
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

                            if(sender.hasPermission("surfpranks.self")) FakeCreeper.spawnFakeCreeper(sender, sender)
                            else sender.sendMessage(ChatUtils.colors(
                                SurfPranks.instance.config.getString("no-permission-message").toString())
                            )

                        } else {

                            val targetPlayer = Bukkit.getPlayer(args[1])

                            targetPlayer?.let{

                                if(sender.hasPermission("surfpranks.others")) FakeCreeper.spawnFakeCreeper(sender, it)
                                    else sender.sendMessage(ChatUtils.colors(
                                    SurfPranks.instance.config.getString("no-permission-message").toString())
                                )

                            } ?: sender.sendMessage(ChatUtils.colors(
                                SurfPranks.instance.config.getString("player-not-found-message").toString())
                            )

                        }

                    }

                    "tnt" -> {

                        if(args.size == 1) {

                            if(sender.hasPermission("surfpranks.self")) FakeTnt.fakeTnt(sender, sender)
                            else sender.sendMessage(ChatUtils.colors(
                                SurfPranks.instance.config.getString("no-permission-message").toString())
                            )


                        } else {

                            val targetPlayer = Bukkit.getPlayer(args[1])

                            targetPlayer?.let{

                                if(sender.hasPermission("surfpranks.others")) FakeTnt.fakeTnt(sender, it)
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

                            if(sender.hasPermission("surfpranks.self")) SpiningHead.spawnHead(sender, sender)
                            else sender.sendMessage(ChatUtils.colors(
                                SurfPranks.instance.config.getString("no-permission-message").toString())
                            )


                        } else {

                            val targetPlayer = Bukkit.getPlayer(args[1])

                            targetPlayer?.let{

                                if(sender.hasPermission("surfpranks.others")) SpiningHead.spawnHead(sender, it)
                                    else sender.sendMessage(ChatUtils.colors(
                                    SurfPranks.instance.config.getString("no-permission-message").toString())
                                )

                            } ?: sender.sendMessage(ChatUtils.colors(
                                SurfPranks.instance.config.getString("player-not-found-message").toString())
                            )

                        }

                    }

                    "diamond" -> {

                        if (args.size == 1) {

                            if (sender.hasPermission("surfpranks.self")) FakeDiamond().spawnFakeDiamond(
                                sender, sender)
                            else sender.sendMessage(
                                ChatUtils.colors(
                                    SurfPranks.instance.config.getString("no-permission-message").toString()
                                )
                            )

                        } else {

                            val targetPlayer = Bukkit.getPlayer(args[1])

                            targetPlayer?.let {

                                if (sender.hasPermission("surfpranks.others")) FakeDiamond().spawnFakeDiamond(
                                    sender, it)
                                else sender.sendMessage(
                                    ChatUtils.colors(
                                        SurfPranks.instance.config.getString("no-permission-message").toString()
                                    )
                                )

                            } ?: sender.sendMessage(
                                ChatUtils.colors(
                                    SurfPranks.instance.config.getString("player-not-found-message").toString()
                                )
                            )

                        }

                    }

                    "warden" -> {

                        if (args.size == 1) {

                            if (sender.hasPermission("surfpranks.self")) FakeWarden.spawnWarden(
                                sender, sender)
                            else sender.sendMessage(
                                ChatUtils.colors(
                                    SurfPranks.instance.config.getString("no-permission-message").toString()
                                )
                            )

                        } else {

                            val targetPlayer = Bukkit.getPlayer(args[1])

                            targetPlayer?.let {

                                if (sender.hasPermission("surfpranks.others")) FakeWarden.spawnWarden(
                                    sender, it)
                                else sender.sendMessage(
                                    ChatUtils.colors(
                                        SurfPranks.instance.config.getString("no-permission-message").toString()
                                    )
                                )

                            } ?: sender.sendMessage(
                                ChatUtils.colors(
                                    SurfPranks.instance.config.getString("player-not-found-message").toString()
                                )
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