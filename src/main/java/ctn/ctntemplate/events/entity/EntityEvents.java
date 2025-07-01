package ctn.ctntemplate.events.entity;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

/**
 * 实体事件
 */
@EventBusSubscriber()
public class EntityEvents {
    /**
     * 实体死亡事件
     */
    @SubscribeEvent
    public static void deathEvent(LivingDeathEvent event) {
    }
}
