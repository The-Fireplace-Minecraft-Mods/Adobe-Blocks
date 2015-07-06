package the_fireplace.adobeblocks.items;

import net.minecraft.item.ItemPickaxe;
import the_fireplace.adobeblocks.AdobeBlocks;

public class AdobePickaxe extends ItemPickaxe {

	public AdobePickaxe() {
		super(AdobeBlocks.adobeTool);
		setCreativeTab(AdobeBlocks.TabAdobeBlocks);
		setUnlocalizedName("adobe_pickaxe");
	}

}
