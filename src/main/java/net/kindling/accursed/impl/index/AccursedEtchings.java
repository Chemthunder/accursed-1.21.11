package net.kindling.accursed.impl.index;

import net.kindling.accursed.compat.acornlib.EtchingRegistrant;
import net.kindling.accursed.impl.Accursed;
import net.kindling.accursed.impl.util.Etching;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;

public interface AccursedEtchings {
    EtchingRegistrant ETCHINGS = new EtchingRegistrant(Accursed.MOD_ID);

    Etching EMPTY = ETCHINGS.register("empty", Ingredient.ofItem(Items.BEDROCK), 0xFFffffff, SoundEvents.BLOCK_BAMBOO_WOOD_BREAK);
    Etching CARVE = ETCHINGS.register("carve", Ingredient.ofItem(Items.SPRUCE_WOOD), 0xFFC6FC6F, SoundEvents.BLOCK_IRON_STEP);
    Etching BLAZE = ETCHINGS.register("blaze", Ingredient.ofItem(Items.BLAZE_POWDER), 0xFFdb8442, SoundEvents.ENTITY_BLAZE_SHOOT);
    Etching VANITY = ETCHINGS.register("vanity", Ingredient.ofItem(Items.BEEF), 0xFFff6691, SoundEvents.BLOCK_MANGROVE_ROOTS_BREAK);

    static void init() {}
}
