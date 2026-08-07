package com.ohmyjarona.direcraft_carrionarts.block.custom;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CustomBlock extends Block{

	public CustomBlock(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	public Item.Properties buildCustomBlockItemProperties() {
		return new Item.Properties();
	}
	
	public BlockItem buildCustomBlockItem() {
		return new BlockItem(this, buildCustomBlockItemProperties());
	}
	
}
