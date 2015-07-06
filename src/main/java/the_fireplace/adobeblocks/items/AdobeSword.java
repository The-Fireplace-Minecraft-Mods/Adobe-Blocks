package the_fireplace.adobeblocks.items;

import net.minecraft.item.ItemSword;
import the_fireplace.adobeblocks.AdobeBlocks;

public class AdobeSword extends ItemSword {

	public AdobeSword() {
		super(AdobeBlocks.adobeTool);
		setUnlocalizedName("adobe_sword");
		setCreativeTab(AdobeBlocks.TabAdobeBlocks);
	}

}
