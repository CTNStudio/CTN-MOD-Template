package ctn.ctntemplate.datagen;

import ctn.ctntemplate.CtnTemplate;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;


public class DatagenI18ZhCn extends LanguageProvider {
    public DatagenI18ZhCn(PackOutput output) {
        super(output, CtnTemplate.ID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
//		add(PmCreativeModeTab.EGO_WEAPON, "E.G.O 武器");
//
//		add(MOD_ID + ".item_tooltip.geo_describe.damage_type", "伤害类型");
//
//		addPlayerDeathMessage(PmDamageTypes.PHYSICS, "%s死于%s的造成的物理伤害");
//
//		addItem(PmItems.CREATIVE_RATIONALITY_TOOL, "理智控制工具");
//
//		addAttribute(PmEntityAttributes.PHYSICS_RESISTANCE, "受物理伤害倍率");
//
//		add(MobEntityResistance.ATTRIBUTE_DESCRIPTION_KEY, "抵抗能力");
//
//		addEntityType(PmEntitys.TRAINING_RABBITS, "教学兔兔");
//
//		add("config.jade.plugin_project_moon.level", "生物/方块等级");
//
//		add(ItemColorUsageReq.USE_CONDITION, "使用条件");
//
//		addAttribute(PmItemDataComponents.MODE_BOOLEAN, "模式开关");
//
//		addConfig("enable_four_color_damage", "四色伤害（物理、精神、侵蚀、灵魂）", "同时也会禁用对应的抗性，以及对应的效果");
//
//		add("project_moon.configuration.temperance", "自律属性配置");
//
//		add(PlayerAttributeButton.MESSAGE, "打开玩家属性面板");
//
//		add(ATTRIBUTE_TO_SET + FourColorAttribute.Type.JUSTICE.getName(), "更改玩家正义点数为 %d");
//
//		addSkill(PmSkills.EMPTY, "NULL");
    }

    public void addConfig(String configKey, String translationDescribe, String commentDescribe) {
        add(translationKey(configKey), translationDescribe);
        add(commentKey(configKey), commentDescribe);
    }

    public static String translationKey(String string) {
        return CtnTemplate.ID + ".configgui." + string;
    }

    public static String commentKey(String string) {
        return CtnTemplate.ID + ".configgui." + string + ".tooltip";
    }

    public void addConfig(String configKey, String translationDescribe) {
        add(translationKey(configKey), translationDescribe);
    }

    public <T> void addAttribute(Supplier<DataComponentType<T>> dataComponentType, String name) {
        add(dataComponentType.get().toString(), name);
    }

    /**
     * 生物属性翻译
     */
    public void addAttribute(Holder<Attribute> attributeHolder, String name) {
        add(attributeHolder.value().getDescriptionId(), name);
    }

    /**
     * 死亡消息翻译
     */
    public void addDeathMessage(ResourceKey<DamageType> damageType, String name) {
        add("death.attack." + damageType.location().getPath(), name);
    }

    /**
     * 玩家死亡消息翻译
     */
    public void addPlayerDeathMessage(ResourceKey<DamageType> damageType, String name) {
        add("death.attack." + damageType.location().getPath() + ".player", name);
    }

    /**
     * 创造模式物品栏名称翻译
     */
    public <R, T extends R> void add(DeferredHolder<R, T> itemGroup, String name) {
        add("itemGroup." + itemGroup.getId().toString().replace(":", "."), name);
    }

    public void addCurios(String curiosIdName, String name) {
        add("curios.identifier." + curiosIdName, name);
        add("curios.modifiers." + curiosIdName, name + "饰品加成：");
    }

}
