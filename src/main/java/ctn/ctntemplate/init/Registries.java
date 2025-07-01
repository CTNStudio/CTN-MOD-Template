package ctn.ctntemplate.init;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import org.jetbrains.annotations.NotNull;

import static ctn.ctntemplate.CtnTemplate.MODID;

@EventBusSubscriber(modid = MODID)
public class Registries {
//	public static final ResourceKey<Registry<Skill>> SKILL_REGISTRY_KEY = ResourceKey.createRegistryKey(getPath("spells"));
//	public static final Registry<Skill>              SKILL              = new RegistryBuilder<>(SKILL_REGISTRY_KEY).sync(true).defaultKey(getPath("empty")).create();

//	// Alternatively:
//	@SubscribeEvent
//	public static void register(RegisterEvent event) {
//		event.register(SKILL_REGISTRY_KEY, registry -> {});
//	}
	
	@SubscribeEvent
	public static void registrar(NewRegistryEvent event) {
//		event.register(SKILL);
	}
	
	private static @NotNull ResourceLocation getPath(String spells) {
		return ResourceLocation.fromNamespaceAndPath(MODID, spells);
	}
}
