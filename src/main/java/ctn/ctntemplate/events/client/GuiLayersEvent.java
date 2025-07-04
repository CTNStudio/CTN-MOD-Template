package ctn.ctntemplate.events.client;

import com.mojang.datafixers.util.Function3;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;

/**
 * gui渲染图层事件
 */
@EventBusSubscriber(value = Dist.CLIENT)
public class GuiLayersEvent {
    /**
     * 添加gui渲染图层及渲染事件
     */
    @SubscribeEvent
    public static void registerGuiLayersEvent(RegisterGuiLayersEvent event) {
//		register(event, SELECTED_ITEM_NAME, PLAYER_RATIONALITY, RationalityLayersDraw::new);
//		register(event, SELECTED_ITEM_NAME, PLAYER_SKILL, SkillLayersDrew::new);
    }

    /**
     * 注册gui渲染图层及渲染事件
     *
     * @param event 注册事件
     * @param other 渲染图层依赖
     * @param id    渲染图层id
     * @param layer 渲染图层
     */
    private static void register(RegisterGuiLayersEvent event,
                                 ResourceLocation other,
                                 ResourceLocation id,
                                 Function3<GuiGraphics, DeltaTracker, Minecraft, LayeredDraw.Layer> layer) {
        event.registerBelow(other, id, (guiGraphics, deltaTracker) -> layer.apply(guiGraphics, deltaTracker, Minecraft.getInstance()));
    }
}
