package the_fireplace.adobeblocks.compat.jei;

import mezz.jei.api.*;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import the_fireplace.adobeblocks.AdobeBlocks;

import javax.annotation.Nonnull;

/**
 * @author The_Fireplace
 */
@JEIPlugin
public class JeiPlugin implements IModPlugin {

	@Override
	public void register(IModRegistry registry) {
		registry.getJeiHelpers().getItemBlacklist().addItemToBlacklist(new ItemStack(AdobeBlocks.adobe_block, 1, OreDictionary.WILDCARD_VALUE));
		registry.getJeiHelpers().getItemBlacklist().addItemToBlacklist(new ItemStack(AdobeBlocks.lit_adobe_furnace));
	}

	@Override
	public void onRuntimeAvailable(@Nonnull IJeiRuntime jeiRuntime) {

	}
}
