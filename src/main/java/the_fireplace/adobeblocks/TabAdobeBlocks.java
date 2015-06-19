package the_fireplace.adobeblocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabAdobeBlocks extends CreativeTabs {

	public TabAdobeBlocks(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return AdobeBlocks.adobe_mixture;
	}

}
