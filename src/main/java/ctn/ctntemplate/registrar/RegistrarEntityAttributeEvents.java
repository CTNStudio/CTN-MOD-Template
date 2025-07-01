package ctn.ctntemplate.registrar;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;

@EventBusSubscriber()
public class RegistrarEntityAttributeEvents {

    /**
     * 注册实体属性
     */
    @SubscribeEvent
    public static void entityAttribute(EntityAttributeCreationEvent event) {
//		event.put(PmEntitys.TRAINING_RABBITS.get(), TrainingRabbits.createAttributes().build());
    }

    /// 添加或修改属性
    @SubscribeEvent
    public static void addAttribute(EntityAttributeModificationEvent event) {
//		event.add(entityType, PmEntityAttributes.MAX_RATIONALITY);
    }

}
