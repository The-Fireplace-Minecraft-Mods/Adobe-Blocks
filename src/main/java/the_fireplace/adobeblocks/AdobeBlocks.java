package the_fireplace.adobeblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import the_fireplace.adobeblocks.blocks.*;
import the_fireplace.adobeblocks.entity.projectile.EntityThrowingStone;
import the_fireplace.adobeblocks.entity.tile.TileEntityAdobeFurnace;
import the_fireplace.adobeblocks.handlers.AdobeBlocksGuiHandler;
import the_fireplace.adobeblocks.handlers.DispenseBehaviorThrowingStone;
import the_fireplace.adobeblocks.items.*;
import the_fireplace.adobeblocks.proxy.CommonProxy;
import the_fireplace.adobeblocks.recipes.VanillaRecipes;

@Mod(modid = AdobeBlocks.MODID, name = AdobeBlocks.MODNAME, updateJSON = "http://caterpillar.bitnamiapp.com/jsons/adobeblocks.json")
public class AdobeBlocks {
	@Instance(AdobeBlocks.MODID)
	public static AdobeBlocks instance;

	public static final String MODID = "adobeblocks";
	public static final String MODNAME = "Adobe Blocks 2";
	public static String VERSION;
	public static final String curseCode = "236104-adobe-blocks-2";

	@SidedProxy(clientSide = "the_fireplace.adobeblocks.proxy.ClientProxy", serverSide = "the_fireplace.adobeblocks.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static ToolMaterial adobeTool = EnumHelper.addToolMaterial("adobe", 1, 177, 2.0F, 1.0F, 15);

	public static final CreativeTabs TabAdobeBlocks = new TabAdobeBlocks("adobe_blocks");
	public static final Material adobe = new Material(MapColor.ADOBE);

	public static final Block adobe_mixture_block = new AdobeMixtureBlock();
	public static final Block adobe_tile = new AdobeTile();
	public static final Block adobe_bricks = new AdobeBricks();
	public static final Block adobe_furnace = new AdobeFurnace(false).setUnlocalizedName("adobe_furnace").setCreativeTab(TabAdobeBlocks);
	public static final Block adobe_wall = new AdobeWall();
	public static final Block lit_adobe_furnace = new AdobeFurnace(true).setUnlocalizedName("lit_adobe_furnace").setLightLevel(0.875F);
	public static final Block adobe_stairs = new AdobeStairs();
	public static final Block adobe_slab = new AdobeHalfSlab();
	public static final Block adobe_glass = new AdobeGlass();
	public static final Block adobe_door_internal = new AdobeDoor();
	public static final Block adobe_glass_pane = new AdobePane().setUnlocalizedName("adobe_glass_pane").setHardness(0.3F);
	public static final Block oak_beam = new Beam(Material.WOOD).setUnlocalizedName("oak_beam").setCreativeTab(AdobeBlocks.TabAdobeBlocks).setHardness(2.0F).setResistance(5.0F);
	public static final Block birch_beam = new Beam(Material.WOOD).setUnlocalizedName("birch_beam").setCreativeTab(AdobeBlocks.TabAdobeBlocks).setHardness(2.0F).setResistance(5.0F);
	public static final Block spruce_beam = new Beam(Material.WOOD).setUnlocalizedName("spruce_beam").setCreativeTab(AdobeBlocks.TabAdobeBlocks).setHardness(2.0F).setResistance(5.0F);
	public static final Block jungle_beam = new Beam(Material.WOOD).setUnlocalizedName("jungle_beam").setCreativeTab(AdobeBlocks.TabAdobeBlocks).setHardness(2.0F).setResistance(5.0F);
	public static final Block dark_oak_beam = new Beam(Material.WOOD).setUnlocalizedName("dark_oak_beam").setCreativeTab(AdobeBlocks.TabAdobeBlocks).setHardness(2.0F).setResistance(5.0F);
	public static final Block acacia_beam = new Beam(Material.WOOD).setUnlocalizedName("acacia_beam").setCreativeTab(AdobeBlocks.TabAdobeBlocks).setHardness(2.0F).setResistance(5.0F);
	public static final Block adobe_block = new AdobeBlock();

	public static final Item adobe_mixture = new Item().setUnlocalizedName("adobe_mixture").setCreativeTab(TabAdobeBlocks);
	public static final Item adobe_brick = new Item().setUnlocalizedName("adobe_brick").setCreativeTab(TabAdobeBlocks);
	public static final Item stone_stick = new Item().setUnlocalizedName("stone_stick").setCreativeTab(TabAdobeBlocks);
	public static final Item adobe_capsule = new Item() {
		@Override
		public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
			RayTraceResult movingobjectposition = this.rayTrace(worldIn, playerIn, true);
			if (movingobjectposition == null) return new ActionResult(EnumActionResult.FAIL, itemStackIn);
			else {
				if (movingobjectposition.typeOfHit == RayTraceResult.Type.BLOCK) {
					BlockPos blockpos = movingobjectposition.getBlockPos();
					if (!worldIn.isBlockModifiable(playerIn, blockpos))
						return new ActionResult(EnumActionResult.FAIL, itemStackIn);
					if (!playerIn.canPlayerEdit(blockpos.offset(movingobjectposition.sideHit), movingobjectposition.sideHit, itemStackIn))
						return new ActionResult(EnumActionResult.FAIL, itemStackIn);
					IBlockState iblockstate = worldIn.getBlockState(blockpos);
					Material material = iblockstate.getMaterial();
					if (material == Material.WATER && iblockstate.getValue(BlockLiquid.LEVEL) == 0) {
						worldIn.setBlockToAir(blockpos);
						return new ActionResult(EnumActionResult.SUCCESS, new ItemStack(filled_adobe_capsule));
					}
				}
			}
			return new ActionResult(EnumActionResult.FAIL, itemStackIn);
		}
	}.setUnlocalizedName("adobe_capsule").setCreativeTab(TabAdobeBlocks);
	public static final Item filled_adobe_capsule = new Item().setUnlocalizedName("filled_adobe_capsule").setCreativeTab(TabAdobeBlocks);
	public static final Item adobe_door = new ItemAdobeDoor(adobe_door_internal);
	public static final Item adobe_sword = new AdobeSword();
	public static final Item adobe_pickaxe = new AdobePickaxe();
	public static final Item adobe_axe = new AdobeAxe();
	public static final Item adobe_shovel = new AdobeShovel();
	public static final Item adobe_hoe = new AdobeHoe();
	public static final Item throwing_stone = new ThrowingStone();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		String[] version = event.getModMetadata().version.split("\\.");
		if (version[3].equals("BUILDNUMBER"))//Dev environment
			VERSION = event.getModMetadata().version.replace("BUILDNUMBER", "9001");
		else//Released build
			VERSION = event.getModMetadata().version;
		AdobeSlab doubleSlab = new AdobeDoubleSlab();

		NetworkRegistry.INSTANCE.registerGuiHandler(this, new AdobeBlocksGuiHandler());
		GameRegistry.registerTileEntity(TileEntityAdobeFurnace.class, "adobe_furnace");
		GameRegistry.registerBlock(adobe_slab, ItemBlockAdobeSlab.class, "adobe_slab", adobe_slab, doubleSlab, false);
		GameRegistry.registerBlock(doubleSlab, ItemBlockAdobeSlab.class, "double_adobe_slab", adobe_slab, doubleSlab, true);
		registerBlock(adobe_mixture_block);
		registerBlock(adobe_tile);
		registerBlock(adobe_bricks);
		registerBlock(adobe_furnace);
		registerBlock(lit_adobe_furnace);
		registerBlock(adobe_wall);
		registerBlock(adobe_stairs);
		registerBlock(adobe_glass);
		registerBlock(adobe_door_internal);
		registerBlock(adobe_glass_pane);
		registerBlock(oak_beam);
		registerBlock(birch_beam);
		registerBlock(spruce_beam);
		registerBlock(jungle_beam);
		registerBlock(dark_oak_beam);
		registerBlock(acacia_beam);
		GameRegistry.registerBlock(adobe_block, ItemAdobeBlock.class, "adobe_block");
		registerItem(adobe_mixture);
		registerItem(adobe_brick);
		registerItem(adobe_sword);
		registerItem(adobe_pickaxe);
		registerItem(adobe_axe);
		registerItem(adobe_shovel);
		registerItem(adobe_capsule);
		registerItem(filled_adobe_capsule);
		registerItem(stone_stick);
		registerItem(adobe_door);
		registerItem(throwing_stone);
		registerItem(adobe_hoe);

		int eid = -1;
		EntityRegistry.registerModEntity(EntityThrowingStone.class, "adobe_thrown_stone", ++eid, instance, 64, 10, true);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(throwing_stone, new DispenseBehaviorThrowingStone());
		VanillaRecipes.initRecipes();
		proxy.registerRenderers();
		if (event.getSide().isClient())
			registerItemRenders();
	}

	@SideOnly(Side.CLIENT)
	private void registerItemRenders() {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_mixture_block), 0, new ModelResourceLocation(MODID + ":adobe_mixture_block", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_tile), 0, new ModelResourceLocation(MODID + ":adobe_tile", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_bricks), 0, new ModelResourceLocation(MODID + ":adobe_bricks", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_furnace), 0, new ModelResourceLocation(MODID + ":adobe_furnace", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(lit_adobe_furnace), 0, new ModelResourceLocation(MODID + ":adobe_furnace", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_wall), 0, new ModelResourceLocation(MODID + ":adobe_wall", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_stairs), 0, new ModelResourceLocation(MODID + ":adobe_stairs", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_slab), 0, new ModelResourceLocation(MODID + ":adobe_slab", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_glass), 0, new ModelResourceLocation(MODID + ":adobe_glass", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_glass_pane), 0, new ModelResourceLocation(MODID + ":adobe_glass_pane", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(oak_beam), 0, new ModelResourceLocation(MODID + ":oak_beam", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(spruce_beam), 0, new ModelResourceLocation(MODID + ":spruce_beam", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(jungle_beam), 0, new ModelResourceLocation(MODID + ":jungle_beam", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(birch_beam), 0, new ModelResourceLocation(MODID + ":birch_beam", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(dark_oak_beam), 0, new ModelResourceLocation(MODID + ":dark_oak_beam", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(acacia_beam), 0, new ModelResourceLocation(MODID + ":acacia_beam", "inventory"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(adobe_block),
				new ModelResourceLocation(MODID + ":after_effects", "inventory"),
				new ModelResourceLocation(MODID + ":audition", "inventory"),
				new ModelResourceLocation(MODID + ":bridge", "inventory"),
				new ModelResourceLocation(MODID + ":dreamweaver", "inventory"),
				new ModelResourceLocation(MODID + ":encore", "inventory"),
				new ModelResourceLocation(MODID + ":fireworks", "inventory"),
				new ModelResourceLocation(MODID + ":flash", "inventory"),
				new ModelResourceLocation(MODID + ":flash_builder", "inventory"),
				new ModelResourceLocation(MODID + ":illustrator", "inventory"),
				new ModelResourceLocation(MODID + ":indesign", "inventory"),
				new ModelResourceLocation(MODID + ":lightroom", "inventory"),
				new ModelResourceLocation(MODID + ":photoshop", "inventory"),
				new ModelResourceLocation(MODID + ":prelude", "inventory"),
				new ModelResourceLocation(MODID + ":premier_pro", "inventory"),
				new ModelResourceLocation(MODID + ":speedgrade", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_block), 0, new ModelResourceLocation(MODID + ":after_effects", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_block), 1, new ModelResourceLocation(MODID + ":audition", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_block), 2, new ModelResourceLocation(MODID + ":bridge", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_block), 3, new ModelResourceLocation(MODID + ":dreamweaver", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_block), 4, new ModelResourceLocation(MODID + ":encore", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_block), 5, new ModelResourceLocation(MODID + ":fireworks", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_block), 6, new ModelResourceLocation(MODID + ":flash", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_block), 7, new ModelResourceLocation(MODID + ":flash_builder", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_block), 8, new ModelResourceLocation(MODID + ":illustrator", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_block), 9, new ModelResourceLocation(MODID + ":indesign", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_block), 10, new ModelResourceLocation(MODID + ":lightroom", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_block), 11, new ModelResourceLocation(MODID + ":photoshop", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_block), 12, new ModelResourceLocation(MODID + ":prelude", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_block), 13, new ModelResourceLocation(MODID + ":premier_pro", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(adobe_block), 14, new ModelResourceLocation(MODID + ":speedgrade", "inventory"));

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_mixture, 0, new ModelResourceLocation(MODID + ":adobe_mixture", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_brick, 0, new ModelResourceLocation(MODID + ":adobe_brick", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_sword, 0, new ModelResourceLocation(MODID + ":adobe_sword", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_pickaxe, 0, new ModelResourceLocation(MODID + ":adobe_pickaxe", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_axe, 0, new ModelResourceLocation(MODID + ":adobe_axe", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_shovel, 0, new ModelResourceLocation(MODID + ":adobe_shovel", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_hoe, 0, new ModelResourceLocation(MODID + ":adobe_hoe", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(stone_stick, 0, new ModelResourceLocation(MODID + ":stone_stick", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_door, 0, new ModelResourceLocation(MODID + ":adobe_door", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(throwing_stone, 0, new ModelResourceLocation(MODID + ":adobe_throwing_stone", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(adobe_capsule, 0, new ModelResourceLocation(MODID + ":adobe_capsule", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(filled_adobe_capsule, 0, new ModelResourceLocation(MODID + ":filled_adobe_capsule", "inventory"));
	}

	private void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}

	private void registerBlock(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
}
