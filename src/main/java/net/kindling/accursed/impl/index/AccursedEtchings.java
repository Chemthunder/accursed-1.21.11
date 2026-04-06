package net.kindling.accursed.impl.index;

import net.kindling.accursed.impl.util.Etching;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;

import java.util.ArrayList;
import java.util.List;

public interface AccursedEtchings {
    List<Etching> ETCHINGS = new ArrayList<>();

    Etching EMPTY = create("etching.accursed.empty", Ingredient.ofItem(Items.TORCHFLOWER), 0xFFffffff);

    static Etching create(String key, Ingredient item, int color) {
        Etching etching = new Etching(key, item, color);

        ETCHINGS.add(etching);
        return etching;
    }

    static void init() {}
}
