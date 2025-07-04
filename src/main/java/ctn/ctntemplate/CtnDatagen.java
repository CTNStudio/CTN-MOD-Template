package ctn.ctntemplate;

import ctn.ctntemplate.datagen.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

/**
 * 数据生成主类
 */
@EventBusSubscriber()
public class CtnDatagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper exFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // 客户端数据生成
        generator.addProvider(event.includeClient(), new DatagenI18ZhCn(output));
        generator.addProvider(event.includeClient(), new DatagenItemModel(output, exFileHelper));
        generator.addProvider(event.includeClient(), new DatagenBlockState(output, exFileHelper));
        generator.addProvider(event.includeClient(), new DatagenParticle(output, exFileHelper));
        Tags.Block pmBlockTags = new Tags.Block(output, lookupProvider, exFileHelper);
        generator.addProvider(event.includeClient(), pmBlockTags);
        generator.addProvider(event.includeClient(), new Tags.Item(output, lookupProvider, pmBlockTags.contentsGetter(), exFileHelper));
        generator.addProvider(event.includeClient(), new Tags.DamageType(output, lookupProvider, exFileHelper));
        generator.addProvider(event.includeClient(), new Tags.Entity(output, lookupProvider, exFileHelper));

        // 服务端数据生成
        generator.addProvider(event.includeServer(), new DatagenDatapackBuiltinEntries(output, lookupProvider));
    }
}
