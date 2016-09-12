package the_fireplace.adobeblocks.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import the_fireplace.adobeblocks.AdobeBlocks;

public class VanillaRecipes {
	static ItemStack waterStack = new ItemStack(Items.WATER_BUCKET);
	static String dirtStack = "dirt";
	static String sandStack = "sand";
	static ItemStack furnaceStack = new ItemStack(Blocks.FURNACE);
	static String glassStack = "blockGlass";
	static String stoneStack = "stone";
	static ItemStack oakSlabStack = new ItemStack(Blocks.WOODEN_SLAB, 1, 0);
	static ItemStack birchSlabStack = new ItemStack(Blocks.WOODEN_SLAB, 1, 2);
	static ItemStack spruceSlabStack = new ItemStack(Blocks.WOODEN_SLAB, 1, 1);
	static ItemStack jungleSlabStack = new ItemStack(Blocks.WOODEN_SLAB, 1, 3);
	static ItemStack acaciaSlabStack = new ItemStack(Blocks.WOODEN_SLAB, 1, 4);
	static ItemStack darkOakSlabStack = new ItemStack(Blocks.WOODEN_SLAB, 1, 5);

	static ItemStack adobeBrickStack = new ItemStack(AdobeBlocks.adobe_brick);
	static ItemStack adobeBricksStack = new ItemStack(AdobeBlocks.adobe_bricks);
	//static ItemStack adobeTileStack = new ItemStack(AdobeBlocks.adobe_tile);
	static ItemStack adobeTileStack4 = new ItemStack(AdobeBlocks.adobe_tile, 4);
	static ItemStack adobeMixtureBlockStack = new ItemStack(AdobeBlocks.adobe_mixture_block);
	//static ItemStack adobeDoorStack = new ItemStack(AdobeBlocks.adobe_door);
	static ItemStack adobeDoorStack3 = new ItemStack(AdobeBlocks.adobe_door, 3);
	static ItemStack adobeFurnaceStack = new ItemStack(AdobeBlocks.adobe_furnace);
	static ItemStack adobeGlassStack = new ItemStack(AdobeBlocks.adobe_glass);
	static ItemStack adobeGlassStack8 = new ItemStack(AdobeBlocks.adobe_glass, 8);
	static ItemStack adobePaneStack16 = new ItemStack(AdobeBlocks.adobe_glass_pane, 16);
	static ItemStack adobeMixStack = new ItemStack(AdobeBlocks.adobe_mixture);
	static ItemStack adobeMixStack9 = new ItemStack(AdobeBlocks.adobe_mixture, 9);
	static ItemStack adobeMixStack32 = new ItemStack(AdobeBlocks.adobe_mixture, 32);
	static ItemStack adobeMixStack33 = new ItemStack(AdobeBlocks.adobe_mixture, 33);
	//static ItemStack adobeSlabStack = new ItemStack(AdobeBlocks.adobe_slab);
	static ItemStack adobeSlabStack6 = new ItemStack(AdobeBlocks.adobe_slab, 6);
	static ItemStack adobeStairsStack4 = new ItemStack(AdobeBlocks.adobe_stairs, 4);
	static ItemStack adobeWallStack6 = new ItemStack(AdobeBlocks.adobe_wall, 6);
	static String stoneStickStack = "stickStone";
	static String stoneRodStack = "rodStone";
	static ItemStack stoneStickStack4 = new ItemStack(AdobeBlocks.stone_stick, 6);
	static ItemStack adobeSwordStack = new ItemStack(AdobeBlocks.adobe_sword);
	static ItemStack adobeAxeStack = new ItemStack(AdobeBlocks.adobe_axe);
	static ItemStack adobePickaxeStack = new ItemStack(AdobeBlocks.adobe_pickaxe);
	static ItemStack adobeShovelStack = new ItemStack(AdobeBlocks.adobe_shovel);
	static ItemStack adobeHoeStack = new ItemStack(AdobeBlocks.adobe_hoe);
	//static ItemStack oakBeamStack = new ItemStack(AdobeBlocks.oak_beam);
	//static ItemStack birchBeamStack = new ItemStack(AdobeBlocks.birch_beam);
	//static ItemStack spruceBeamStack = new ItemStack(AdobeBlocks.spruce_beam);
	//static ItemStack jungleBeamStack = new ItemStack(AdobeBlocks.jungle_beam);
	//static ItemStack darkOakBeamStack = new ItemStack(AdobeBlocks.dark_oak_beam);
	//static ItemStack acaciaBeamStack = new ItemStack(AdobeBlocks.acacia_beam);
	static ItemStack oakBeamStack2 = new ItemStack(AdobeBlocks.oak_beam, 2);
	static ItemStack birchBeamStack2 = new ItemStack(AdobeBlocks.birch_beam, 2);
	static ItemStack spruceBeamStack2 = new ItemStack(AdobeBlocks.spruce_beam, 2);
	static ItemStack jungleBeamStack2 = new ItemStack(AdobeBlocks.jungle_beam, 2);
	static ItemStack darkOakBeamStack2 = new ItemStack(AdobeBlocks.dark_oak_beam, 2);
	static ItemStack acaciaBeamStack2 = new ItemStack(AdobeBlocks.acacia_beam, 2);
	static ItemStack throwingStoneStack2 = new ItemStack(AdobeBlocks.throwing_stone);
	//static ItemStack capsuleStack = new ItemStack(AdobeBlocks.adobe_capsule);
	static ItemStack capsuleStack4 = new ItemStack(AdobeBlocks.adobe_capsule, 4);
	static ItemStack filledCapsuleStack = new ItemStack(AdobeBlocks.filled_adobe_capsule);

	public static void initRecipes() {
		addShapelessRecipe(throwingStoneStack2, adobeBrickStack);
		addShapelessRecipe(adobeMixStack9, adobeMixtureBlockStack);
		addShapelessRecipe(adobeMixStack32, waterStack, dirtStack, dirtStack, dirtStack, dirtStack, sandStack, sandStack, sandStack, sandStack);
		addShapelessRecipe(adobeMixStack33, filledCapsuleStack, dirtStack, dirtStack, dirtStack, dirtStack, sandStack, sandStack, sandStack, sandStack);
		addRecipe(adobeTileStack4, "iii", "bbb", 'b', adobeBricksStack, 'i', adobeBrickStack);
		addRecipe(adobeMixtureBlockStack, "mmm", "mmm", "mmm", 'm', adobeMixStack);
		addRecipe(adobeBricksStack, "bb", "bb", 'b', adobeBrickStack);
		addRecipe(adobeFurnaceStack, "bbb", "bfb", "bbb", 'b', adobeBricksStack, 'f', furnaceStack);
		addRecipe(adobeWallStack6, "bbb", "bbb", 'b', adobeBricksStack);
		addRecipe(adobeStairsStack4, "  b", " bb", "bbb", 'b', adobeBricksStack);
		addRecipe(adobeStairsStack4, "b  ", "bb ", "bbb", 'b', adobeBricksStack);
		addRecipe(adobeSlabStack6, "bbb", 'b', adobeBricksStack);
		addRecipe(adobeGlassStack8, "ggg", "gag", "ggg", 'g', glassStack, 'a', adobeMixStack);
		addRecipe(stoneStickStack4, "s", "s", 's', stoneStack);
		addRecipe(adobeSwordStack, "a", "a", "s", 'a', adobeBrickStack, 's', stoneStickStack);
		addRecipe(adobePickaxeStack, "aaa", " s ", " s ", 'a', adobeBrickStack, 's', stoneStickStack);
		addRecipe(adobeShovelStack, "a", "s", "s", 'a', adobeBrickStack, 's', stoneStickStack);
		addRecipe(adobeAxeStack, "aa", "sa", "s ", 'a', adobeBrickStack, 's', stoneStickStack);
		addRecipe(adobeAxeStack, "aa", "as", " s", 'a', adobeBrickStack, 's', stoneStickStack);
		addRecipe(adobeHoeStack, "aa", "s ", "s ", 'a', adobeBrickStack, 's', stoneStickStack);
		addRecipe(adobeHoeStack, "aa", " s", " s", 'a', adobeBrickStack, 's', stoneStickStack);
		addRecipe(adobeSwordStack, "a", "a", "s", 'a', adobeBrickStack, 's', stoneRodStack);
		addRecipe(adobePickaxeStack, "aaa", " s ", " s ", 'a', adobeBrickStack, 's', stoneRodStack);
		addRecipe(adobeShovelStack, "a", "s", "s", 'a', adobeBrickStack, 's', stoneRodStack);
		addRecipe(adobeAxeStack, "aa", "sa", "s ", 'a', adobeBrickStack, 's', stoneRodStack);
		addRecipe(adobeAxeStack, "aa", "as", " s", 'a', adobeBrickStack, 's', stoneRodStack);
		addRecipe(adobeHoeStack, "aa", "s ", "s ", 'a', adobeBrickStack, 's', stoneRodStack);
		addRecipe(adobeHoeStack, "aa", " s", " s", 'a', adobeBrickStack, 's', stoneRodStack);
		addRecipe(adobeDoorStack3, "bb", "bb", "bb", 'b', adobeBricksStack);
		addRecipe(adobePaneStack16, "ggg", "ggg", 'g', adobeGlassStack);
		addRecipe(capsuleStack4, " a ", "a a", " a ", 'a', adobeMixStack);
		addShapelessRecipe(oakBeamStack2, oakSlabStack);
		addShapelessRecipe(birchBeamStack2, birchSlabStack);
		addShapelessRecipe(spruceBeamStack2, spruceSlabStack);
		addShapelessRecipe(jungleBeamStack2, jungleSlabStack);
		addShapelessRecipe(acaciaBeamStack2, acaciaSlabStack);
		addShapelessRecipe(darkOakBeamStack2, darkOakSlabStack);

		GameRegistry.addSmelting(adobeMixStack, adobeBrickStack, 0.3F);
	}

	public static void addRecipe(ItemStack stack, Object... args){
		GameRegistry.addRecipe(new ShapedOreRecipe(stack, args));
	}

	public static void addShapelessRecipe(ItemStack stack, Object... args){
		GameRegistry.addRecipe(new ShapelessOreRecipe(stack, args));
	}
}
