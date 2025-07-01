package ctn.ctntemplate.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static ctn.ctntemplate.CtnTemplate.MODID;

public class Blocks {
	public static final DeferredRegister.Blocks BLOCK_REGISTER = DeferredRegister.createBlocks(MODID);
	
	public static DeferredBlock<Block> registerSimpleBlock(String name, BlockBehaviour.Properties props) {
		return BLOCK_REGISTER.registerSimpleBlock(name, props);
	}
}
