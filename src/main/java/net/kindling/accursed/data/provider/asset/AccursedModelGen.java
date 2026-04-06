package net.kindling.accursed.data.provider.asset;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.kindling.accursed.impl.index.AccursedItems;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.item.Item;

public class AccursedModelGen extends FabricModelProvider {
    public AccursedModelGen(FabricDataOutput output) {
        super(output);
    }

    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {}

    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(AccursedItems.TWISTED_HATCHET, Models.HANDHELD);

        for (Item item : AccursedItems.ITEMS.toRegister) {
            if (item != AccursedItems.TWISTED_HATCHET) {
                itemModelGenerator.register(item, Models.GENERATED);
            }
        }
    }
}
