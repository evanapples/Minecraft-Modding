package com.evanapples.evmod.item;

import com.evanapples.evmod.EvMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    // IMPLEMENT NEW ITEMS HERE
    public static final Item PINK_GARNET = register("pink_garnet", Item::new, new Item.Properties());
    public static final Item RAW_PINK_GARNET = register("raw_pink_garnet", Item::new, new Item.Properties());



    public static <GenericItem extends Item> GenericItem register(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings) {
        // Create item key, ex. pink_garnet.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(EvMod.MOD_ID, name));

        // Create the item instance
        GenericItem item = itemFactory.apply(settings.setId(itemKey)); // equivalent to new Item(settings);

        //Register the item
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        EvMod.LOGGER.info("Registering Mod Items for " + EvMod.MOD_ID);

        // Register items in creative item group (ingredients)
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register((itemGroup)-> {
            itemGroup.accept(ModItems.PINK_GARNET);
            itemGroup.accept(ModItems.RAW_PINK_GARNET);
            });
    }
}
