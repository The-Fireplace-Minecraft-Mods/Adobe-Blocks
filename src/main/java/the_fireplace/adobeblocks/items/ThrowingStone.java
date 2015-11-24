package the_fireplace.adobeblocks.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import the_fireplace.adobeblocks.AdobeBlocks;
import the_fireplace.adobeblocks.entity.projectile.EntityThrowingStone;

public class ThrowingStone extends Item {
	public ThrowingStone() {
		setCreativeTab(AdobeBlocks.TabAdobeBlocks);
		setUnlocalizedName("adobe_throwing_stone");
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		if (!playerIn.capabilities.isCreativeMode) {
			--itemStackIn.stackSize;
		}

		worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!worldIn.isRemote) {
			worldIn.spawnEntityInWorld(new EntityThrowingStone(worldIn, playerIn));
		}

		return itemStackIn;
	}
}
