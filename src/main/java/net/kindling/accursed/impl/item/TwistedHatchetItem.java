package net.kindling.accursed.impl.item;

import net.kindling.accursed.data.AccursedDataGen;
import net.kindling.accursed.impl.index.AccursedDataComponents;
import net.kindling.accursed.impl.index.AccursedEtchings;
import net.kindling.accursed.impl.util.Etching;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.function.Consumer;

@SuppressWarnings("deprecation")
public class TwistedHatchetItem extends Item {
    public TwistedHatchetItem(Settings settings) {
        super(settings
                .component(AccursedDataComponents.STORED_ETCHING, AccursedEtchings.EMPTY)
        );
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        var component = stack.get(AccursedDataComponents.STORED_ETCHING);

        if (component != null) {
            textConsumer.accept(Text.translatable(component.key()).withColor(component.color()));
            textConsumer.accept(Text.translatable(component.itemNeededToCraft().toString().trim()).formatted(Formatting.DARK_GRAY));
        }
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }
}
