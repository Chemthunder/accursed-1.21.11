package net.kindling.accursed.impl.index;

import net.acoyt.acornlib.api.registrants.ComponentTypeRegistrant;
import net.kindling.accursed.impl.Accursed;
import net.kindling.accursed.impl.util.Etching;
import net.minecraft.component.ComponentType;

public interface AccursedDataComponents {
    ComponentTypeRegistrant DATA_COMPONENTS = new ComponentTypeRegistrant(Accursed.MOD_ID);

    ComponentType<Etching> STORED_ETCHING = DATA_COMPONENTS.register("stored_etching", etchingBuilder -> etchingBuilder.codec(Etching.CODEC));

    static void init() {}
}
