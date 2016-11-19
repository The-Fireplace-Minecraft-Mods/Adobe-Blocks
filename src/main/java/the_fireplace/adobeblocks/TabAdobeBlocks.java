package the_fireplace.adobeblocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabAdobeBlocks extends CreativeTabs {
	/** Texture to use. */
	private String theTexture = "adobe_items.png";
	private String theTexture_ = "adobe_items_alt.png";

	public TabAdobeBlocks(String label) {
		super(label);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(AdobeBlocks.adobe_mixture);
	}

	@Override
	public String getBackgroundImageName()
	{
		return this.isTabInFirstRow() ? this.theTexture : this.theTexture_;
	}
}
