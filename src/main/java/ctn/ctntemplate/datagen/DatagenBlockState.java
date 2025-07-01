package ctn.ctntemplate.datagen;

import ctn.ctntemplate.CtnTemplate;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;


public class DatagenBlockState extends BlockStateProvider {
    public DatagenBlockState(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CtnTemplate.ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }
}
