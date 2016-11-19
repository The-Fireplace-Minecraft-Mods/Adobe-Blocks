package the_fireplace.adobeblocks.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import the_fireplace.adobeblocks.AdobeBlocks;

public class ItemAdobeDoor extends Item {
	private Block block;

	public ItemAdobeDoor(Block block) {
		this.block = block;
		setUnlocalizedName("adobe_door_item");
		setCreativeTab(AdobeBlocks.TabAdobeBlocks);
	}

	/**
	 * Called when a Block is right-clicked with this Item
	 *
	 * @param pos  The block being right-clicked
	 */
	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (side != EnumFacing.UP) {
			return EnumActionResult.FAIL;
		} else {
			IBlockState iblockstate = worldIn.getBlockState(pos);
			Block block = iblockstate.getBlock();

			if (!block.isReplaceable(worldIn, pos)) {
				pos = pos.offset(side);
			}

			if (!playerIn.canPlayerEdit(pos, side, playerIn.getHeldItem(hand))) {
				return EnumActionResult.FAIL;
			} else if (!this.block.canPlaceBlockAt(worldIn, pos)) {
				return EnumActionResult.FAIL;
			} else {
				placeDoor(worldIn, pos, EnumFacing.fromAngle(playerIn.rotationYaw), this.block);
				playerIn.getHeldItem(hand).shrink(1);
				return EnumActionResult.SUCCESS;
			}
		}
	}

	public static void placeDoor(World worldIn, BlockPos pos, EnumFacing facing, Block door) {
		BlockPos blockpos1 = pos.offset(facing.rotateY());
		BlockPos blockpos2 = pos.offset(facing.rotateYCCW());
		int i = (worldIn.getBlockState(blockpos2).isBlockNormalCube() ? 1 : 0) + (worldIn.getBlockState(blockpos2.up()).isBlockNormalCube() ? 1 : 0);
		int j = (worldIn.getBlockState(blockpos1).isBlockNormalCube() ? 1 : 0) + (worldIn.getBlockState(blockpos1.up()).isBlockNormalCube() ? 1 : 0);
		boolean flag = worldIn.getBlockState(blockpos2).getBlock() == door || worldIn.getBlockState(blockpos2.up()).getBlock() == door;
		boolean flag1 = worldIn.getBlockState(blockpos1).getBlock() == door || worldIn.getBlockState(blockpos1.up()).getBlock() == door;
		boolean flag2 = false;

		if (flag && !flag1 || j > i) {
			flag2 = true;
		}

		BlockPos blockpos3 = pos.up();
		IBlockState iblockstate = door.getDefaultState().withProperty(BlockDoor.FACING, facing).withProperty(BlockDoor.HINGE, flag2 ? BlockDoor.EnumHingePosition.RIGHT : BlockDoor.EnumHingePosition.LEFT);
		worldIn.setBlockState(pos, iblockstate.withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.LOWER), 2);
		worldIn.setBlockState(blockpos3, iblockstate.withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER), 2);
		worldIn.notifyNeighborsOfStateChange(pos, door, true);
		worldIn.notifyNeighborsOfStateChange(blockpos3, door, true);
	}
}
