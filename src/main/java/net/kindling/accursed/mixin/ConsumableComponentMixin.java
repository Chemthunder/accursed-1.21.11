package net.kindling.accursed.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.kindling.accursed.impl.index.AccursedItems;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ConsumableComponent.class)
public abstract class ConsumableComponentMixin {

    @WrapOperation(
            method = "spawnParticlesAndPlaySound",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )
    )
    private void getEatSound(LivingEntity instance, SoundEvent soundEvent, float v, float f, Operation<Void> original) {
        if (instance.getStackInHand(instance.getActiveHand()).isOf(AccursedItems.GLOW_MEAL)) {
            original.call(instance, SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK, v, f);
        } else {
            original.call(instance, soundEvent, v, f);
        }
    }
}
