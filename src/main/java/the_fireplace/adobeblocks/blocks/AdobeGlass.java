package the_fireplace.adobeblocks.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import the_fireplace.adobeblocks.AdobeBlocks;

public class AdobeGlass extends Block {

	public AdobeGlass() {
		super(AdobeBlocks.adobe);
		setUnlocalizedName("adobe_glass");
		setHardness(0.3F);
		setStepSound(soundTypeGlass);
	}
	@Override
	public int quantityDropped(Random random)
	{
		return 0;
	}
	@SideOnly(Side.CLIENT)
	@Override
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}
	@Override
	public boolean isFullCube()
	{
		return false;
	}
	@Override
	protected boolean canSilkHarvest()
	{
		return true;
	}
}
