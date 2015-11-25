package the_fireplace.adobeblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * @author The_Fireplace
 */
public class Beam extends Block {
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");

	public Beam(Material mat) {
		super(mat);
		setDefaultState(this.blockState.getBaseState().withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false)).withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false)));
	}

	/**
	 * Add all collision boxes of this Block to the list that intersect with the given mask.
	 *
	 * @param collidingEntity the Entity colliding with this Block
	 */
	@Override
	public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List list, Entity collidingEntity) {
		boolean flag = this.canConnectTo(worldIn, pos.north());
		boolean flag1 = this.canConnectTo(worldIn, pos.south());
		boolean flag2 = this.canConnectTo(worldIn, pos.west());
		boolean flag3 = this.canConnectTo(worldIn, pos.east());
		float f = 0.375F;
		float f1 = 0.625F;
		float f2 = 0.375F;
		float f3 = 0.625F;

		if (flag) {
			f2 = 0.0F;
		}

		if (flag1) {
			f3 = 1.0F;
		}

		if (flag || flag1) {
			this.setBlockBounds(f, 0.375F, f2, f1, 0.625F, f3);
			super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
		}

		f2 = 0.375F;
		f3 = 0.625F;

		if (flag2) {
			f = 0.0F;
		}

		if (flag3) {
			f1 = 1.0F;
		}

		if (flag2 || flag3 || !flag && !flag1) {
			this.setBlockBounds(f, 0.375F, f2, f1, 0.625F, f3);
			super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
		}

		if (flag) {
			f2 = 0.0F;
		}

		if (flag1) {
			f3 = 1.0F;
		}

		this.setBlockBounds(f, 0.375F, f2, f1, 0.625F, f3);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos) {
		boolean flag = this.canConnectTo(worldIn, pos.north());
		boolean flag1 = this.canConnectTo(worldIn, pos.south());
		boolean flag2 = this.canConnectTo(worldIn, pos.west());
		boolean flag3 = this.canConnectTo(worldIn, pos.east());
		float f = 0.375F;
		float f1 = 0.625F;
		float f2 = 0.375F;
		float f3 = 0.625F;

		if (flag) {
			f2 = 0.0F;
		}

		if (flag1) {
			f3 = 1.0F;
		}

		if (flag2) {
			f = 0.0F;
		}

		if (flag3) {
			f1 = 1.0F;
		}

		this.setBlockBounds(f, 0.375F, f2, f1, 0.625F, f3);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
		return false;
	}

	public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos) {
		Block block = worldIn.getBlockState(pos).getBlock();
		return block == Blocks.barrier ? false : ((!(block instanceof Beam) || block.getMaterial() != this.blockMaterial) ? (block.getMaterial().isOpaque() && block.isFullCube() ? block.getMaterial() != Material.gourd : false) : true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
		return true;
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state) {
		return 0;
	}

	/**
	 * Get the actual Block state of this Block at the given position. This applies properties not visible in the
	 * metadata, such as fence connections.
	 */
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(NORTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.north()))).withProperty(EAST, Boolean.valueOf(this.canConnectTo(worldIn, pos.east()))).withProperty(SOUTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.south()))).withProperty(WEST, Boolean.valueOf(this.canConnectTo(worldIn, pos.west())));
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[]{NORTH, EAST, WEST, SOUTH});
	}
}
