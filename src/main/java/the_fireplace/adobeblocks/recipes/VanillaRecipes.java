package the_fireplace.adobeblocks.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import the_fireplace.adobeblocks.AdobeBlocks;

public class VanillaRecipes {
	static ItemStack waterStack = new ItemStack(Items.water_bucket);
	static ItemStack dirtStack = new ItemStack(Blocks.dirt);
	static ItemStack sandStack = new ItemStack(Blocks.sand, 1, OreDictionary.WILDCARD_VALUE);
	static ItemStack furnaceStack = new ItemStack(Blocks.furnace);
	static ItemStack glassStack = new ItemStack(Blocks.glass);
	static ItemStack stoneStack = new ItemStack(Blocks.stone);
	static ItemStack oakSlabStack = new ItemStack(Blocks.wooden_slab, 1, 0);
	static ItemStack birchSlabStack = new ItemStack(Blocks.wooden_slab, 1, 2);
	static ItemStack spruceSlabStack = new ItemStack(Blocks.wooden_slab, 1, 1);
	static ItemStack jungleSlabStack = new ItemStack(Blocks.wooden_slab, 1, 3);
	static ItemStack acaciaSlabStack = new ItemStack(Blocks.wooden_slab, 1, 4);
	static ItemStack darkOakSlabStack = new ItemStack(Blocks.wooden_slab, 1, 5);

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
	//static ItemStack adobeSlabStack = new ItemStack(AdobeBlocks.adobe_slab);
	static ItemStack adobeSlabStack6 = new ItemStack(AdobeBlocks.adobe_slab, 6);
	static ItemStack adobeStairsStack4 = new ItemStack(AdobeBlocks.adobe_stairs, 4);
	static ItemStack adobeWallStack6 = new ItemStack(AdobeBlocks.adobe_wall, 6);
	static ItemStack stoneStickStack = new ItemStack(AdobeBlocks.stone_stick);
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

	public static void initRecipes() {
		GameRegistry.addShapelessRecipe(throwingStoneStack2, adobeBrickStack);
		GameRegistry.addShapelessRecipe(adobeMixStack9, adobeMixtureBlockStack);
		GameRegistry.addShapelessRecipe(adobeMixStack32, waterStack, dirtStack, dirtStack, dirtStack, dirtStack, sandStack, sandStack, sandStack, sandStack);
		GameRegistry.addRecipe(adobeTileStack4, "iii", "bbb", 'b', adobeBricksStack, 'i', adobeBrickStack);
		GameRegistry.addRecipe(adobeMixtureBlockStack, "mmm", "mmm", "mmm", 'm', adobeMixStack);
		GameRegistry.addRecipe(adobeBricksStack, "bb", "bb", 'b', adobeBrickStack);
		GameRegistry.addRecipe(adobeFurnaceStack, "bbb", "bfb", "bbb", 'b', adobeBricksStack, 'f', furnaceStack);
		GameRegistry.addRecipe(adobeWallStack6, "bbb", "bbb", 'b', adobeBricksStack);
		GameRegistry.addRecipe(adobeStairsStack4, "  b", " bb", "bbb", 'b', adobeBricksStack);
		GameRegistry.addRecipe(adobeStairsStack4, "b  ", "bb ", "bbb", 'b', adobeBricksStack);
		GameRegistry.addRecipe(adobeSlabStack6, "bbb", 'b', adobeBricksStack);
		GameRegistry.addRecipe(adobeGlassStack8, "ggg", "gag", "ggg", 'g', glassStack, 'a', adobeMixStack);
		GameRegistry.addRecipe(stoneStickStack4, "s", "s", 's', stoneStack);
		GameRegistry.addRecipe(adobeSwordStack, "a", "a", "s", 'a', adobeBrickStack, 's', stoneStickStack);
		GameRegistry.addRecipe(adobePickaxeStack, "aaa", " s ", " s ", 'a', adobeBrickStack, 's', stoneStickStack);
		GameRegistry.addRecipe(adobeShovelStack, "a", "s", "s", 'a', adobeBrickStack, 's', stoneStickStack);
		GameRegistry.addRecipe(adobeAxeStack, "aa", "sa", "s ", 'a', adobeBrickStack, 's', stoneStickStack);
		GameRegistry.addRecipe(adobeAxeStack, "aa", "as", " s", 'a', adobeBrickStack, 's', stoneStickStack);
		GameRegistry.addRecipe(adobeHoeStack, "aa", "s ", "s ", 'a', adobeBrickStack, 's', stoneStickStack);
		GameRegistry.addRecipe(adobeHoeStack, "aa", " s", " s", 'a', adobeBrickStack, 's', stoneStickStack);
		GameRegistry.addRecipe(adobeDoorStack3, "bb", "bb", "bb", 'b', adobeBricksStack);
		GameRegistry.addRecipe(adobePaneStack16, "ggg", "ggg", 'g', adobeGlassStack);
		GameRegistry.addShapelessRecipe(oakBeamStack2, oakSlabStack);
		GameRegistry.addShapelessRecipe(birchBeamStack2, birchSlabStack);
		GameRegistry.addShapelessRecipe(spruceBeamStack2, spruceSlabStack);
		GameRegistry.addShapelessRecipe(jungleBeamStack2, jungleSlabStack);
		GameRegistry.addShapelessRecipe(acaciaBeamStack2, acaciaSlabStack);
		GameRegistry.addShapelessRecipe(darkOakBeamStack2, darkOakSlabStack);

		GameRegistry.addSmelting(adobeMixStack, adobeBrickStack, 0.3F);
	}
}
