package ctn.ctntemplate.events.client;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

/**
 * 物品提示/描述处理
 */
@EventBusSubscriber(value = Dist.CLIENT)
public class ItemTooltipEvents {

    @SubscribeEvent
    public static void itemTooltip(final ItemTooltipEvent event) {
        List<Component> components = event.getToolTip();
        ItemStack stack = event.getItemStack();
    }
}
