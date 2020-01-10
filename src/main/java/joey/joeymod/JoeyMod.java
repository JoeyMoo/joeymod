package joey.joeymod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;

//Name should match what's in the META-INF/mods.toml file
@Mod("joeymod")
//sets up the main JoeyMod Class
public class JoeyMod 
{
	//sets up the name of the mod to reference in other classes
	public static final String MODID = "joeymod";
	//A Log Manager so the code looks cleaner as I put more imports in
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public JoeyMod()
	{
		
	}
}
