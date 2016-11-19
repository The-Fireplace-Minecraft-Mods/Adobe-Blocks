package the_fireplace.adobeblocks.blocks;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import the_fireplace.adobeblocks.AdobeBlocks;

import java.util.Random;

public abstract class AdobeSlab extends BlockSlab {

	private static final PropertyBool VARIANT_PROPERTY = PropertyBool.create("variant");

	public AdobeSlab() {
		super(AdobeBlocks.adobe);
		if (!this.isDouble())
			setCreativeTab(AdobeBlocks.TabAdobeBlocks);
		setHardness(2.0F);
		setResistance(10.0F);
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
	public Comparable<?> getTypeForItem(ItemStack stack)
	{
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
		if (state.getValue(HALF) == EnumBlockHalf.TOP) {
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
		return Item.getItemFromBlock(AdobeBlocks.adobe_slab);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public final ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(AdobeBlocks.adobe_slab);
	}

	@Override
	protected final BlockStateContainer createBlockState() {
		if (this.isDouble()) {
			return new BlockStateContainer(this, VARIANT_PROPERTY);
		} else {
			return new BlockStateContainer(this, VARIANT_PROPERTY, HALF);
		}
	}
}
