package net.kindling.accursed.impl.index;

import net.acoyt.acornlib.api.registrants.ItemRegistrant;
import net.kindling.accursed.impl.Accursed;
import net.kindling.accursed.impl.item.TwistedHatchetItem;
import net.minecraft.item.Item;

public interface AccursedItems {
    ItemRegistrant ITEMS = new ItemRegistrant(Accursed.MOD_ID);

    Item TWISTED_HATCHET = ITEMS.register("twisted_hatchet", TwistedHatchetItem::new, new Item.Settings().maxCount(1));

    static void init() {}
}