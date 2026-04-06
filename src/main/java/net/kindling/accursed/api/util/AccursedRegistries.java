package net.kindling.accursed.api.util;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.kindling.accursed.impl.Accursed;
import net.kindling.accursed.impl.util.Etching;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public interface AccursedRegistries {
    RegistryKey<Registry<Etching>> etchingKey = RegistryKey.ofRegistry(Accursed.id("etching"));
    Registry<Etching> ETCHING = FabricRegistryBuilder.createSimple(etchingKey)
            .attribute(RegistryAttribute.MODDED)
            .buildAndRegister();
}
