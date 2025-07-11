package ctn.ctntemplate.datagen.recipe;

import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static ctn.ctntemplate.CtnTemplate.ID;
import static ctn.ctntemplate.datagen.recipe.RecipeTool.*;

/**
 * @author 尽
 */
@SuppressWarnings("UnusedReturnValue")
public abstract class DatagenRecipeProvider extends RecipeProvider {
    private final String modId;

    public DatagenRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
        modId = ID;
    }

    public static @NotNull Criterion<InventoryChangeTrigger.TriggerInstance> has(MinMaxBounds.@NotNull Ints count, @NotNull ItemLike item) {
        return RecipeProvider.has(count, item);
    }

    public static @NotNull Criterion<InventoryChangeTrigger.TriggerInstance> has(@NotNull TagKey<Item> tag) {
        return RecipeProvider.has(tag);
    }

    public static @NotNull Criterion<InventoryChangeTrigger.TriggerInstance> has(@NotNull ItemLike itemLike) {
        return RecipeProvider.has(itemLike);
    }

    public @NotNull ShapedBuilder buildingRecipeBuilder(ItemLike result) {
        return buildingRecipeBuilder(result, 1);
    }

    @Override
    protected abstract void buildRecipes(@NotNull RecipeOutput output);

    /// 战斗用品
    protected void armorRecipe(RecipeOutput output,
                               ItemLike helmet,
                               ItemLike chestplate,
                               ItemLike leggings,
                               ItemLike boots,
                               Ingredient requires) {
        if (helmet != null) {
            helmetRecipe(output, helmet, requires, "helmet");
        }
        if (chestplate != null) {
            chestplateRecipe(output, helmet, requires, "chestplate");
        }
        if (leggings != null) {
            leggingsRecipe(output, helmet, requires, "leggings");
        }
        if (boots != null) {
            bootsRecipe(output, helmet, requires, "boots");
        }
    }

    /**
     * 创建头盔配方
     */
    protected void helmetRecipe(RecipeOutput recipeOutput, ItemLike result,
                                Ingredient requires, String group) {
        ResourceLocation location = getLocation(getItemName(result));
        ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.COMBAT, result);
        helmetPattern(builder);
        requires(builder, Map.of('#', requires), group, recipeOutput);
    }

    /**
     * 创建胸甲配方
     */
    protected void chestplateRecipe(RecipeOutput recipeOutput, ItemLike result,
                                    Ingredient requires, String group) {
        ResourceLocation location = getLocation(getItemName(result));
        ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.COMBAT, result);
        chestplatePattern(builder);
        requires(builder, Map.of('#', requires), group, recipeOutput);
    }

    /**
     * 创建护腿配方
     */
    protected void leggingsRecipe(RecipeOutput recipeOutput, ItemLike result,
                                  Ingredient requires, String group) {
        ResourceLocation location = getLocation(getItemName(result));
        ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.COMBAT, result);
        leggingsPattern(builder);
        requires(builder, Map.of('#', requires), group, recipeOutput);
    }

    /**
     * 创建靴子配方
     */
    protected void bootsRecipe(RecipeOutput recipeOutput, ItemLike result,
                               Ingredient requires, String group) {
        ResourceLocation location = getLocation(getItemName(result));
        ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.COMBAT, result);
        bootsPattern(builder);
        requires(builder, Map.of('#', requires), group, recipeOutput);
    }

    private @NotNull ResourceLocation getLocation(String unpackedName) {
        return ResourceLocation.fromNamespaceAndPath(modId, unpackedName);
    }

    public static @NotNull String getItemName(ItemLike itemLike) {
        return net.minecraft.data.recipes.RecipeProvider.getItemName(itemLike);
    }

    /**
     * 创建盾牌配方
     */
    protected void shieldRecipe(RecipeOutput recipeOutput, ItemLike result,
                                Ingredient requires, Ingredient secondaryRequires, String group) {
        ResourceLocation location = getLocation(getItemName(result));
        ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.COMBAT, result);
        shieldPattern(builder);
        requires(builder, Map.of('#', requires, 'O', secondaryRequires), group, recipeOutput);
    }

    /**
     * 创建剑配方
     */
    protected void swordRecipe(RecipeOutput recipeOutput, ItemLike result,
                               Ingredient requires, Ingredient secondaryRequires, String group) {
        ResourceLocation location = getLocation(getItemName(result));
        ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.COMBAT, result);
        swordFramePattern(builder);
        requires(builder, Map.of('#', requires, 'O', secondaryRequires), group, recipeOutput);
    }

    /// 工具

    /**
     * 创建斧头配方
     */
    protected void axeRecipe(RecipeOutput recipeOutput, ItemLike result,
                             Ingredient requires, Ingredient secondaryRequires, String group) {
        ResourceLocation location = getLocation(getItemName(result));
        ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.TOOLS, result);
        axeFramePattern(builder);
        requires(builder, Map.of('#', requires, 'O', secondaryRequires), group, recipeOutput);
    }

    /**
     * 创建镐类配方
     */
    protected void pickaxeRecipe(RecipeOutput recipeOutput, ItemLike result,
                                 Ingredient requires, Ingredient secondaryRequires, String group) {
        ResourceLocation location = getLocation(getItemName(result));
        ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.TOOLS, result);
        pickaxeFramePattern(builder);
        requires(builder, Map.of('#', requires, 'O', secondaryRequires), group, recipeOutput);
    }

    /**
     * 创建锹类配方
     */
    protected void shovelRecipe(RecipeOutput recipeOutput, ItemLike result,
                                Ingredient requires, Ingredient secondaryRequires, String group) {
        ResourceLocation location = getLocation(getItemName(result));
        ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.TOOLS, result);
        shovelFramePattern(builder);
        requires(builder, Map.of('#', requires, 'O', secondaryRequires), group, recipeOutput);
    }

    /**
     * 创建锄类配方
     */
    protected void hoeRecipe(RecipeOutput recipeOutput,
                             ItemLike result,
                             Ingredient requires, Ingredient secondaryRequires, String group) {
        ResourceLocation location = getLocation(getItemName(result));
        ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.TOOLS, result);
        hoeFramePattern(builder);
        requires(builder, Map.of('#', requires, 'O', secondaryRequires), group, recipeOutput);
    }

    /**
     * 创建核心框架配方（如末影箱）
     */
    protected void coreFrameRecipe(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result,
                                   Ingredient requires, Ingredient secondaryRequires, String group) {
        ResourceLocation location = getLocation(getItemName(result));
        ShapedBuilder builder = ShapedBuilder.shaped(location, category, result);
        coreFramePattern(builder);
        requires(builder, Map.of('#', requires, 'O', secondaryRequires), group, recipeOutput);
    }

    /// 其他

    /**
     * 创建环形配方（如箱子）
     */
    protected void circularFrameRecipe(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result,
                                       Ingredient requires, String group) {
        ResourceLocation location = getLocation(getItemName(result));
        ShapedBuilder builder = ShapedBuilder.shaped(location, category, result);
        circularFramePattern(builder);
        requires(builder, Map.of('#', requires), group, recipeOutput);
    }

    /**
     * 创建一个解压和压缩的配方
     */
    protected void unpackedPackedRecipes(RecipeOutput recipeOutput,
                                         RecipeCategory unpackedCategory, ItemLike unpacked, String unpackedGroup,
                                         RecipeCategory packedCategory, ItemLike packed, String packedGroup) {
        this.unpackedRecipes(recipeOutput, unpackedCategory, unpacked, getIngredient(packed), unpackedGroup);
        this.packedRecipes(recipeOutput, packedCategory, packed, getIngredient(unpacked), packedGroup);
    }

    /**
     * 创建解压配方
     */
    private void unpackedRecipes(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result,
                                 Ingredient requires, String recipeGroup) {
        ResourceLocation location = getLocation(getItemName(result) + "_unpacked");
        ShapelessBuilder builder = ShapelessBuilder.shaped(location, category, result, 9);
        builder.requires(requires)
                .basicUnlockedBy()
                .group(recipeGroup)
                .save(recipeOutput);
    }

    /**
     * 矿物块类型压缩配方
     */
    protected void packedRecipes(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result,
                                 Ingredient requires, String recipeGroup) {
        ResourceLocation location = getLocation(getItemName(result) + "_packed");
        ShapedBuilder builder = ShapedBuilder.shaped(location, category, result);
        fullWrapPattern(builder);
        requires(builder, Map.of('#', requires), recipeGroup, recipeOutput);
    }

    /**
     * 创建3x3全包裹式配方（如矿物块）
     */
    protected void fullWrapRecipe(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result,
                                  Ingredient requires, String group) {
        ResourceLocation location = getLocation(getItemName(result));
        ShapedBuilder builder = ShapedBuilder.shaped(location, category, result);
        fullWrapPattern(builder);
        requires(builder, Map.of('#', requires), group, recipeOutput);
    }

    /**
     * 创建一个单格物品的配方
     */
    protected void singleRecipe(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, int count,
                                Ingredient requires, String group) {
        ResourceLocation location = getLocation(getItemName(result));
        ShapelessBuilder builder = ShapelessBuilder.shaped(location, category, result, count);
        builder.requires(requires)
                .basicUnlockedBy()
                .group(group)
                .save(recipeOutput);
    }

    /// 建筑
    private void buildingBlockRecipe(RecipeOutput recipeOutput,
                                     ItemLike singlePlate,
                                     ItemLike stair,
                                     ItemLike fence,
                                     ItemLike fenceDoor,
                                     ItemLike trapdoor,
                                     ItemLike door,
                                     ItemLike pressurePlate,
                                     ItemLike button,
                                     Ingredient requires,
                                     Ingredient secondaryRequires
    ) {
        if (singlePlate != null) {
            stairRecipe(recipeOutput, singlePlate, requires, "single_plate");
        }
        if (stair != null) {
            stairRecipe(recipeOutput, stair, requires, "stair");
        }
        if (fence != null) {
            fenceRecipe(recipeOutput, fence, requires, secondaryRequires, "fence");
        }
        if (fenceDoor != null) {
            fenceDoorRecipe(recipeOutput, fenceDoor, requires, secondaryRequires, "fence_door");
        }
        if (trapdoor != null) {
            trapdoorRecipe(recipeOutput, trapdoor, requires, "trapdoor");
        }
        if (door != null) {
            doorRecipe(recipeOutput, door, requires, "door");
        }
        if (pressurePlate != null) {
            pressurePlateRecipe(recipeOutput, pressurePlate, requires, "pressure_plate");
        }
        if (button != null) {
            singleRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, button, 1, requires, "button");
        }
    }

    /**
     * 创建楼梯配方
     */
    protected void stairRecipe(RecipeOutput recipeOutput, ItemLike result,
                               Ingredient requires, String group) {
        ShapedBuilder builder = buildingRecipeBuilder(result, 4);
        stairPattern(builder);
        requires(builder, Map.of('#', requires), group, recipeOutput);
    }

    /**
     * 创建栅栏配方
     */
    protected void fenceRecipe(RecipeOutput recipeOutput, ItemLike result,
                               Ingredient requires, Ingredient secondaryRequires, String group) {
        ShapedBuilder builder = buildingRecipeBuilder(result, 3);
        fencePattern(builder);
        requires(builder, Map.of('#', requires, 'O', secondaryRequires), group, recipeOutput);
    }

    /**
     * 创建栅栏门配方
     */
    protected void fenceDoorRecipe(RecipeOutput recipeOutput, ItemLike result,
                                   Ingredient requires, Ingredient secondaryRequires, String group) {
        ShapedBuilder builder = buildingRecipeBuilder(result);
        fenceDoorPattern(builder);
        requires(builder, Map.of('#', requires, 'O', secondaryRequires), group, recipeOutput);
    }

    /**
     * 创建活板门配方
     */
    protected void trapdoorRecipe(RecipeOutput recipeOutput, ItemLike result,
                                  Ingredient requires, String group) {
        ShapedBuilder builder = buildingRecipeBuilder(result, 2);
        trapdoorPattern(builder);
        requires(builder, Map.of('#', requires), group, recipeOutput);
    }

    /**
     * 创建台阶配方
     */
    protected void singlePlateRecipe(RecipeOutput recipeOutput, ItemLike result,
                                     Ingredient requires, String group) {
        ShapedBuilder builder = buildingRecipeBuilder(result, 6);
        singlePlatePattern(builder);
        requires(builder, Map.of('#', requires), group, recipeOutput);
    }

    public @NotNull ShapedBuilder buildingRecipeBuilder(ItemLike result, int count) {
        ResourceLocation location = getLocation(getItemName(result));
        return ShapedBuilder.shaped(location, RecipeCategory.BUILDING_BLOCKS, result, count);
    }

    /**
     * 创建门配方
     */
    protected void doorRecipe(RecipeOutput recipeOutput, ItemLike result,
                              Ingredient requires, String group) {
        ShapedBuilder builder = buildingRecipeBuilder(result, 3);
        singlePlatePattern(builder);
        requires(builder, Map.of('#', requires), group, recipeOutput);
    }

    /**
     * 创建压力板配方
     */
    protected void pressurePlateRecipe(RecipeOutput recipeOutput, ItemLike result,
                                       Ingredient requires, String group) {
        ShapedBuilder builder = buildingRecipeBuilder(result);
        singlePlatePattern(builder);
        requires(builder, Map.of('#', requires), group, recipeOutput);
    }
}
