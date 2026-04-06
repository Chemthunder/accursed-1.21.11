package net.kindling.accursed.compat.acornlib;

import net.acoyt.acornlib.api.template.RegistrantBase;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.kindling.accursed.api.util.AccursedRegistries;
import net.kindling.accursed.impl.util.Etching;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.sound.SoundEvent;

import static net.acoyt.acornlib.api.util.MiscUtils.formatString;

public class EtchingRegistrant extends RegistrantBase<Etching> {
    public EtchingRegistrant(String modId) {
        super(modId, AccursedRegistries.ETCHING);
    }

    public Etching register(String name, Ingredient item, int color, SoundEvent hitSound) {
        Etching etching = new Etching(name, item, color, hitSound);
        this.toRegister.add(etching);
        return etching;
    }

    public void registerLang(RegistryWrapper.WrapperLookup registries, FabricLanguageProvider.TranslationBuilder builder) {
        this.toRegister.forEach(etching -> {
            builder.add("etching." + etching.key(), formatString(etching.key()));
        });
    }

    public boolean itemIsIngredient(Ingredient item) {
        for (Etching et : this.toRegister) {
            if (et.itemNeededToCraft().equals(item)) {
                return true;
            }
        }
        return false;
    }
}
