package net.kindling.accursed.impl.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.kindling.accursed.impl.index.AccursedDataComponents;
import net.kindling.accursed.impl.index.AccursedEtchings;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;

public record Etching(String key, Ingredient itemNeededToCraft, int color) {
    public static final Codec<Etching> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.optionalFieldOf("key", "etching.accursed.empty").forGetter(Etching::key),
                    Ingredient.CODEC.optionalFieldOf("itemNeededToCraft", Ingredient.ofItem(Items.SUNFLOWER)).forGetter(Etching::itemNeededToCraft),
                    Codec.INT.optionalFieldOf("color", 0xFFffffff).forGetter(Etching::color)
            ).apply(instance, Etching::new)
    );
}