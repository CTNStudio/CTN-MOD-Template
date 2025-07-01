package ctn.ctntemplate.init;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.neoforge.common.BooleanAttribute;
import net.neoforged.neoforge.registries.DeferredRegister;

import static ctn.ctntemplate.CtnTemplate.MODID;

public class EntityAttributes {
	public static final DeferredRegister<Attribute> ATTRIBUTE_REGISTER = DeferredRegister.create(Registries.ATTRIBUTE, MODID);
	/** 物理伤害抵抗能力 */
//	public static final Holder<Attribute>           PHYSICS_RESISTANCE                = registerRangedAttribute("generic.physics_resistance", "attribute.name.generic.physics_resistance", 1.0, -1024, 1024);

	
	public static Holder<Attribute> registerRangedAttribute(String name, String descriptionId, double defaultValue, double min, double max) {
		return ATTRIBUTE_REGISTER.register(name, () -> new RangedAttribute(MODID + "." + descriptionId, defaultValue, min, max).setSyncable(true));
	}
	
	public static Holder<Attribute> registerBooleanAttribute(String name, String descriptionId, boolean defaultValue) {
		return ATTRIBUTE_REGISTER.register(name, () -> new BooleanAttribute(MODID + "." + descriptionId, defaultValue).setSyncable(true));
	}
}
