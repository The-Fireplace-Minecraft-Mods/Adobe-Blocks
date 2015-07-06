package the_fireplace.adobeblocks.blocks;

import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;
import the_fireplace.adobeblocks.AdobeBlocks;

public class AdobeStairs extends BlockStairs {

	public AdobeStairs() {
		super(AdobeBlocks.adobe_bricks.getDefaultState());
		this.setUnlocalizedName("adobe_stairs");
		this.useNeighborBrightness = true;
	}
	@Override
	public CreativeTabs getCreativeTabToDisplayOn(){
		return AdobeBlocks.TabAdobeBlocks;
	}
}
