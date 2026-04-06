package net.kindling.accursed.impl.entity;

import net.kindling.accursed.impl.index.AccursedItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class ThrownHatchetEntity extends ThrownItemEntity {
    public ThrownHatchetEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    protected Item getDefaultItem() {
        return AccursedItems.TWISTED_HATCHET;
    }

    public boolean hasNoGravity() {
        return true;
    }
}
