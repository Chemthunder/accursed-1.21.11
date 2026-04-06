package net.kindling.accursed.impl.index;

import net.acoyt.acornlib.api.registrants.ItemGroupRegistrant;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.kindling.accursed.impl.Accursed;
import net.kindling.accursed.impl.util.Etching;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public interface AccursedItemGroups {
    ItemGroupRegistrant ITEM_GROUPS = new ItemGroupRegistrant(Accursed.MOD_ID);

    ItemGroup MAIN = FabricItemGroup.builder()
            .icon(() -> new ItemStack(AccursedItems.TWISTED_HATCHET))
            .displayName(Text.translatable("itemGroup.accursed").withColor(0xFFc6fc6f))
            .build();

    static void init() {
        ITEM_GROUPS.register("accursed", MAIN, AccursedItemGroups::buildItemGroup);
    }

    private static void buildItemGroup(FabricItemGroupEntries entries) {
        entries.add(AccursedItems.TWISTED_HATCHET);

        for (Etching etching : AccursedEtchings.ETCHINGS.toRegister) {
            if (etching != AccursedEtchings.EMPTY) {
                ItemStack variant = new ItemStack(AccursedItems.TWISTED_HATCHET);
                variant.set(AccursedDataComponents.STORED_ETCHING, etching);
                entries.add(variant);
            }
        }

        for (Item item : AccursedItems.ITEMS.toRegister) {
            if (item != AccursedItems.TWISTED_HATCHET) {
                entries.add(item);
            }
        }
    }
}
