package the_fireplace.adobeblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import the_fireplace.adobeblocks.AdobeBlocks;

import java.util.Calendar;

/**
 * @author The_Fireplace
 */
public class AdobeBlock extends Block {

	public static final PropertyInteger STATE = PropertyInteger.create("state", 0, 14);

	public AdobeBlock() {
		super(Material.WOOD);
		setDefaultState(this.blockState.getBaseState().withProperty(STATE, 0));
		setUnlocalizedName("adobe_block");
		setHardness(2.0F);
		setResistance(10.0F);
		if(canEasterEgg())
			setCreativeTab(AdobeBlocks.TabAdobeBlocks);
	}
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.blockState.getBaseState().withProperty(STATE, meta);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(STATE);
	}
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, STATE);
	}
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, NonNullList<ItemStack> list){
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
		list.add(new ItemStack(item, 1, 2));
		list.add(new ItemStack(item, 1, 3));
		list.add(new ItemStack(item, 1, 4));
		list.add(new ItemStack(item, 1, 5));
		list.add(new ItemStack(item, 1, 6));
		list.add(new ItemStack(item, 1, 7));
		list.add(new ItemStack(item, 1, 8));
		list.add(new ItemStack(item, 1, 9));
		list.add(new ItemStack(item, 1, 10));
		list.add(new ItemStack(item, 1, 11));
		list.add(new ItemStack(item, 1, 12));
		list.add(new ItemStack(item, 1, 13));
		list.add(new ItemStack(item, 1, 14));
	}

	private boolean canEasterEgg(){
		return Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == 1 && Calendar.getInstance().get(Calendar.MONTH) == Calendar.APRIL;
	}
}
