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

        translationBuilder.add(AccursedEtchings.EMPTY.key(), "Empty");
    }
}
