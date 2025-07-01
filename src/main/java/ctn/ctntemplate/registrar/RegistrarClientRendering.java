package ctn.ctntemplate.registrar;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(value = Dist.CLIENT)
public class RegistrarClientRendering {

    /**
     * 注册实体渲染器
     */
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
//		EntityRenderers.register(PmEntitys.TRAINING_RABBITS.get(), TrainingRabbits.TrainingRabbitsRenderer::new);
//		EntityRenderers.register(PmEntitys.PARADISE_LOST_SPIKEWEED.get(), ParadiseLostSpikeweed.TrainingRabbitsRenderer::new);
    }

    /**
     * 注册粒子渲染器
     */
    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
//		event.registerSpriteSet(PmParticleTypes.TEXT_PARTICLE_TYPE.get(), TextParticle.Provider::new);
    }

    /**
     * 注册菜单渲染器
     */
    @SubscribeEvent
    public static void registerMenuScreens(RegisterMenuScreensEvent event) {
//		event.register(PLAYER_ATTRIBUTE_MENU.get(), PlayerAttributeScreen::new);
//		event.register(PLAYER_SKILL_MENU.get(), PlayerSkillScreen::new);
    }
}
