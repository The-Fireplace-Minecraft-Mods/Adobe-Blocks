package the_fireplace.adobeblocks;

import net.minecraftforge.fml.common.Mod;

//The @Mod annotation is what makes it a mod.
@Mod(modid=AdobeBlocks.MODID, name=AdobeBlocks.MODNAME, version=AdobeBlocks.VERSION)
public class AdobeBlocks {
	//I made these 3 Strings here rather than in the @Mod because later, when your mod gets more complex, it is much easier to update these values when they are all defined here instead of retyped every time they are needed.
	public static final String MODID = "adobeblocks";
	public static final String MODNAME = "Adobe Blocks";
	public static final String VERSION = "2.0.0.1";
}
