package me.luhen.surfPranks.listeners

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityPickupItemEvent

object FakeDiamondListener: Listener {

    @EventHandler
    fun fakeDiamondPickup(event: EntityPickupItemEvent){

        if(event.entity is Player){

            val item = event.item.itemStack

            item.itemMeta?.lore?.let { lore ->

                if(item.type == Material.DIAMOND && lore.first().equals("Fake diamond")){

                    event.isCancelled = true

                    event.item.remove()
                    event.item.location.let {

                        it.world?.strikeLightning(it)

                    }

                }

            }

        }

    }

}