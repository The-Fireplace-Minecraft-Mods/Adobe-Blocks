package the_fireplace.adobeblocks.recipes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
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
		addShapedRecipe(adobeTileStack4, "iii", "bbb", 'b', adobeBricksStack, 'i', adobeBrickStack);
		addShapedRecipe(adobeMixtureBlockStack, "mmm", "mmm", "mmm", 'm', adobeMixStack);
		addShapedRecipe(adobeBricksStack, "bb", "bb", 'b', adobeBrickStack);
		addShapedRecipe(adobeFurnaceStack, "bbb", "bfb", "bbb", 'b', adobeBricksStack, 'f', furnaceStack);
		addShapedRecipe(adobeWallStack6, "bbb", "bbb", 'b', adobeBricksStack);
		addShapedRecipe(adobeStairsStack4, "  b", " bb", "bbb", 'b', adobeBricksStack);
		addShapedRecipe(adobeStairsStack4, "b  ", "bb ", "bbb", 'b', adobeBricksStack);
		addShapedRecipe(adobeSlabStack6, "bbb", 'b', adobeBricksStack);
		addShapedRecipe(adobeGlassStack8, "ggg", "gag", "ggg", 'g', glassStack, 'a', adobeMixStack);
		addShapedRecipe(stoneStickStack4, "s", "s", 's', stoneStack);
		addShapedRecipe(adobeSwordStack, "a", "a", "s", 'a', adobeBrickStack, 's', stoneStickStack);
		addShapedRecipe(adobePickaxeStack, "aaa", " s ", " s ", 'a', adobeBrickStack, 's', stoneStickStack);
		addShapedRecipe(adobeShovelStack, "a", "s", "s", 'a', adobeBrickStack, 's', stoneStickStack);
		addShapedRecipe(adobeAxeStack, "aa", "sa", "s ", 'a', adobeBrickStack, 's', stoneStickStack);
		addShapedRecipe(adobeAxeStack, "aa", "as", " s", 'a', adobeBrickStack, 's', stoneStickStack);
		addShapedRecipe(adobeHoeStack, "aa", "s ", "s ", 'a', adobeBrickStack, 's', stoneStickStack);
		addShapedRecipe(adobeHoeStack, "aa", " s", " s", 'a', adobeBrickStack, 's', stoneStickStack);
		addShapedRecipe(adobeSwordStack, "a", "a", "s", 'a', adobeBrickStack, 's', stoneRodStack);
		addShapedRecipe(adobePickaxeStack, "aaa", " s ", " s ", 'a', adobeBrickStack, 's', stoneRodStack);
		addShapedRecipe(adobeShovelStack, "a", "s", "s", 'a', adobeBrickStack, 's', stoneRodStack);
		addShapedRecipe(adobeAxeStack, "aa", "sa", "s ", 'a', adobeBrickStack, 's', stoneRodStack);
		addShapedRecipe(adobeAxeStack, "aa", "as", " s", 'a', adobeBrickStack, 's', stoneRodStack);
		addShapedRecipe(adobeHoeStack, "aa", "s ", "s ", 'a', adobeBrickStack, 's', stoneRodStack);
		addShapedRecipe(adobeHoeStack, "aa", " s", " s", 'a', adobeBrickStack, 's', stoneRodStack);
		addShapedRecipe(adobeDoorStack3, "bb", "bb", "bb", 'b', adobeBricksStack);
		addShapedRecipe(adobePaneStack16, "ggg", "ggg", 'g', adobeGlassStack);
		addShapedRecipe(capsuleStack4, " a ", "a a", " a ", 'a', adobeMixStack);
		addShapelessRecipe(oakBeamStack2, oakSlabStack);
		addShapelessRecipe(birchBeamStack2, birchSlabStack);
		addShapelessRecipe(spruceBeamStack2, spruceSlabStack);
		addShapelessRecipe(jungleBeamStack2, jungleSlabStack);
		addShapelessRecipe(acaciaBeamStack2, acaciaSlabStack);
		addShapelessRecipe(darkOakBeamStack2, darkOakSlabStack);

		GameRegistry.addSmelting(adobeMixStack, adobeBrickStack, 0.3F);
	}

	/*
	public static void addRecipe(ItemStack stack, Object... args){
		GameRegistry.addRecipe(new ShapedOreRecipe(stack, args));
	}
	public static void addShapelessRecipe(ItemStack stack, Object... args){
		GameRegistry.addRecipe(new ShapelessOreRecipe(stack, args));
	}	
	*/
	
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private static File RECIPE_DIR = null;
	private static final Set<String> USED_OD_NAMES = new TreeSet<>();

	private static void setupDir() {
		if (RECIPE_DIR == null) {
			RECIPE_DIR = new File("C:\\Users\\cazaw\\Documents\\GitHub\\Adobe-Blocks\\src\\main\\resources\\assets\\adobeblocks\\recipes");
		}

		if (!RECIPE_DIR.exists()) {
			RECIPE_DIR.mkdir();
		}
	}

	private static void addShapedRecipe(ItemStack result, Object... components) {
		setupDir();

		// GameRegistry.addShapedRecipe(result, components);

		Map<String, Object> json = new LinkedHashMap<>();

		List<String> pattern = new ArrayList<>();
		int i = 0;
		while (i < components.length && components[i] instanceof String) {
			pattern.add(((String) components[i]).toUpperCase());
			i++;
		}
		boolean isOreDict = false;
		Map<String, Map<String, Object>> key = new HashMap<>();
		Character curKey = null;
		for (; i < components.length; i++) {
			Object o = components[i];
			if (o instanceof Character) {
				if (curKey != null)
					throw new IllegalArgumentException("Provided two char keys in a row");
				curKey = (Character) o;
			} else {
				if (curKey == null)
					throw new IllegalArgumentException("Providing object without a char key");
				if (o instanceof String)
					isOreDict = true;
				key.put(Character.toString(Character.toUpperCase(curKey)), serializeItem(o));
				curKey = null;
			}
		}
		json.put("type", isOreDict ? "forge:ore_shaped" : "minecraft:crafting_shaped");
		json.put("pattern", pattern);
		json.put("key", key);
		json.put("result", serializeItem(result));

		// names the json the same name as the output's registry name
		// repeatedly adds _alt if a file already exists
		// janky I know but it works
		String suffix = result.getItem().getHasSubtypes() ? "_" + result.getItemDamage() : "";
		File f = new File(RECIPE_DIR, result.getItem().getRegistryName().getResourcePath() + suffix + ".json");

		while (f.exists()) {
			suffix += "_alt";
			f = new File(RECIPE_DIR, result.getItem().getRegistryName().getResourcePath() + suffix + ".json");
		}

		try (FileWriter w = new FileWriter(f)) {
			GSON.toJson(json, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void addShapelessRecipe(ItemStack result, Object... components)
	{
		setupDir();

		// addShapelessRecipe(result, components);

		Map<String, Object> json = new LinkedHashMap<>();

		boolean isOreDict = false;
		List<Map<String, Object>> ingredients = new ArrayList<>();
		for (Object o : components) {
			if (o instanceof String)
				isOreDict = true;
			ingredients.add(serializeItem(o));
		}
		json.put("type", isOreDict ? "forge:ore_shapeless" : "minecraft:crafting_shapeless");
		json.put("ingredients", ingredients);
		json.put("result", serializeItem(result));

		// names the json the same name as the output's registry name
		// repeatedly adds _alt if a file already exists
		// janky I know but it works
		String suffix = result.getItem().getHasSubtypes() ? "_" + result.getItemDamage() : "";
		File f = new File(RECIPE_DIR, result.getItem().getRegistryName().getResourcePath() + suffix + ".json");

		while (f.exists()) {
			suffix += "_alt";
			f = new File(RECIPE_DIR, result.getItem().getRegistryName().getResourcePath() + suffix + ".json");
		}


		try (FileWriter w = new FileWriter(f)) {
			GSON.toJson(json, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Map<String, Object> serializeItem(Object thing) {
		if (thing instanceof Item) {
			return serializeItem(new ItemStack((Item) thing));
		}
		if (thing instanceof Block) {
			return serializeItem(new ItemStack((Block) thing));
		}
		if (thing instanceof ItemStack) {
			ItemStack stack = (ItemStack) thing;
			Map<String, Object> ret = new LinkedHashMap<>();
			if (stack.hasTagCompound())
				ret.put("type", "minecraft:item_nbt");
			ret.put("item", stack.getItem().getRegistryName().toString());
			if (stack.getItem().getHasSubtypes() || stack.getItemDamage() != 0) {
				ret.put("data", stack.getItemDamage());
			}
			if (stack.hasTagCompound()) {
				ret.put("nbt", stack.getTagCompound().toString());
			}
			if (stack.getCount() > 1) {
				ret.put("count", stack.getCount());
			}

			return ret;
		}
		if (thing instanceof String) {
			Map<String, Object> ret = new HashMap<>();
			USED_OD_NAMES.add((String) thing);
			ret.put("item", "#" + ((String) thing).toUpperCase(Locale.ROOT));
			return ret;
		}

		throw new IllegalArgumentException("Not a block, item, stack, or od name");
	}

	public static void generateConstants() {
		List<Map<String, Object>> json = new ArrayList<>();
		for (String s : USED_OD_NAMES) {
			Map<String, Object> entry = new HashMap<>();
			entry.put("name", s.toUpperCase(Locale.ROOT));
			entry.put("ingredient", ImmutableMap.of("type", "forge:ore_dict", "ore", s));
			json.add(entry);
		}

		try (FileWriter w = new FileWriter(new File(RECIPE_DIR, "_constants.json"))) {
			GSON.toJson(json, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
