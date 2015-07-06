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

	static ItemStack adobeBrickStack = new ItemStack(AdobeBlocks.adobe_brick);
	static ItemStack adobeBricksStack = new ItemStack(AdobeBlocks.adobe_bricks);
	static ItemStack adobeFurnaceStack = new ItemStack(AdobeBlocks.adobe_furnace);
	static ItemStack adobeGlassStack = new ItemStack(AdobeBlocks.adobe_glass);
	static ItemStack adobeGlassStack8 = new ItemStack(AdobeBlocks.adobe_glass, 8);
	static ItemStack adobeMixStack = new ItemStack(AdobeBlocks.adobe_mixture);
	static ItemStack adobeMixStack32 = new ItemStack(AdobeBlocks.adobe_mixture, 32);
	static ItemStack adobeSlabStack = new ItemStack(AdobeBlocks.adobe_slab);
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

	public static void initRecipes(){
		GameRegistry.addShapelessRecipe(adobeMixStack32, waterStack, dirtStack, dirtStack, dirtStack, dirtStack, sandStack, sandStack, sandStack, sandStack);
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

		GameRegistry.addSmelting(adobeMixStack, adobeBrickStack, 0.3F);
	}
}
