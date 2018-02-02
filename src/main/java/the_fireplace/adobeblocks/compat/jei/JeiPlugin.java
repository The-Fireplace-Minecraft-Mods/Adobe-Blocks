package the_fireplace.adobeblocks.compat.jei;

import mezz.jei.api.*;
import mezz.jei.api.ingredients.IModIngredientRegistration;
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
	public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) {

	}

	@Override
	public void registerIngredients(IModIngredientRegistration registry) {

	}

	@Override
	public void register(IModRegistry registry) {
		registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(new ItemStack(AdobeBlocks.adobe_block, 1, OreDictionary.WILDCARD_VALUE));
		registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(new ItemStack(AdobeBlocks.lit_adobe_furnace));
		registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(new ItemStack(AdobeBlocks.adobe_door_internal));
		registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(new ItemStack(AdobeBlocks.adobe_double_slab));
	}

	@Override
	public void onRuntimeAvailable(@Nonnull IJeiRuntime jeiRuntime) {

	}
}
