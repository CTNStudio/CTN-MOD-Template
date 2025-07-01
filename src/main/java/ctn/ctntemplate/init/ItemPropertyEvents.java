package ctn.ctntemplate.init;

import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import static ctn.ctntemplate.CtnTemplate.MODID;

/**
 * 物品渲染附加
 */
@EventBusSubscriber(value = Dist.CLIENT)
public class ItemPropertyEvents {
//	public static final ResourceLocation MODE_BOOLEAN        = createProperties("mode_boolean");
	
//	public static final ClampedItemPropertyFunction PROPERTY_MODE_BOOLEAN = (itemStack, clientLevel, livingEntity, i) ->
//			Boolean.TRUE.equals(itemStack.get(PmItemDataComponents.MODE_BOOLEAN)) ? 1 : 0;

	
	/**
	 * 注册物品渲染附加
	 */
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
//		createProperties(event, PmItems.CREATIVE_RATIONALITY_TOOL.asItem(), MODE_BOOLEAN, PROPERTY_MODE_BOOLEAN);
	}
	
	private static void createProperties(FMLClientSetupEvent event, Item item, ResourceLocation propertiesName, ClampedItemPropertyFunction propertyFunction) {
		event.enqueueWork(() -> ItemProperties.register(item, propertiesName, propertyFunction));
	}
	
	private static ResourceLocation createProperties(String name) {
		return ResourceLocation.fromNamespaceAndPath(MODID, name);
	}
}
