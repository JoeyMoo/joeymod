package joey.joeymod.world.generation;

import joey.joeymod.config.OreConfig;
import joey.joeymod.init.BlockList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen 
{
	//Vein per Chunk Count, MinHeight, MaxHeightBase, MaxHeight
	private static final CountRangeConfig joey_cfg = new CountRangeConfig(40, 20, 0, 128);
	private static final int joey_veinsize = 8;
	
	public static void setupOreGen()
	{
		for(Biome biome: ForgeRegistries.BIOMES.getValues())
		{
			if(biome.getCategory() == Biome.Category.THEEND)
			{
				continue;
			}
			
			if(biome.getCategory() == Biome.Category.NETHER)
			{
				continue;
			}
			
			if(OreConfig.enableJoeyOre)
			{
				biome.addFeature(
						GenerationStage.Decoration.UNDERGROUND_ORES,
						Biome.createDecoratedFeature(Feature.ORE,
													 new OreFeatureConfig(
															 OreFeatureConfig.FillerBlockType.NATURAL_STONE,
															 BlockList.joey_ore.getDefaultState(),
															 joey_veinsize),
													 Placement.COUNT_RANGE,
													 joey_cfg));
			}
		}
	}
}
