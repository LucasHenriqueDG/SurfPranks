package me.luhen.surfPranks.listeners

import me.luhen.surfPranks.pranks.FakeWarden
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent

object WardenListener: Listener {

    @EventHandler
    fun wardenDamage(event: EntityDamageByEntityEvent){

        if(event.damager.type ==  EntityType.WARDEN && event.entity.type == EntityType.PLAYER){

            val warden = event.damager

            if(FakeWarden.wardens.contains(warden)){

                event.isCancelled = true

            }

        }

    }

}