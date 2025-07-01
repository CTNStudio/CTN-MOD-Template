package ctn.ctntemplate.registrar;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;


/// 注册能力
@EventBusSubscriber()
public class RegistrarCapability {

    @SubscribeEvent
    public static void registrarItem(RegisterCapabilitiesEvent event) {
        for (Item item : BuiltInRegistries.ITEM) {
//			if (item instanceof IRandomDamage capability) {
//				event.registerItem(RANDOM_DAMAGE_ITEM, (stack, ctx) -> capability, item);
//			}
        }
    }

    @SubscribeEvent
    public static void registrarEntity(RegisterCapabilitiesEvent event) {
//		event.registerEntity(SKILL_ENTITY, PLAYER, (entity, ctx) -> ((IModPlayerMixin) entity).getSkillHandler());

        for (EntityType<?> entityType : BuiltInRegistries.ENTITY_TYPE) {
//			event.registerEntity(
//					INVINCIBLE_TICK_ENTITY, entityType, (entity, ctx) ->
//							entity instanceof IInvincibleTickEntity capability ? capability : null);
        }
    }

    @SubscribeEvent
    public static void registrarBlockEntity(RegisterCapabilitiesEvent event) {
//		for (BlockEntityType<?> blockEntityType : BuiltInRegistries.BLOCK_ENTITY_TYPE) {
//
//		}
    }

    @SubscribeEvent
    public static void registrarBlock(RegisterCapabilitiesEvent event) {
//		for (Block block : BuiltInRegistries.BLOCK) {
//
//		}
    }
}
