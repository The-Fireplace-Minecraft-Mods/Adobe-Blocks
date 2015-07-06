package the_fireplace.adobeblocks.items;

import net.minecraft.item.ItemSpade;
import the_fireplace.adobeblocks.AdobeBlocks;

public class AdobeShovel extends ItemSpade {

	public AdobeShovel() {
		super(AdobeBlocks.adobeTool);
		setUnlocalizedName("adobe_shovel");
		setCreativeTab(AdobeBlocks.TabAdobeBlocks);
	}

}
