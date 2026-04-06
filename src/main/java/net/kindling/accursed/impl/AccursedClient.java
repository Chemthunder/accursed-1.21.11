package net.kindling.accursed.impl;

import net.fabricmc.api.ClientModInitializer;
import net.kindling.accursed.impl.index.AccursedEntities;
import net.kindling.accursed.impl.index.AccursedParticles;

public class AccursedClient implements ClientModInitializer {
    public void onInitializeClient() {
        AccursedEntities.clientInit();
        AccursedParticles.clientInit();
    }
}