package net.kindling.accursed.data.provider.asset;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.kindling.accursed.impl.index.AccursedEtchings;
import net.kindling.accursed.impl.index.AccursedItems;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class AccursedLangGen extends FabricLanguageProvider {
    public AccursedLangGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        AccursedItems.ITEMS.registerLang(wrapperLookup, translationBuilder);
        AccursedEtchings.ETCHINGS.registerLang(wrapperLookup, translationBuilder);

        translationBuilder.add("itemGroup.accursed", "Accursed");

        translationBuilder.add(AccursedEtchings.CARVE.key() + ".desc", "Allows for the Hatchet to be thrown.");
        translationBuilder.add(AccursedEtchings.BLAZE.key() + ".desc", "Sets attacked enemies on fire.");
        translationBuilder.add(AccursedEtchings.VANITY.key() + ".desc", "Mob drops have a chance to be doubled, or even tripled.");

        translationBuilder.add("text.accursed.empty", "Etchingless");
    }
}
