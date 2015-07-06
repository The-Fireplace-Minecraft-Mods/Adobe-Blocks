package the_fireplace.adobeblocks.items;

import net.minecraft.item.ItemHoe;
import the_fireplace.adobeblocks.AdobeBlocks;

public class AdobeHoe extends ItemHoe {

	public AdobeHoe() {
		super(AdobeBlocks.adobeTool);
		setUnlocalizedName("adobe_hoe");
		setCreativeTab(AdobeBlocks.TabAdobeBlocks);
	}

}
