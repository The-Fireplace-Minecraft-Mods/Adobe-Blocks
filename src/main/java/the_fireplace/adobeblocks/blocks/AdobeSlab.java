package the_fireplace.adobeblocks.blocks;

import java.util.Random;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import the_fireplace.adobeblocks.AdobeBlocks;

public abstract class AdobeSlab extends BlockSlab {

	private static final PropertyBool VARIANT_PROPERTY = PropertyBool.create("variant");

	public AdobeSlab() {
		super(AdobeBlocks.adobe);
		if (!this.isDouble())
			setCreativeTab(AdobeBlocks.TabAdobeBlocks);
		setHardness(2.0F);
		setResistance(10.0F);
		setStepSound(soundTypePiston);
		setHarvestLevel("pickaxe", 0);
		this.useNeighborBrightness = !this.isDouble();
		setUnlocalizedName("adobe_slab");

		IBlockState blockState = this.blockState.getBaseState();
		blockState = blockState.withProperty(VARIANT_PROPERTY, false);
		if (!this.isDouble()) {
			blockState = blockState.withProperty(HALF, EnumBlockHalf.BOTTOM);
		}
		setDefaultState(blockState);
	}

	@Override
	public IProperty getVariantProperty() {
		return VARIANT_PROPERTY;
	}

	@Override
	public Object getVariant(ItemStack stack) {
		return false;
	}

	@Override
	public String getUnlocalizedName(int meta) {
		return this.getUnlocalizedName();
	}

	@Override
	public final IBlockState getStateFromMeta(final int meta) {
		IBlockState state = this.getDefaultState();
		state = state.withProperty(VARIANT_PROPERTY, false);
		if (!this.isDouble()) {
			EnumBlockHalf value = EnumBlockHalf.BOTTOM;
			if ((meta & 8) != 0) {
				value = EnumBlockHalf.TOP;
			}

			state = state.withProperty(HALF, value);
		}
		return state;
	}

	@Override
	public final int getMetaFromState(final IBlockState state) {
		if (this.isDouble()) {
			return 0;
		}
		if ((EnumBlockHalf) state.getValue(HALF) == EnumBlockHalf.TOP) {
			return 8;
		} else {
			return 0;
		}
	}

	@Override
	public final int damageDropped(final IBlockState state) {
		return 0;
	}

	@Override
	public final Item getItemDropped(IBlockState state, Random rand, int unused) {
		return getItemFromBlock(innerGetId(false));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public final Item getItem(World world, BlockPos pos) {
		return getItemFromBlock(innerGetId(false));
	}

	@Override
	protected final BlockState createBlockState() {
		if (this.isDouble()) {
			return new BlockState(this, new IProperty[]{VARIANT_PROPERTY});
		} else {
			return new BlockState(this, new IProperty[]{VARIANT_PROPERTY, HALF});
		}
	}

	private String innerGetId(boolean isDoubleStacked) {
		String result = "";
		if (isDoubleStacked) {
			result = "double_";
		}
		return result + "adobe_slab";
	}

	private static Item getItemFromBlock(String name) {
		return GameRegistry.findItem(AdobeBlocks.MODID, name);
	}
}
