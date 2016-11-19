package the_fireplace.adobeblocks.blocks;

import net.minecraft.block.BlockWall;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import the_fireplace.adobeblocks.AdobeBlocks;

public class AdobeWall extends BlockWall {

	public AdobeWall() {
		super(AdobeBlocks.adobe_bricks);
		this.setDefaultState(this.blockState.getBaseState().withProperty(UP, false).withProperty(NORTH, false).withProperty(EAST, false).withProperty(SOUTH, false).withProperty(WEST, false));
		this.setHardness(2.0F);
		this.setResistance(10.0F / 3.0F);
		this.setCreativeTab(AdobeBlocks.TabAdobeBlocks);
		setUnlocalizedName("adobe_wall");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list)
	{
		list.add(new ItemStack(itemIn));
	}
}
