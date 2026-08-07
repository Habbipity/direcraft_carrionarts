package com.ohmyjarona.direcraft_carrionarts.block.custom;

import com.ohmyjarona.direcraft_carrionarts.block.DirectionalBlock;
import com.ohmyjarona.direcraft_carrionarts.item.ModArmorMaterial;
import com.ohmyjarona.direcraft_carrionarts.item.custom.SkullBlockItem;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SkullBlock extends DirectionalBlock{
    public SkullBlock(Properties properties) {
		super(properties);
	}

	@Override
    protected boolean useShapeForLightOcclusion(BlockState state) {
        return false;
    }
	
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Block.box(4.0, 0.0, 4.0, 12.0, 8.0, 12.0);
    }

	@Override
	public Item.Properties buildCustomBlockItemProperties() {
		return new Item.Properties();
	}
		
	
	@Override
	public BlockItem buildCustomBlockItem() {
		BlockItem newBlockItem = new SkullBlockItem(this, buildCustomBlockItemProperties());
		
		return newBlockItem;
	}
    
}
