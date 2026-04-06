package net.kindling.accursed.impl.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public record Etching(String key, Ingredient itemNeededToCraft, int color, SoundEvent hitSound) {
    public static final Codec<Etching> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.optionalFieldOf("key", "etching.accursed.empty").forGetter(Etching::key),
                    Ingredient.CODEC.optionalFieldOf("itemNeededToCraft", Ingredient.ofItem(Items.SUNFLOWER)).forGetter(Etching::itemNeededToCraft),
                    Codec.INT.optionalFieldOf("color", 0xFFffffff).forGetter(Etching::color),
                    SoundEvent.CODEC.optionalFieldOf("hitSound", SoundEvents.BLOCK_BAMBOO_WOOD_BREAK).forGetter(Etching::hitSound)
            ).apply(instance, Etching::new)
    );
}