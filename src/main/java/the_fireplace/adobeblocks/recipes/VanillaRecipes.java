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

	public static void initRecipes(){
		GameRegistry.addShapelessRecipe(adobeMixStack32, waterStack, dirtStack, dirtStack, dirtStack, dirtStack, sandStack, sandStack, sandStack, sandStack);
		GameRegistry.addRecipe(adobeBricksStack, "bb", "bb", 'b', adobeBrickStack);
		GameRegistry.addRecipe(adobeFurnaceStack, "bbb", "bfb", "bbb", 'b', adobeBricksStack, 'f', furnaceStack);
		GameRegistry.addRecipe(adobeWallStack6, "bbb", "bbb", 'b', adobeBricksStack);
		GameRegistry.addRecipe(adobeStairsStack4, "  b", " bb", "bbb", 'b', adobeBricksStack);
		GameRegistry.addRecipe(adobeStairsStack4, "b  ", "bb ", "bbb", 'b', adobeBricksStack);
		GameRegistry.addRecipe(adobeSlabStack6, "bbb", 'b', adobeBricksStack);
		GameRegistry.addRecipe(adobeGlassStack8, "ggg", "gag", "ggg", 'g', glassStack, 'a', adobeMixStack);

		GameRegistry.addSmelting(adobeMixStack, adobeBrickStack, 0.3F);
	}
}
