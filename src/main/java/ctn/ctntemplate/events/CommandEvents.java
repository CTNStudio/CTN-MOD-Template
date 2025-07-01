package ctn.ctntemplate.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

/**
 * 指令事件
 */
@EventBusSubscriber()
public class CommandEvents {
	@SubscribeEvent
	public static void onRegisterCommands(RegisterCommandsEvent event) {
//		PmCommands.registerCommands(event.getDispatcher());
	}
}
