package the_fireplace.adobeblocks.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * @author The_Fireplace
 */
public class ItemAdobeBlock extends ItemBlock {
	public ItemAdobeBlock(Block block){
		super(block);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int damage){
		return damage;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack){
		return super.getUnlocalizedName(stack)+"."+stack.getMetadata();
	}
}
