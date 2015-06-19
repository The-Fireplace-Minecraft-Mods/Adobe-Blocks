package the_fireplace.adobeblocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

//The @Mod annotation is what makes it a mod.
@Mod(modid=AdobeBlocks.MODID, name=AdobeBlocks.MODNAME, version=AdobeBlocks.VERSION)
public class AdobeBlocks {
	//This is the instance. It will be more useful later
	@Instance(AdobeBlocks.MODID)
	public static AdobeBlocks instance;
	//I made these 3 Strings here rather than in the @Mod because later, when your mod gets more complex, it is much easier to update these values when they are all defined here instead of retyped every time they are needed.
	public static final String MODID = "adobeblocks";
	public static final String MODNAME = "Adobe Blocks";
	public static final String VERSION = "2.0.0.1";
	
	public static final CreativeTabs TabAdobeBlocks = new TabAdobeBlocks("adobe_blocks");
	
	//Items go here
	public static final Item adobe_mixture = new Item().setUnlocalizedName("adobe_mixture").setCreativeTab(TabAdobeBlocks);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		registerItem(adobe_mixture);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		if(event.getSide().isClient()){
			registerItemRenders();
		}
	}
	
	private void registerItemRenders(){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_mixture, 0, new ModelResourceLocation(MODID+":adobe_mixture", "inventory"));
	}
	
	private void registerItem(Item item){
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}
	
	private void registerBlock(Block block){
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
}
