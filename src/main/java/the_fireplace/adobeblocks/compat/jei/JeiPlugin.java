package the_fireplace.adobeblocks.compat.jei;

import mezz.jei.api.*;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import the_fireplace.adobeblocks.AdobeBlocks;

/**
 * @author The_Fireplace
 */
@JEIPlugin
public class JeiPlugin implements IModPlugin {
	@Override
	public void onJeiHelpersAvailable(IJeiHelpers jeiHelpers) {
		jeiHelpers.getItemBlacklist().addItemToBlacklist(new ItemStack(AdobeBlocks.adobe_block, 1, OreDictionary.WILDCARD_VALUE));
		jeiHelpers.getItemBlacklist().addItemToBlacklist(new ItemStack(AdobeBlocks.lit_adobe_furnace));
	}

	@Override
	public void onItemRegistryAvailable(IItemRegistry itemRegistry) {

	}

	@Override
	public void register(IModRegistry registry) {

	}

	@Override
	public void onRecipeRegistryAvailable(IRecipeRegistry recipeRegistry) {

	}
}
