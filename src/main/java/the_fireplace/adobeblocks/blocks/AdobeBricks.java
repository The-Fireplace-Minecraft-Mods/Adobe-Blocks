package the_fireplace.adobeblocks.blocks;

import the_fireplace.adobeblocks.AdobeBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class AdobeBricks extends Block {

	public AdobeBricks() {
		super(AdobeBlocks.adobe);
		setHarvestLevel("pickaxe", 0);
		setUnlocalizedName("adobe_bricks");
		setCreativeTab(AdobeBlocks.TabAdobeBlocks);
	}

}
