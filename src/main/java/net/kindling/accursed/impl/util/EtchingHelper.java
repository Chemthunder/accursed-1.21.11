package net.kindling.accursed.impl.util;

import net.kindling.accursed.impl.index.AccursedDataComponents;
import net.kindling.accursed.impl.index.AccursedEtchings;
import net.minecraft.item.ItemStack;

public class EtchingHelper {
    public static Etching getNext(Etching etching) {
        return AccursedEtchings.ETCHINGS.get(AccursedEtchings.ETCHINGS.indexOf(etching) + 1);
    }

    public static boolean hasEtching(ItemStack stack, Etching etching) {
        return stack.get(AccursedDataComponents.STORED_ETCHING) == etching && etching != null;
    }
}
