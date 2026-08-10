package com.ohmyjarona.direcraft_carrionarts;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.ohmyjarona.direcraft_carrionarts.block.ModBlock;
import com.ohmyjarona.direcraft_carrionarts.block.ModCustomBlock;
import com.ohmyjarona.direcraft_carrionarts.block.custom.entity.ModBlockEntity;
import com.ohmyjarona.direcraft_carrionarts.block.custom.entity.renderer.ChoppingStumpBlockEntityRenderer;
import com.ohmyjarona.direcraft_carrionarts.fluid.ModFluid;
import com.ohmyjarona.direcraft_carrionarts.fluid.ModFluidType;
import com.ohmyjarona.direcraft_carrionarts.item.ModArmorMaterial;
import com.ohmyjarona.direcraft_carrionarts.item.ModItem;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(DirecraftCarrionArts.MODID)
public class DirecraftCarrionArts {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "direcraft_carrionarts";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public DirecraftCarrionArts(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        //Register item and block lists
        ModItem.register(modEventBus);
        ModBlock.register(modEventBus);
        ModArmorMaterial.register(modEventBus);
        ModBlockEntity.register(modEventBus);
        ModCustomBlock.register(modEventBus);
        ModCreativeTab.register(modEventBus);
        ModFluid.register(modEventBus);
        ModFluidType.register(modEventBus);
        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (DirecraftVultureCulture) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        //modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        //placeholder
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        //LOGGER.info("HELLO from server starting");
    }
    
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents{
        @SubscribeEvent
        public static void registerBlockEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
        	//event.registerBlockEntityRenderer(ModBlockEntity.CHOPPING_STUMP_BE.get(), ChoppingStumpBlockEntityRenderer::new);
        
        	
        ItemBlockRenderTypes.setRenderLayer(ModBlock.CARRION_PILE.get(), RenderType.CUTOUT);
        }
    	
        
        
    }
}
