package joey.joeymod;

import joey.joeymod.init.BlockList;
import joey.joeymod.init.ItemList;
import joey.joeymod.world.generation.OreGen;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(modid = JoeyMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber 
{
	//sets up a new item group
	public static final ItemGroup joey = new JoeyItemGroup();
	
	//A common setup to register and setup things that are not blocks, items, or entities
	@SubscribeEvent
	public static void onCommonSetup(final FMLCommonSetupEvent event)
	{
		//calls the OreGen class and tells it to setup the ore generation
		OreGen.setupOreGen();
	}
	//Registers Items
	@SubscribeEvent
	//makes the Register Items an event
	public static void onRegisterItems(RegistryEvent.Register<Item> event)
	{
		//Registers everything in the parentheses
		event.getRegistry().registerAll(
			ItemList.joey_ore = new BlockItem(BlockList.joey_ore, new Item.Properties().group(joey)).setRegistryName(BlockList.joey_ore.getRegistryName()),
			ItemList.joey_block = new BlockItem(BlockList.joey_block, new Item.Properties().group(joey)).setRegistryName(BlockList.joey_block.getRegistryName()),
			
			ItemList.joey_ingot = new Item(new Item.Properties().group(joey)).setRegistryName(location("joey_ingot"))
		);
	}
	//Registers Blocks
	@SubscribeEvent
	//makes the Register Blocks an event
	public static void onRegisterBlocks(RegistryEvent.Register<Block> event)
	{
		//Registers all that is in the parentheses
		event.getRegistry().registerAll(
			BlockList.joey_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.STONE)).setRegistryName(location("joey_ore")),
			BlockList.joey_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)).setRegistryName(location("joey_block"))
		);
	}
	//ResourceLocation so when we register the items you can reference their name with a simple line of code
	public static ResourceLocation location(String name)
	{
		return new ResourceLocation(JoeyMod.MODID, name);
	}
}
