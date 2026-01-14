package com.evanapples.evmod.block;

import com.evanapples.evmod.EvMod;
import com.evanapples.evmod.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {
    // Add blocks here
    public static final Block PINK_GARNET_BLOCK = register(
            "pink_garnet_block",
            Block::new,
            BlockBehaviour.Properties.of().sound(SoundType.AMETHYST),
            true
    );
    public static final Block RAW_PINK_GARNET_BLOCK = register(
            "raw_pink_garnet_block",
            Block::new,
            BlockBehaviour.Properties.of().sound(SoundType.AMETHYST),
            true
    );



    // ModBlocks.register: a method that registers your block AND your block item.
    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        // Create registry key for the block
        ResourceKey<Block> blockKey = keyOfBlock(name);
        // Create block instance
        Block block = blockFactory.apply(settings.setId(blockKey));

        // Sometimes, you may not want to register an item for a block
        // e.g. a minecraft:moving_piston or minecraft:end_gateway
        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    } // end ModBlocks.register

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(EvMod.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(EvMod.MOD_ID, name));
    }

    public static void initialize() {
        EvMod.LOGGER.info("Registering Blocks & Block Items for" + EvMod.MOD_ID);

        // Register block items in the building blocks creative tab
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register((itemGroup)-> {
            itemGroup.accept(ModBlocks.PINK_GARNET_BLOCK.asItem());
            itemGroup.accept(ModBlocks.RAW_PINK_GARNET_BLOCK.asItem());
        });
    }
}
