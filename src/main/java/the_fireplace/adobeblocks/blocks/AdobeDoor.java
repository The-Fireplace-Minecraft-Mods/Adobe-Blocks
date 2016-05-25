package the_fireplace.adobeblocks.blocks;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import the_fireplace.adobeblocks.AdobeBlocks;

import java.util.Random;

public class AdobeDoor extends BlockDoor {

	public AdobeDoor() {
		super(AdobeBlocks.adobe);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(OPEN, false).withProperty(HINGE, BlockDoor.EnumHingePosition.LEFT).withProperty(POWERED, false).withProperty(HALF, BlockDoor.EnumDoorHalf.LOWER));
		this.setUnlocalizedName("adobe_door");
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(AdobeBlocks.adobe_door);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? null : AdobeBlocks.adobe_door;
	}
}
