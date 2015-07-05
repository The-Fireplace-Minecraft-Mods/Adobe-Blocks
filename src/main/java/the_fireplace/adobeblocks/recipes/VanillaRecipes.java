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
	static ItemStack sandStack = new ItemStack(Blocks.sand, 1, OreDictionary.WILDCARD_VALUE);//The second argument is the amount, the third argument tells it the metadata, in this case, the wildcard value, meaning any kind of metadata for that block.
	
	static ItemStack adobeBrickStack = new ItemStack(AdobeBlocks.adobe_brick);
	static ItemStack adobeMixStack = new ItemStack(AdobeBlocks.adobe_mixture);
	static ItemStack adobeMixStack32 = new ItemStack(AdobeBlocks.adobe_mixture, 32);
	
	public static void initRecipes(){
		GameRegistry.addShapelessRecipe(adobeMixStack32, waterStack, dirtStack, dirtStack, dirtStack, dirtStack, sandStack, sandStack, sandStack, sandStack);
		
		GameRegistry.addSmelting(adobeMixStack, adobeBrickStack, 0.3F);
	}
}
