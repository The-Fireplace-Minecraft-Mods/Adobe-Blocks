package the_fireplace.adobeblocks.items;

import net.minecraft.item.ItemAxe;
import the_fireplace.adobeblocks.AdobeBlocks;

public class AdobeAxe extends ItemAxe {

	public AdobeAxe() {
		super(AdobeBlocks.adobeTool, 8.0F, -3.2F);
		setUnlocalizedName("adobe_axe");
		setCreativeTab(AdobeBlocks.TabAdobeBlocks);
	}
}
