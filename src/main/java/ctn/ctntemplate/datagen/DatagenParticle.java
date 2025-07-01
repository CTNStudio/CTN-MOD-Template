package ctn.ctntemplate.datagen;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static ctn.ctntemplate.CtnTemplate.MODID;

/// 粒子
public class DatagenParticle extends ParticleDescriptionProvider {
	public DatagenParticle(PackOutput output, ExistingFileHelper fileHelper) {
		super(output, fileHelper);
	}
	
	private static @NotNull ResourceLocation getPath(String name) {
		return ResourceLocation.fromNamespaceAndPath(MODID, name);
	}
	
	@Override
	protected void addDescriptions() {
//		createSprite(PmParticleTypes.TEXT_PARTICLE_TYPE,
//		             "physics",
//		             "spirit",
//		             "erosion",
//		             "the_soul",
//		             "add_prudence",
//		             "reduce_prudence"
//		);
	}
	
	private <p extends ParticleOptions> void createSprite(Supplier<ParticleType<p>> type, String name) {
		sprite(type.get(), ResourceLocation.fromNamespaceAndPath(MODID, name));
	}
	
	private <p extends ParticleOptions> void createSprite(Supplier<ParticleType<p>> type, String... names) {
		List<ResourceLocation> list = new ArrayList<>();
		for (String name : names) {
			list.add(getPath(name));
		}
		spriteSet(type.get(), list);
	}
	
}
