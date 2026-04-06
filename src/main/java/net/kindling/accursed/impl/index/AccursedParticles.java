package net.kindling.accursed.impl.index;

import net.acoyt.acornlib.api.registrants.ParticleTypeRegistrant;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.kindling.accursed.impl.Accursed;
import net.minecraft.client.particle.EndRodParticle;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public interface AccursedParticles {
    SimpleParticleType GLOW_MEAL_EAT = FabricParticleTypes.simple(true);

    private static void create(String name, ParticleType<?> particle) {
        Registry.register(Registries.PARTICLE_TYPE, Accursed.id(name), particle);
    }

    static void init() {
        create("glow_meal_eat", GLOW_MEAL_EAT);
    }

    static void clientInit() {
        ParticleFactoryRegistry.getInstance().register(GLOW_MEAL_EAT, EndRodParticle.Factory::new);
    }
}