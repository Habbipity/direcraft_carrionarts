package com.ohmyjarona.dire_vulture.item;

import com.ohmyjarona.dire_vulture.DirecraftVultureCulture;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItem {
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DirecraftVultureCulture.MODID);
	
	public static final DeferredItem<Item> TESTITEM = ITEMS.register("test", 
			() -> new Item(new Item.Properties()));
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
		
	}
}

