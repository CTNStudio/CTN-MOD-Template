package ctn.ctntemplate.registrar;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber()
public class RegistrarPayloadInit {
@SubscribeEvent
	public static void register(final RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar("1.0");
		/// 接收来自服务端和客户端的数据
//		registrar.playBidirectional(SkillSlotIndexData.TYPE, SkillSlotIndexData.CODEC, SkillSlotIndexData::bidirectional);
		
		/// 接收来自服务端的数据
//		registrar.playToClient(RationalityValueData.TYPE, RationalityValueData.CODEC, RationalityValueData::toClient);
		
		/// 接收来自客户端的数据
//		registrar.playToServer(OpenPlayerAttributeScreenData.TYPE, OpenPlayerAttributeScreenData.CODEC, OpenPlayerAttributeScreenData::toServer);
	}
}
