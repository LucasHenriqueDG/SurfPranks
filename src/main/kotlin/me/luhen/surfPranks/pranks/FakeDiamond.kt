package me.luhen.surfPranks.pranks

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class FakeDiamond {

    fun spawnFakeDiamond(player: Player){

        val diamond = ItemStack(Material.DIAMOND)
        val meta = diamond.itemMeta

        val lore = mutableListOf("Fake diamond")

        meta?.lore = lore
        diamond.itemMeta = meta

        val spawnLocation = player.getLineOfSight(setOf(Material.AIR), 5).last().location

        spawnLocation.world?.dropItem(spawnLocation, diamond)


    }

}