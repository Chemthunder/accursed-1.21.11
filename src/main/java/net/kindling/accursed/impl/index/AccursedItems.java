package net.kindling.accursed.impl.index;

import net.acoyt.acornlib.api.registrants.ItemRegistrant;
import net.kindling.accursed.impl.Accursed;
import net.kindling.accursed.impl.item.*;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;

public interface AccursedItems {
    ItemRegistrant ITEMS = new ItemRegistrant(Accursed.MOD_ID);

    Item TWISTED_HATCHET = ITEMS.register("twisted_hatchet", TwistedHatchetItem::new, new Item.Settings().maxCount(1).attributeModifiers(TwistedHatchetItem.createAttributeModifiers()));

    Item METALLIC_TAPROOT = ITEMS.register("metallic_taproot", ResourceItem::new, new Item.Settings().maxCount(16));
    Item METALLIC_TAPROOT_CHUNK = ITEMS.register("metallic_taproot_chunk", ResourceItem::new, new Item.Settings());

    Item TWISTED_NUGGET = ITEMS.register("twisted_nugget", ResourceItem::new, new Item.Settings());
    Item TWISTED_INGOT = ITEMS.register("twisted_ingot", ResourceItem::new, new Item.Settings());

    Item STRANGE_YARN = ITEMS.register("strange_yarn", ResourceItem::new, new Item.Settings());

    Item GLOW_BONE = ITEMS.register("glow_bone", ResourceItem::new, new Item.Settings());
    Item GLOW_MEAL = ITEMS.register("glow_meal", ResourceItem::new, new Item.Settings().food(new FoodComponent.Builder().alwaysEdible().build()));

    Item GROTESQUE_LARD = ITEMS.register("grotesque_lard", ResourceItem::new, new Item.Settings());

    Item PECULIAR_MEAT = ITEMS.register("peculiar_meat", ResourceItem::new, new Item.Settings());
    Item PECULIAR_MEAT_CHUNK = ITEMS.register("peculiar_meat_chunk", ResourceItem::new, new Item.Settings());

    static void init() {}
}