package ctn.ctntemplate;

import com.mojang.logging.LogUtils;
import ctn.ctntemplate.config.CtnConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

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

@Mod(CtnTemplate.ID)
public class CtnTemplate {
    public static final String ID = "ctntemplate";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CtnTemplate(IEventBus modEventBus, ModContainer modContainer) {
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

        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, CtnConfig.SPEC);
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        LOGGER.info("Time to register commands!");
        // 在这注册指令
    }

    public void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Hello from common setup");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Hello from server starting");
    }
}
