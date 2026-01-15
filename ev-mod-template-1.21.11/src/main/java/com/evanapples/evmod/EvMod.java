package com.evanapples.evmod;

import com.evanapples.evmod.block.ModBlocks;
import com.evanapples.evmod.item.ModItemGroups;
import com.evanapples.evmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EvMod implements ModInitializer {
	public static final String MOD_ID = "evmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {

		ModItems.initialize();
		ModBlocks.initialize();
		ModItemGroups.initialize();

	}
}