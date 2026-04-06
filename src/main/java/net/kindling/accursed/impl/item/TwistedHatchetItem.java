package net.kindling.accursed.impl.item;

import net.acoyt.acornlib.api.item.CustomHitSoundItem;
import net.acoyt.acornlib.api.item.ModelVaryingItem;
import net.kindling.accursed.impl.Accursed;
import net.kindling.accursed.impl.index.AccursedDataComponents;
import net.kindling.accursed.impl.index.AccursedEtchings;
import net.kindling.accursed.impl.util.Etching;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.function.Consumer;

@SuppressWarnings("deprecation")
public class TwistedHatchetItem extends Item implements ModelVaryingItem, CustomHitSoundItem {
    public TwistedHatchetItem(Settings settings) {
        super(settings
                .component(AccursedDataComponents.STORED_ETCHING, AccursedEtchings.EMPTY)
        );
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        Etching etching = stack.get(AccursedDataComponents.STORED_ETCHING);

        if (etching != null) {
            if (etching != AccursedEtchings.EMPTY) {
                textConsumer.accept(Text.literal("- ").formatted(Formatting.DARK_GRAY).append(Text.translatable("etching." + etching.key()).withColor(etching.color())));
                textConsumer.accept(Text.translatable( etching.key() + ".desc").formatted(Formatting.DARK_GRAY));
            } else {
                textConsumer.accept(Text.translatable("text.accursed.empty").formatted(Formatting.DARK_GRAY));
            }
        }
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }

    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (user.isSneaking()) {
            if (user.getOffHandStack().isOf(Items.SPRUCE_LOG)) {
                user.getStackInHand(hand).set(AccursedDataComponents.STORED_ETCHING, AccursedEtchings.CARVE);
            }

            if (user.getOffHandStack().isOf(Items.BEEF)) {
                user.getStackInHand(hand).set(AccursedDataComponents.STORED_ETCHING, AccursedEtchings.VANITY);
            }

            if (user.getOffHandStack().isOf(Items.BLAZE_POWDER)) {
                user.getStackInHand(hand).set(AccursedDataComponents.STORED_ETCHING, AccursedEtchings.BLAZE);
            }

            if (user.getOffHandStack().isEmpty()) {
                user.getStackInHand(hand).set(AccursedDataComponents.STORED_ETCHING, AccursedEtchings.EMPTY);
            }

            if (world.isClient()) {
                user.swingHand(hand);
            }
        }
        return super.use(world, user, hand);
    }

    public static AttributeModifiersComponent createAttributeModifiers() {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.ATTACK_DAMAGE,
                        new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 8.0f, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.ATTACK_SPEED,
                        new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, -2.6f, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )
                .build();
    }

    public Identifier getModel(ItemStack stack, ItemDisplayContext displayContext, HeldItemContext context) {
        Etching etching = stack.get(AccursedDataComponents.STORED_ETCHING);

        if (etching != null) {
            if (etching.equals(AccursedEtchings.BLAZE)) {
                return Accursed.id("hatchet_blaze");
            }

            if (etching.equals(AccursedEtchings.VANITY)) {
                return Accursed.id("hatchet_vanity");
            }
        }

        return Accursed.id("hatchet_base");
    }

    public void playHitSound(PlayerEntity player, Entity target) {
        Etching etching = player.getMainHandStack().get(AccursedDataComponents.STORED_ETCHING);

        if (etching != null) {
            player.playSound(etching.hitSound(), 0.7f, 1);
        }
    }
}

/*
Vanity multiplies mob drobs
 */