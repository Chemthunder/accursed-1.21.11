package net.kindling.accursed.impl.index;

import net.acoyt.acornlib.api.registrants.EntityTypeRegistrant;
import net.kindling.accursed.impl.Accursed;
import net.kindling.accursed.impl.entity.InkyMothEntity;
import net.kindling.accursed.impl.entity.ThrownHatchetEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;

public interface AccursedEntities {
    EntityTypeRegistrant ENTITIES = new EntityTypeRegistrant(Accursed.MOD_ID);
//
//    EntityType<InkyMothEntity> INKY_MOTH = ENTITIES.register("inky_moth", EntityType.Builder.create(
//            InkyMothEntity::new,
//            SpawnGroup.CREATURE
//    ).dimensions(0.9f, 0.3f)
//    );
//
//    EntityType<ThrownHatchetEntity> THROWN_HATCHET = ENTITIES.register("thrown_hatchet", EntityType.Builder.create(
//                    ThrownHatchetEntity::new,
//                    SpawnGroup.MISC
//            ).dimensions(0.6f, 0.3f)
//    );

    static void init() {

    }

    static void clientInit() {

    }
}
