package net.kindling.accursed.impl;

import net.acoyt.acornlib.api.ALib;
import net.fabricmc.api.ModInitializer;
import net.kindling.accursed.impl.index.*;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Accursed implements ModInitializer {
	public static final String MOD_ID = "accursed";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
//
//    public static final ALib.ModMenuData DATA = new ALib.ModMenuData(
//            Text.literal("Accursed").withColor(0xFFc6fc6f),
//            Text.literal("A decor mod about all things dark.").formatted(Formatting.ITALIC),
//            Text.literal("Description for Accursed")
//    );

	public void onInitialize() {
        AccursedItems.init();
        AccursedDataComponents.init();
        AccursedItemGroups.init();
        AccursedEntities.init();
        AccursedParticles.init();

        /* Custom */
        AccursedEtchings.init();

		LOGGER.info("Hello Fabric world!");

        ALib.registerModMenu(MOD_ID, 0xFFc6fc6f);
	}

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}