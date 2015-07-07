package the_fireplace.adobeblocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import the_fireplace.adobeblocks.blocks.AdobeBricks;
import the_fireplace.adobeblocks.blocks.AdobeDoor;
import the_fireplace.adobeblocks.blocks.AdobeDoubleSlab;
import the_fireplace.adobeblocks.blocks.AdobeFurnace;
import the_fireplace.adobeblocks.blocks.AdobeGlass;
import the_fireplace.adobeblocks.blocks.AdobeHalfSlab;
import the_fireplace.adobeblocks.blocks.AdobePane;
import the_fireplace.adobeblocks.blocks.AdobeSlab;
import the_fireplace.adobeblocks.blocks.AdobeStairs;
import the_fireplace.adobeblocks.blocks.AdobeWall;
import the_fireplace.adobeblocks.blocks.ItemBlockAdobeSlab;
import the_fireplace.adobeblocks.entity.projectile.EntityThrowingStone;
import the_fireplace.adobeblocks.entity.tile.TileEntityAdobeFurnace;
import the_fireplace.adobeblocks.firecorecompat.FCCompat;
import the_fireplace.adobeblocks.firecorecompat.FCCompatDummy;
import the_fireplace.adobeblocks.firecorecompat.IFCCompat;
import the_fireplace.adobeblocks.handlers.AdobeBlocksGuiHandler;
import the_fireplace.adobeblocks.items.AdobeAxe;
import the_fireplace.adobeblocks.items.AdobeHoe;
import the_fireplace.adobeblocks.items.AdobePickaxe;
import the_fireplace.adobeblocks.items.AdobeShovel;
import the_fireplace.adobeblocks.items.AdobeSword;
import the_fireplace.adobeblocks.items.ItemAdobeDoor;
import the_fireplace.adobeblocks.items.ThrowingStone;
import the_fireplace.adobeblocks.proxy.CommonProxy;
import the_fireplace.adobeblocks.recipes.VanillaRecipes;

@Mod(modid=AdobeBlocks.MODID, name=AdobeBlocks.MODNAME, version=AdobeBlocks.VERSION)
public class AdobeBlocks {
	@Instance(AdobeBlocks.MODID)
	public static AdobeBlocks instance;

	public static final String MODID = "adobeblocks";
	public static final String MODNAME = "Adobe Blocks";
	public static final String VERSION = "2.0.1.0";
	public static final String downloadURL = "http://goo.gl/lT6oNC";

	@SidedProxy(clientSide="the_fireplace.adobeblocks.proxy.ClientProxy", serverSide="the_fireplace.adobeblocks.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static ToolMaterial adobeTool = EnumHelper.addToolMaterial("adobe", 1, 177, 2.0F, 1.0F, 15);

	public static final CreativeTabs TabAdobeBlocks = new TabAdobeBlocks("adobe_blocks");
	public static final Material adobe = new Material(MapColor.adobeColor);

	public static final Block adobe_bricks = new AdobeBricks();
	public static final Block adobe_furnace = new AdobeFurnace(false).setUnlocalizedName("adobe_furnace").setCreativeTab(TabAdobeBlocks);
	public static final Block adobe_wall = new AdobeWall();
	public static final Block lit_adobe_furnace = new AdobeFurnace(true).setUnlocalizedName("lit_adobe_furnace").setLightLevel(0.875F);
	public static final Block adobe_stairs = new AdobeStairs();
	public static final Block adobe_slab = new AdobeHalfSlab();
	public static final Block adobe_glass = new AdobeGlass();
	public static final Block adobe_door_internal = new AdobeDoor();
	public static final Block adobe_glass_pane = new AdobePane(false).setUnlocalizedName("adobe_glass_pane").setHardness(0.3F).setStepSound(Block.soundTypeGlass);

	public static final Item adobe_mixture = new Item().setUnlocalizedName("adobe_mixture").setCreativeTab(TabAdobeBlocks);
	public static final Item adobe_brick = new Item().setUnlocalizedName("adobe_brick").setCreativeTab(TabAdobeBlocks);
	public static final Item stone_stick = new Item().setUnlocalizedName("stone_stick").setCreativeTab(TabAdobeBlocks);
	public static final Item adobe_door = new ItemAdobeDoor(adobe_door_internal);
	public static final Item adobe_sword = new AdobeSword();
	public static final Item adobe_pickaxe = new AdobePickaxe();
	public static final Item adobe_axe = new AdobeAxe();
	public static final Item adobe_shovel = new AdobeShovel();
	public static final Item adobe_hoe = new AdobeHoe();
	public static final Item throwing_stone = new ThrowingStone();

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
		registerBlock(adobe_glass);
		registerBlock(adobe_door_internal);
		registerBlock(adobe_glass_pane);
		registerItem(adobe_mixture);
		registerItem(adobe_brick);
		registerItem(adobe_sword);
		registerItem(adobe_pickaxe);
		registerItem(adobe_axe);
		registerItem(adobe_shovel);
		registerItem(adobe_hoe);
		registerItem(stone_stick);
		registerItem(adobe_door);
		registerItem(throwing_stone);

		int eid=0;
		EntityRegistry.registerModEntity(EntityThrowingStone.class, "adobe_thrown_stone", eid++, instance, 64, 10, true);
		IFCCompat compat;
		if(Loader.isModLoaded("fireplacecore")){
			compat = new FCCompat();
		}else{
			compat = new FCCompatDummy();
		}
		compat.register();
	}

	@EventHandler
	public void init(FMLInitializationEvent event){
		VanillaRecipes.initRecipes();
		proxy.registerRenderers();
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
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_glass), 0, new ModelResourceLocation(MODID+":adobe_glass", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_glass_pane), 0, new ModelResourceLocation(MODID+":adobe_glass_pane", "inventory"));

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_mixture, 0, new ModelResourceLocation(MODID+":adobe_mixture", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_brick, 0, new ModelResourceLocation(MODID+":adobe_brick", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_sword, 0, new ModelResourceLocation(MODID+":adobe_sword", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_pickaxe, 0, new ModelResourceLocation(MODID+":adobe_pickaxe", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_axe, 0, new ModelResourceLocation(MODID+":adobe_axe", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_shovel, 0, new ModelResourceLocation(MODID+":adobe_shovel", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_hoe, 0, new ModelResourceLocation(MODID+":adobe_hoe", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(stone_stick, 0, new ModelResourceLocation(MODID+":stone_stick", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_door, 0, new ModelResourceLocation(MODID+":adobe_door", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(throwing_stone, 0, new ModelResourceLocation(MODID+":adobe_throwing_stone", "inventory"));
	}

	private void registerItem(Item item){
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}

	private void registerBlock(Block block){
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
}
