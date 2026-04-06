package net.kindling.accursed.impl;

import net.fabricmc.api.ModInitializer;

import net.kindling.accursed.impl.index.AccursedDataComponents;
import net.kindling.accursed.impl.index.AccursedEtchings;
import net.kindling.accursed.impl.index.AccursedItems;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Accursed implements ModInitializer {
	public static final String MOD_ID = "accursed";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {
        AccursedItems.init();
        AccursedDataComponents.init();

        /* Custom */
        AccursedEtchings.init();

		LOGGER.info("Hello Fabric world!");
	}

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}