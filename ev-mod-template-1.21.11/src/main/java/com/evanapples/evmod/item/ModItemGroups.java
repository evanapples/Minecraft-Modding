package com.evanapples.evmod.item;

import com.evanapples.evmod.EvMod;
import com.evanapples.evmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroups {

    // Create a ResourceKey of type CreativeModeTab
    public static final ResourceKey<CreativeModeTab>  PINK_GARNET_ITEM_GROUP_KEY =
            ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(EvMod.MOD_ID, "pink_garnet_item_group_key"));
    public static final CreativeModeTab PINK_GARNET_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.RAW_PINK_GARNET))
            .title(Component.translatable("itemGroup.evmod.pink_garnet_item_group"))
            .build();




    public static void initialize() {
        EvMod.LOGGER.info("Registering Item Groups for " + EvMod.MOD_ID);

        // Register the pink garnet item group
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, PINK_GARNET_ITEM_GROUP_KEY, PINK_GARNET_ITEM_GROUP);

        // Register items to pink garnet item group

        ItemGroupEvents.modifyEntriesEvent(PINK_GARNET_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.accept(ModItems.RAW_PINK_GARNET);
            itemGroup.accept(ModItems.PINK_GARNET);
            itemGroup.accept(ModBlocks.PINK_GARNET_BLOCK);
            itemGroup.accept(ModBlocks.RAW_PINK_GARNET_BLOCK);
        });


    }
}
