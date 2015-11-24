package the_fireplace.adobeblocks.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import the_fireplace.adobeblocks.AdobeBlocks;

public class AdobePane extends Block {
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");
	private final boolean canDrop;

	public AdobePane(boolean canDrop) {
		super(AdobeBlocks.adobe);
		this.setDefaultState(this.blockState.getBaseState().withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false)).withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false)));
		this.canDrop = canDrop;
		this.setCreativeTab(AdobeBlocks.TabAdobeBlocks);
		this.useNeighborBrightness = true;
	}

	/**
	 * Get the actual Block state of this Block at the given position. This applies properties not visible in the
	 * metadata, such as fence connections.
	 */
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(NORTH, canPaneConnectTo(worldIn, pos, EnumFacing.NORTH))
				.withProperty(SOUTH, canPaneConnectTo(worldIn, pos, EnumFacing.SOUTH))
				.withProperty(WEST, canPaneConnectTo(worldIn, pos, EnumFacing.WEST))
				.withProperty(EAST, canPaneConnectTo(worldIn, pos, EnumFacing.EAST));
	}

	/**
	 * Get the Item that this Block should drop when harvested.
	 *
	 * @param fortune the level of the Fortune enchantment on the player's tool
	 */
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return !this.canDrop ? null : super.getItemDropped(state, rand, fortune);
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
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
		return worldIn.getBlockState(pos).getBlock() == this ? false : super.shouldSideBeRendered(worldIn, pos, side);
	}

	/**
	 * Add all collision boxes of this Block to the list that intersect with the given mask.
	 *
	 * @param collidingEntity the Entity colliding with this Block
	 */
	@Override
	public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List list, Entity collidingEntity) {
		boolean flag = this.canPaneConnectTo(worldIn, pos, EnumFacing.NORTH);
		boolean flag1 = this.canPaneConnectTo(worldIn, pos, EnumFacing.SOUTH);
		boolean flag2 = this.canPaneConnectTo(worldIn, pos, EnumFacing.WEST);
		boolean flag3 = this.canPaneConnectTo(worldIn, pos, EnumFacing.EAST);

		if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1)) {
			if (flag2) {
				this.setBlockBounds(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
				super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
			} else if (flag3) {
				this.setBlockBounds(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
				super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
			}
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
			super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
		}

		if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1)) {
			if (flag) {
				this.setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
				super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
			} else if (flag1) {
				this.setBlockBounds(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
				super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
			}
		} else {
			this.setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
		}
	}

	/**
	 * Sets the block's bounds for rendering it as an item
	 */
	@Override
	public void setBlockBoundsForItemRender() {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos) {
		float f = 0.4375F;
		float f1 = 0.5625F;
		float f2 = 0.4375F;
		float f3 = 0.5625F;
		boolean flag = this.canPaneConnectToBlock(worldIn.getBlockState(pos.north()).getBlock());
		boolean flag1 = this.canPaneConnectToBlock(worldIn.getBlockState(pos.south()).getBlock());
		boolean flag2 = this.canPaneConnectToBlock(worldIn.getBlockState(pos.west()).getBlock());
		boolean flag3 = this.canPaneConnectToBlock(worldIn.getBlockState(pos.east()).getBlock());

		if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1)) {
			if (flag2) {
				f = 0.0F;
			} else if (flag3) {
				f1 = 1.0F;
			}
		} else {
			f = 0.0F;
			f1 = 1.0F;
		}

		if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1)) {
			if (flag) {
				f2 = 0.0F;
			} else if (flag1) {
				f3 = 1.0F;
			}
		} else {
			f2 = 0.0F;
			f3 = 1.0F;
		}

		this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
	}

	public final boolean canPaneConnectToBlock(Block blockIn) {
		return blockIn.isFullBlock() || blockIn == this || blockIn == Blocks.glass || blockIn == Blocks.stained_glass || blockIn == Blocks.stained_glass_pane || blockIn instanceof BlockPane || blockIn == AdobeBlocks.adobe_glass;
	}

	@Override
	protected boolean canSilkHarvest() {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT_MIPPED;
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state) {
		return 0;
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[]{NORTH, EAST, WEST, SOUTH});
	}

	public boolean canPaneConnectTo(IBlockAccess world, BlockPos pos, EnumFacing dir) {
		BlockPos off = pos.offset(dir);
		Block block = world.getBlockState(off).getBlock();
		return canPaneConnectToBlock(block) || block.isSideSolid(world, off, dir.getOpposite());
	}
}
