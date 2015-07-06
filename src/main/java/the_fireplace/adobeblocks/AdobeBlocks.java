package the_fireplace.adobeblocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import the_fireplace.adobeblocks.blocks.AdobeBricks;
import the_fireplace.adobeblocks.blocks.AdobeDoubleSlab;
import the_fireplace.adobeblocks.blocks.AdobeFurnace;
import the_fireplace.adobeblocks.blocks.AdobeHalfSlab;
import the_fireplace.adobeblocks.blocks.AdobeSlab;
import the_fireplace.adobeblocks.blocks.AdobeStairs;
import the_fireplace.adobeblocks.blocks.AdobeWall;
import the_fireplace.adobeblocks.blocks.ItemBlockAdobeSlab;
import the_fireplace.adobeblocks.entity.tile.TileEntityAdobeFurnace;
import the_fireplace.adobeblocks.handlers.AdobeBlocksGuiHandler;
import the_fireplace.adobeblocks.recipes.VanillaRecipes;

@Mod(modid=AdobeBlocks.MODID, name=AdobeBlocks.MODNAME, version=AdobeBlocks.VERSION)
public class AdobeBlocks {
	@Instance(AdobeBlocks.MODID)
	public static AdobeBlocks instance;

	public static final String MODID = "adobeblocks";
	public static final String MODNAME = "Adobe Blocks";
	public static final String VERSION = "2.0.0.1";

	public static final CreativeTabs TabAdobeBlocks = new TabAdobeBlocks("adobe_blocks");
	public static final Material adobe = new Material(MapColor.adobeColor);

	public static final Block adobe_bricks = new AdobeBricks();
	public static final Block adobe_furnace = new AdobeFurnace(false).setUnlocalizedName("adobe_furnace").setCreativeTab(TabAdobeBlocks);
	public static final Block adobe_wall = new AdobeWall();
	public static final Block lit_adobe_furnace = new AdobeFurnace(true).setUnlocalizedName("lit_adobe_furnace").setLightLevel(0.875F);
	public static final Block adobe_stairs = new AdobeStairs();
	public static final Block adobe_slab = new AdobeHalfSlab();

	public static final Item adobe_mixture = new Item().setUnlocalizedName("adobe_mixture").setCreativeTab(TabAdobeBlocks);
	public static final Item adobe_brick = new Item().setUnlocalizedName("adobe_brick").setCreativeTab(TabAdobeBlocks);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		AdobeSlab doubleSlab = new AdobeDoubleSlab();

		NetworkRegistry.INSTANCE.registerGuiHandler(this, new AdobeBlocksGuiHandler());
		GameRegistry.registerTileEntity(TileEntityAdobeFurnace.class, "adobe_furnace");
		GameRegistry.registerBlock(adobe_slab, ItemBlockAdobeSlab.class, "adobe_slab", adobe_slab, doubleSlab, false);
		GameRegistry.registerBlock(doubleSlab, ItemBlockAdobeSlab.class, "double_adobe_slab", adobe_slab, doubleSlab, true);
		registerBlock(adobe_bricks);
		registerBlock(adobe_furnace);
		registerBlock(lit_adobe_furnace);
		registerBlock(adobe_wall);
		registerBlock(adobe_stairs);
		registerItem(adobe_mixture);
		registerItem(adobe_brick);
	}

	@EventHandler
	public void init(FMLInitializationEvent event){
		VanillaRecipes.initRecipes();
		if(event.getSide().isClient()){
			registerItemRenders();
		}
	}

	private void registerItemRenders(){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_bricks), 0, new ModelResourceLocation(MODID+":adobe_bricks", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_furnace), 0, new ModelResourceLocation(MODID+":adobe_furnace", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(lit_adobe_furnace), 0, new ModelResourceLocation(MODID+":adobe_furnace", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_wall), 0, new ModelResourceLocation(MODID+":adobe_wall", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_stairs), 0, new ModelResourceLocation(MODID+":adobe_stairs", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_slab), 0, new ModelResourceLocation(MODID+":adobe_slab", "inventory"));

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_mixture, 0, new ModelResourceLocation(MODID+":adobe_mixture", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_brick, 0, new ModelResourceLocation(MODID+":adobe_brick", "inventory"));
	}

	private void registerItem(Item item){
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}

	private void registerBlock(Block block){
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
}
