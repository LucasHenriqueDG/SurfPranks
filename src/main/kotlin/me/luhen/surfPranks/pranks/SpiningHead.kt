package me.luhen.surfPranks.pranks

import me.luhen.surfPranks.tasks.SpiningHeadTasks
import me.luhen.surfPranks.utils.TimeUtils
import org.bukkit.Material
import org.bukkit.entity.ArmorStand
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

object SpiningHead {

    fun spawnHead(player: Player) {

        if (TimeUtils.isPlayerInDelay(player)) {

            val world = player.world
            val direction = player.location.direction.clone().normalize()
            val headLoc = player.location.clone().add(direction.multiply(6.1))
            val targetLoc = player.location.toVector().subtract(headLoc.toVector()).normalize()

            val armorStand: Entity = world.spawn(headLoc, ArmorStand::class.java) { stand ->

                stand.isVisible = false
                stand.isMarker = true
                stand.setGravity(false)
                stand.isSmall = false
                stand.isInvulnerable = true

                val equipment = stand.equipment
                equipment?.helmet = ItemStack(Material.WITHER_SKELETON_SKULL)

            }

            SpiningHeadTasks.spinningHead(armorStand, player, targetLoc)

        }

    }

}