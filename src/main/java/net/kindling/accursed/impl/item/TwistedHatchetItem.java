package net.kindling.accursed.impl.item;

import net.kindling.accursed.impl.index.AccursedDataComponents;
import net.kindling.accursed.impl.index.AccursedEtchings;
import net.kindling.accursed.impl.util.Etching;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.function.Consumer;

@SuppressWarnings("deprecation")
public class TwistedHatchetItem extends Item {
    public TwistedHatchetItem(Settings settings) {
        super(settings
                .component(AccursedDataComponents.STORED_ETCHING, AccursedEtchings.EMPTY)
        );
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        Etching etching = stack.get(AccursedDataComponents.STORED_ETCHING);

        if (etching != null) {
            if (etching != AccursedEtchings.EMPTY) {
                textConsumer.accept(Text.literal("- ").formatted(Formatting.DARK_GRAY).append(Text.translatable(etching.key()).withColor(etching.color())));
                textConsumer.accept(Text.translatable(etching.key() + ".desc").formatted(Formatting.DARK_GRAY));
            } else {
                textConsumer.accept(Text.translatable("text.accursed.empty").formatted(Formatting.DARK_GRAY));
            }
        }
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }

    public ActionResult use(World world, PlayerEntity user, Hand hand) {
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
        return super.use(world, user, hand);
    }

    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Etching etching = stack.get(AccursedDataComponents.STORED_ETCHING);

        if (etching == AccursedEtchings.VANITY) {
            if (attacker instanceof PlayerEntity player) {
                player.getHungerManager().add(player.getEntityWorld().getRandom().nextBetween(2, 6), 1.0f);
            }
        }

        if (etching == AccursedEtchings.BLAZE) {

        }
        super.postHit(stack, target, attacker);
    }
}