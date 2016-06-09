package the_fireplace.adobeblocks.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
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
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		if (!playerIn.capabilities.isCreativeMode) {
			--itemStackIn.stackSize;
		}

		worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!worldIn.isRemote) {
			EntityThrowingStone stone = new EntityThrowingStone(worldIn, playerIn);
			stone.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
			worldIn.spawnEntityInWorld(stone);
		}

		return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
	}
}
