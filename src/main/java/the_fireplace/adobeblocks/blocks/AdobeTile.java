package the_fireplace.adobeblocks.blocks;

import net.minecraft.block.Block;
import the_fireplace.adobeblocks.AdobeBlocks;

public class AdobeTile extends Block {

	public AdobeTile() {
		super(AdobeBlocks.adobe);
		setHarvestLevel("pickaxe", 0);
		setUnlocalizedName("adobe_tile");
		setCreativeTab(AdobeBlocks.TabAdobeBlocks);
		setHardness(2.0F);
		setResistance(10.0F);
		setStepSound(soundTypePiston);
	}

}
