package the_fireplace.adobeblocks.blocks;

import net.minecraft.block.Block;
import the_fireplace.adobeblocks.AdobeBlocks;

public class AdobeBricks extends Block {

	public AdobeBricks() {
		super(AdobeBlocks.adobe);
		setHarvestLevel("pickaxe", 0);
		setUnlocalizedName("adobe_bricks");
		setCreativeTab(AdobeBlocks.TabAdobeBlocks);
		setHardness(2.0F);
		setResistance(10.0F);
	}
}
