package com.ohmyjarona.direcraft_carrionarts;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

@EventBusSubscriber(modid = "direcraft_carrionarts")
public class CowDroppingCowChips {
	int cowPoopTime = 6000;
    public static final Logger LOGGER = LogUtils.getLogger();
	
	@SubscribeEvent
	public static void onEntityTickEvent(EntityTickEvent.Post event) {
		Entity entity = event.getEntity();
		Level level = entity.level();
		
		if (entity.getType() == EntityType.COW) {

		}
		
		

	}
}
