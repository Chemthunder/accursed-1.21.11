package net.kindling.accursed.impl.index;

import net.kindling.accursed.impl.util.Etching;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;

import java.util.ArrayList;
import java.util.List;

public interface AccursedEtchings {
    List<Etching> ETCHINGS = new ArrayList<>();

    Etching EMPTY = create("empty", Ingredient.ofItem(Items.BEDROCK), 0xFFffffff);
    Etching CARVE = create("carve", Ingredient.ofItem(Items.SPRUCE_WOOD), 0xFFC6FC6F);
    Etching BLAZE = create("blaze", Ingredient.ofItem(Items.BLAZE_POWDER), 0xFFdb8442);
    Etching VANITY = create("vanity", Ingredient.ofItem(Items.BEEF), 0xFFff6691);

    static Etching create(String key, Ingredient item, int color) {
        Etching etching = new Etching("etching.accursed." + key, item, color);

        ETCHINGS.add(etching);
        return etching;
    }

    static boolean isIngredient(Ingredient item) {
        for (Etching et : ETCHINGS) {
            if (et.itemNeededToCraft().equals(item)) {
                return true;
            }
        }
        return false;
    }

    static void init() {}
}
