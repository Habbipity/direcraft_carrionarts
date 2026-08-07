package com.ohmyjarona.direcraft_carrionarts.item.custom;

import java.util.function.Supplier;

import com.google.common.base.Suppliers;
import com.ohmyjarona.direcraft_carrionarts.item.ModArmorMaterial;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.block.Block;

public class SkullBlockItem extends BlockItem implements Equipable{

	Holder<ArmorMaterial> material = ModArmorMaterial.BONE_LAMELLAR_MATERIAL;
	ArmorItem.Type type = ArmorItem.Type.HELMET;
	Supplier<ItemAttributeModifiers> defaultModifiers;
	
	public SkullBlockItem(Block block, Properties properties) {
		super(block, properties);
		defaultModifiers = Suppliers.memoize(
                () -> {
                    int i = material.value().getDefense(type);
                    float f = material.value().toughness();
                    ItemAttributeModifiers.Builder itemattributemodifiers$builder = ItemAttributeModifiers.builder();
                    EquipmentSlotGroup equipmentslotgroup = EquipmentSlotGroup.bySlot(type.getSlot());
                    ResourceLocation resourcelocation = ResourceLocation.withDefaultNamespace("armor." + type.getName());
                    itemattributemodifiers$builder.add(
                        Attributes.ARMOR, new AttributeModifier(resourcelocation, (double)i, AttributeModifier.Operation.ADD_VALUE), equipmentslotgroup
                    );
                    itemattributemodifiers$builder.add(
                        Attributes.ARMOR_TOUGHNESS, new AttributeModifier(resourcelocation, (double)f, AttributeModifier.Operation.ADD_VALUE), equipmentslotgroup
                    );
                    float f1 = material.value().knockbackResistance();
                    if (f1 > 0.0F) {
                        itemattributemodifiers$builder.add(
                            Attributes.KNOCKBACK_RESISTANCE,
                            new AttributeModifier(resourcelocation, (double)f1, AttributeModifier.Operation.ADD_VALUE),
                            equipmentslotgroup
                        );
                    }

                    return itemattributemodifiers$builder.build();
                }
            );
	}

	
    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return this.defaultModifiers.get();
    }
	
	@Override
	public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
	}



}
