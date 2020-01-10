package joey.joeymod;

import joey.joeymod.init.BlockList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class JoeyItemGroup extends ItemGroup
{
	public JoeyItemGroup()
	{
		super("joey");
	}
	
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(BlockList.joey_ore);
	}
}
