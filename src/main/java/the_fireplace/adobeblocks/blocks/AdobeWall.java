package the_fireplace.adobeblocks.blocks;

import net.minecraft.block.BlockWall;
import the_fireplace.adobeblocks.AdobeBlocks;

public class AdobeWall extends BlockWall {

	public AdobeWall() {
		super(AdobeBlocks.adobe_bricks);
		this.setDefaultState(this.blockState.getBaseState().withProperty(UP, false).withProperty(NORTH, false).withProperty(EAST, false).withProperty(SOUTH, false).withProperty(WEST, false));
		this.setHardness(2.0F);
		this.setResistance(10.0F / 3.0F);
		this.setCreativeTab(AdobeBlocks.TabAdobeBlocks);
		setUnlocalizedName("adobe_wall");
	}
}
