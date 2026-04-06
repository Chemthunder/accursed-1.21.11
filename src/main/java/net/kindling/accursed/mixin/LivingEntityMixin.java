package net.kindling.accursed.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.kindling.accursed.impl.index.AccursedDataComponents;
import net.kindling.accursed.impl.index.AccursedEtchings;
import net.kindling.accursed.impl.index.AccursedItems;
import net.kindling.accursed.impl.index.AccursedParticles;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.Attackable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.waypoint.ServerWaypoint;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements Attackable, ServerWaypoint {
    @Shadow public abstract void dropLoot(ServerWorld world, DamageSource damageSource, boolean causedByPlayer, RegistryKey<LootTable> lootTableKey);

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @WrapOperation(
            method = "dropLoot(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/damage/DamageSource;Z)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;dropLoot(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/damage/DamageSource;ZLnet/minecraft/registry/RegistryKey;)V"
            )
    )
    private void accursed$vanityLoot(LivingEntity instance, ServerWorld world, DamageSource damageSource, boolean causedByPlayer, RegistryKey<LootTable> lootTableKey, Operation<Void> original) {
        LivingEntity attacker = instance.getAttacker();

        if (attacker != null) {
            ItemStack main = attacker.getMainHandStack();

            if (main.isOf(AccursedItems.TWISTED_HATCHET)) {
                if (main.get(AccursedDataComponents.STORED_ETCHING) == AccursedEtchings.VANITY) {
                    for (int i = 0; i < 2; i++) {
                        this.dropLoot(world, damageSource, true, lootTableKey);
                    }
                } else {
                    original.call(instance, world, damageSource, causedByPlayer, lootTableKey);
                }
            }
        }
    }

    @WrapOperation(
            method = "spawnItemParticles",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;addParticleClient(Lnet/minecraft/particle/ParticleEffect;DDDDDD)V"
            )
    )
    private void accursed$customEatParticles(World instance, ParticleEffect parameters, double x, double y, double z, double velocityX, double velocityY, double velocityZ, Operation<Void> original) {
        LivingEntity living = (LivingEntity) (Object)this;

        if (living.getStackInHand(living.getActiveHand()).isOf(AccursedItems.GLOW_MEAL)) {
            original.call(instance, AccursedParticles.GLOW_MEAL_EAT, x, y, z, velocityX, velocityY, velocityZ);
        } else {
            original.call(instance, parameters, x, y, z, velocityX, velocityY, velocityZ);
        }
    }
}
