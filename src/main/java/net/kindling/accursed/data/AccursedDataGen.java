package net.kindling.accursed.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.kindling.accursed.data.provider.asset.AccursedLangGen;
import net.kindling.accursed.data.provider.asset.AccursedModelGen;

public class AccursedDataGen implements DataGeneratorEntrypoint {
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(AccursedLangGen::new);
        pack.addProvider(AccursedModelGen::new);
	}
}
