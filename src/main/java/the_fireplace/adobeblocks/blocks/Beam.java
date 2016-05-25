package the_fireplace.adobeblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author The_Fireplace
 */
public class Beam extends Block {
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");

	public static final AxisAlignedBB CENTER_AABB = new AxisAlignedBB(0.375D, 0.375D, 0.375D, 0.625D, 0.625D, 0.625D);
	public static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.375F, 0.375F, 0.375F, 0.625F, 0.625F, 1.0F);
	public static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.0F, 0.375F, 0.375F, 0.625F, 0.625F, 0.625F);
	public static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.375F, 0.375F, 0.0F, 0.625F, 0.625F, 0.625F);
	public static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.375F, 0.375F, 0.375F, 0.625F, 0.625F, 1.0F);

	public Beam(Material mat) {
		super(mat);
		setDefaultState(this.blockState.getBaseState().withProperty(NORTH, false).withProperty(EAST, false).withProperty(SOUTH, false).withProperty(WEST, false));
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn) {
		state = state.getActualState(worldIn, pos);
		addCollisionBoxToList(pos, entityBox, collidingBoxes, CENTER_AABB);

		if (state.getValue(NORTH))
		{
			addCollisionBoxToList(pos, entityBox, collidingBoxes, NORTH_AABB);
		}

		if (state.getValue(EAST))
		{
			addCollisionBoxToList(pos, entityBox, collidingBoxes, EAST_AABB);
		}

		if (state.getValue(SOUTH))
		{
			addCollisionBoxToList(pos, entityBox, collidingBoxes, SOUTH_AABB);
		}

		if (state.getValue(WEST))
		{
			addCollisionBoxToList(pos, entityBox, collidingBoxes, WEST_AABB);
		}
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		boolean flag = this.canConnectTo(state, source, pos.north());
		boolean flag1 = this.canConnectTo(state, source, pos.south());
		boolean flag2 = this.canConnectTo(state, source, pos.west());
		boolean flag3 = this.canConnectTo(state, source, pos.east());
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

		return new AxisAlignedBB(f, 0.375F, f2, f1, 0.625F, f3);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
		return false;
	}

	public boolean canConnectTo(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		Block block = worldIn.getBlockState(pos).getBlock();
		return block != Blocks.BARRIER && (!(!(block instanceof Beam) || block.getMaterial(state) != this.blockMaterial) || ((block.getMaterial(state).isOpaque() && block.isFullCube(state)) && block.getMaterial(state) != Material.GOURD));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState state, IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
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
		return state.withProperty(NORTH, this.canConnectTo(state, worldIn, pos.north())).withProperty(EAST, this.canConnectTo(state, worldIn, pos.east())).withProperty(SOUTH, this.canConnectTo(state, worldIn, pos.south())).withProperty(WEST, this.canConnectTo(state, worldIn, pos.west()));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, NORTH, EAST, WEST, SOUTH);
	}
}
