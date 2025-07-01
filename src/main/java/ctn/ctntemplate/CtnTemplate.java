package ctn.ctntemplate;

import ctn.ctntemplate.config.CtnConfig;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import static ctn.ctntemplate.init.ArmorMaterials.ARMOR_MATERIALS_TYPE_REGISTER;
import static ctn.ctntemplate.init.Blocks.BLOCK_REGISTER;
import static ctn.ctntemplate.init.CreativeModeTab.PROJECT_MOON_TAB_REGISTER;
import static ctn.ctntemplate.init.EntityAttributes.ATTRIBUTE_REGISTER;
import static ctn.ctntemplate.init.Entitys.ENTITY_TYPE_REGISTER;
import static ctn.ctntemplate.init.ItemDataComponents.ITEM_DATA_COMPONENT_REGISTER;
import static ctn.ctntemplate.init.Items.ITEM_REGISTER;
import static ctn.ctntemplate.init.MenuTypes.MENU_TYPE_REGISTER;
import static ctn.ctntemplate.init.ParticleTypes.PARTICLE_TYPE_REGISTER;
import static ctn.ctntemplate.init.SoundEvents.SOUND_EVENT_TYPE_REGISTER;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CtnTemplate.MODID)
public class CtnTemplate {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "ctntemplate";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public CtnTemplate(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        
        BLOCK_REGISTER.register(modEventBus);
        ITEM_REGISTER.register(modEventBus);
        PROJECT_MOON_TAB_REGISTER.register(modEventBus);
        ATTRIBUTE_REGISTER.register(modEventBus);
        PARTICLE_TYPE_REGISTER.register(modEventBus);
        ARMOR_MATERIALS_TYPE_REGISTER.register(modEventBus);
        SOUND_EVENT_TYPE_REGISTER.register(modEventBus);
        ENTITY_TYPE_REGISTER.register(modEventBus);
        ITEM_DATA_COMPONENT_REGISTER.register(modEventBus);
        MENU_TYPE_REGISTER.register(modEventBus);
        
        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (CTNTemplate) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, CtnConfig.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (CtnConfig.LOG_DIRT_BLOCK.getAsBoolean()) {
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
        }

        LOGGER.info("{}{}", CtnConfig.MAGIC_NUMBER_INTRODUCTION.get(), CtnConfig.MAGIC_NUMBER.getAsInt());

        CtnConfig.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
