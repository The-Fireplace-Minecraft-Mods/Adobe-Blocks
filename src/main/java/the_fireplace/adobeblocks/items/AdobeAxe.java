package the_fireplace.adobeblocks.items;

import net.minecraft.item.ItemAxe;
import the_fireplace.adobeblocks.AdobeBlocks;

public class AdobeAxe extends ItemAxe {

	public AdobeAxe() {
		super(AdobeBlocks.adobeTool);
		setUnlocalizedName("adobe_axe");
		setCreativeTab(AdobeBlocks.TabAdobeBlocks);
	}
}
