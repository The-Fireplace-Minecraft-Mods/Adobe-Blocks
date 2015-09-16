package the_fireplace.adobeblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import the_fireplace.adobeblocks.AdobeBlocks;

public class AdobeMixtureBlock extends Block {

	public AdobeMixtureBlock() {
		super(Material.clay);
		setUnlocalizedName("adobe_mixture_block");
		setHardness(0.6F);
		setStepSound(soundTypeGravel);
		setCreativeTab(AdobeBlocks.TabAdobeBlocks);
	}

}
