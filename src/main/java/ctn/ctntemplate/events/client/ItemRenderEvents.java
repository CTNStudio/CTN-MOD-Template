package ctn.ctntemplate.events.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

@EventBusSubscriber(value = Dist.CLIENT)
public class ItemRenderEvents {
	@SubscribeEvent
	public static void itemRender(RegisterClientExtensionsEvent event) {
//        IClientItemExtensions paradiseLost = IClientItemExtensions.of(PmItems.PARADISE_LOST.asItem());
////        paradiseLost.
//        event.registerItem(paradiseLost, PmItems.PARADISE_LOST);
	}
	
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
//		event.registerEntityRenderer(PmEntitys.MAGIC_BULLET_ENTITY.get(), MagicBulletEntityRenderer::new);
	}
}
