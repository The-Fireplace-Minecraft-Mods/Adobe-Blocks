package the_fireplace.adobeblocks.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import the_fireplace.adobeblocks.AdobeBlocks;

public class AdobeGlass extends Block {

	public AdobeGlass() {
		super(AdobeBlocks.adobe);
		setUnlocalizedName("adobe_glass");
		setHardness(0.3F);
		setStepSound(soundTypeGlass);
		setCreativeTab(AdobeBlocks.TabAdobeBlocks);
		this.useNeighborBrightness = true;
	}

	@Override
	public int quantityDropped(Random random) {
		return 0;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	protected boolean canSilkHarvest() {
		return true;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();

		if (worldIn.getBlockState(pos.offset(side.getOpposite())) != iblockstate) {
			return true;
		}

		if (block == this) {
			return false;
		}

		return true;
	}
}
