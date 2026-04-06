package net.kindling.accursed.api.util;

import net.kindling.accursed.impl.index.AccursedDataComponents;
import net.kindling.accursed.impl.util.Etching;
import net.minecraft.item.ItemStack;

public class EtchingHelper {
    public static boolean hasEtching(ItemStack stack, Etching etching) {
        return stack.get(AccursedDataComponents.STORED_ETCHING) == etching && etching != null;
    }
}
