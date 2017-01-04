package the_fireplace.adobeblocks.entity.tile;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.*;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import the_fireplace.adobeblocks.blocks.AdobeFurnace;
import the_fireplace.adobeblocks.container.ContainerAdobeFurnace;

public class TileEntityAdobeFurnace extends TileEntityLockable implements ITickable, ISidedInventory {
	private static final int[] slotsTop = new int[]{0};
	private static final int[] slotsBottom = new int[]{2, 1};
	private static final int[] slotsSides = new int[]{1};
	/**
	 * The ItemStacks that hold the items currently being used in the furnace
	 */
	private NonNullList<ItemStack> furnaceItemStacks = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
	/**
	 * The number of ticks that the furnace will keep burning
	 */
	private int furnaceBurnTime;
	/**
	 * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
	 */
	private int currentItemBurnTime;
	private int cookTime;
	private int totalCookTime;
	private String furnaceCustomName;

	/**
	 * Returns the number of slots in the inventory.
	 */
	@Override
	public int getSizeInventory() {
		return this.furnaceItemStacks.size();
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemstack : this.furnaceItemStacks)
		{
			if (!itemstack.isEmpty())
			{
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns the stack in slot i
	 */
	@Override
	public ItemStack getStackInSlot(int index) {
		return this.furnaceItemStacks.get(index);
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
	 * new stack.
	 */
	@Override
	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.getAndSplit(this.furnaceItemStacks, index, count);
	}

	/**
	 * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
	 * like when you close a workbench GUI.
	 */
	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.furnaceItemStacks, index);
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
	 */
	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		ItemStack itemstack = this.furnaceItemStacks.get(index);
		boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
		this.furnaceItemStacks.set(index, stack);

		if (stack.getCount() > this.getInventoryStackLimit())
		{
			stack.setCount(this.getInventoryStackLimit());
		}

		if (index == 0 && !flag)
		{
			this.totalCookTime = this.getCookTime(stack);
			this.cookTime = 0;
			this.markDirty();
		}
	}

	/**
	 * Gets the name of this command sender (usually username, but possibly "Rcon")
	 */
	@Override
	public String getName() {
		return this.hasCustomName() ? this.furnaceCustomName : "tile.adobe_furnace.name";
	}

	/**
	 * Returns true if this thing is named
	 */
	@Override
	public boolean hasCustomName() {
		return this.furnaceCustomName != null && !this.furnaceCustomName.isEmpty();
	}

	public void setCustomInventoryName(String p_145951_1_) {
		this.furnaceCustomName = p_145951_1_;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.furnaceItemStacks = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, this.furnaceItemStacks);
		this.furnaceBurnTime = compound.getShort("BurnTime");
		this.cookTime = compound.getShort("CookTime");
		this.totalCookTime = compound.getShort("CookTimeTotal");
		this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks.get(1));

		if (compound.hasKey("CustomName", 8)) {
			this.furnaceCustomName = compound.getString("CustomName");
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setShort("BurnTime", (short) this.furnaceBurnTime);
		compound.setShort("CookTime", (short) this.cookTime);
		compound.setShort("CookTimeTotal", (short) this.totalCookTime);
		ItemStackHelper.saveAllItems(compound, this.furnaceItemStacks);

		if (this.hasCustomName()) {
			compound.setString("CustomName", this.furnaceCustomName);
		}

		return compound;
	}

	/**
	 * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
	 * this more of a set than a get?*
	 */
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	/**
	 * Furnace isBurning
	 */
	public boolean isBurning() {
		return this.furnaceBurnTime > 0;
	}

	/**
	 * Updates the JList with a new model.
	 */
	@Override
	public void update()
	{
		boolean flag = this.isBurning();
		boolean flag1 = false;

		if (this.isBurning())
		{
			--this.furnaceBurnTime;
		}

		if (!this.world.isRemote)
		{
			ItemStack itemstack = (ItemStack)this.furnaceItemStacks.get(1);

			if (this.isBurning() || !itemstack.isEmpty() && !((ItemStack)this.furnaceItemStacks.get(0)).isEmpty())
			{
				if (!this.isBurning() && this.canSmelt())
				{
					this.furnaceBurnTime = getItemBurnTime(itemstack);
					this.currentItemBurnTime = this.furnaceBurnTime;

					if (this.isBurning())
					{
						flag1 = true;

						if (!itemstack.isEmpty())
						{
							Item item = itemstack.getItem();
							itemstack.shrink(1);

							if (itemstack.isEmpty())
							{
								ItemStack item1 = item.getContainerItem(itemstack);
								this.furnaceItemStacks.set(1, item1);
							}
						}
					}
				}

				if (this.isBurning() && this.canSmelt())
				{
					++this.cookTime;

					if (this.cookTime == this.totalCookTime)
					{
						this.cookTime = 0;
						this.totalCookTime = this.getCookTime((ItemStack)this.furnaceItemStacks.get(0));
						this.smeltItem();
						flag1 = true;
					}
				}
				else
				{
					this.cookTime = 0;
				}
			}
			else if (!this.isBurning() && this.cookTime > 0)
			{
				this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
			}

			if (flag != this.isBurning())
			{
				flag1 = true;
				AdobeFurnace.setState(this.isBurning(), this.world, this.pos);
			}
		}

		if (flag1)
		{
			this.markDirty();
		}
	}

	public int getCookTime(ItemStack stack) {
		return 160;
	}

	/**
	 * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
	 */
	private boolean canSmelt() {
		if (this.furnaceItemStacks.get(0).isEmpty())
		{
			return false;
		}
		else
		{
			ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.furnaceItemStacks.get(0));

			if (itemstack.isEmpty())
			{
				return false;
			}
			else
			{
				ItemStack itemstack1 = this.furnaceItemStacks.get(2);
				if (itemstack1.isEmpty()) return true;
				if (!itemstack1.isItemEqual(itemstack)) return false;
				int result = itemstack1.getCount() + itemstack.getCount();
				return result <= getInventoryStackLimit() && result <= itemstack1.getMaxStackSize();
			}
		}
	}

	/**
	 * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
	 */
	public void smeltItem() {
		if (this.canSmelt())
		{
			ItemStack itemstack = (ItemStack)this.furnaceItemStacks.get(0);
			ItemStack itemstack1 = FurnaceRecipes.instance().getSmeltingResult(itemstack);
			ItemStack itemstack2 = (ItemStack)this.furnaceItemStacks.get(2);

			if (itemstack2.isEmpty())
			{
				this.furnaceItemStacks.set(2, itemstack1.copy());
			}
			else if (itemstack2.getItem() == itemstack1.getItem())
			{
				itemstack2.grow(itemstack1.getCount());
			}

			if (itemstack.getItem() == Item.getItemFromBlock(Blocks.SPONGE) && itemstack.getMetadata() == 1 && !((ItemStack)this.furnaceItemStacks.get(1)).isEmpty() && ((ItemStack)this.furnaceItemStacks.get(1)).getItem() == Items.BUCKET)
			{
				this.furnaceItemStacks.set(1, new ItemStack(Items.WATER_BUCKET));
			}

			itemstack.shrink(1);
		}
	}

	/**
	 * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
	 * fuel
	 */
	public static int getItemBurnTime(ItemStack stack) {
		if (stack == null) {
			return 0;
		} else {
			Item item = stack.getItem();

			if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR) {
				Block block = Block.getBlockFromItem(item);

				if (block == Blocks.WOODEN_SLAB) {
					return (int) (150 * 0.8F);
				}

				if (block.getDefaultState().getMaterial() == Material.WOOD) {
					return (int) (300 * 0.8F);
				}

				if (block == Blocks.COAL_BLOCK) {
					return (int) (16000 * 0.8F);
				}
			}

			if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD"))
				return (int) (200 * 0.8F);
			if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD"))
				return (int) (200 * 0.8F);
			if (item instanceof ItemHoe && ((ItemHoe) item).getMaterialName().equals("WOOD")) return (int) (200 * 0.8F);
			if (item == Items.STICK) return (int) (100 * 0.8F);
			if (item == Items.COAL) return (int) (1600 * 0.8F);
			if (item == Items.LAVA_BUCKET) return (int) (20000 * 0.8F);
			if (item == Item.getItemFromBlock(Blocks.SAPLING)) return (int) (100 * 0.8F);
			if (item == Items.BLAZE_ROD) return (int) (2400 * 0.8F);
			return (int) (GameRegistry.getFuelValue(stack) * 0.8F);
		}
	}

	public static boolean isItemFuel(ItemStack p_145954_0_) {
		return getItemBurnTime(p_145954_0_) > 0;
	}

	/**
	 * Do not make give this method the name canInteractWith because it clashes with Container
	 */
	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		return this.world.getTileEntity(this.pos) == this && player.getDistanceSq(this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory(EntityPlayer player) {
	}

	@Override
	public void closeInventory(EntityPlayer player) {
	}

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
	 */
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return index != 2 && (index != 1 || isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack));
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return side == EnumFacing.DOWN ? slotsBottom : side == EnumFacing.UP ? slotsTop : slotsSides;
	}

	/**
	 * Returns true if automation can insert the given item in the given slot from the given side. Args: slot, item,
	 * side
	 */
	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return this.isItemValidForSlot(index, itemStackIn);
	}

	/**
	 * Returns true if automation can extract the given item in the given slot from the given side. Args: slot, item,
	 * side
	 */
	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		if (direction == EnumFacing.DOWN && index == 1) {
			Item item = stack.getItem();

			if (item != Items.WATER_BUCKET && item != Items.BUCKET) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String getGuiID() {
		return "adobeblocks:adobe_furnace";
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerAdobeFurnace(playerInventory, this);
	}

	@Override
	public int getField(int id) {
		switch (id) {
			case 0:
				return this.furnaceBurnTime;
			case 1:
				return this.currentItemBurnTime;
			case 2:
				return this.cookTime;
			case 3:
				return this.totalCookTime;
			default:
				return 0;
		}
	}

	@Override
	public void setField(int id, int value) {
		switch (id) {
			case 0:
				this.furnaceBurnTime = value;
				break;
			case 1:
				this.currentItemBurnTime = value;
				break;
			case 2:
				this.cookTime = value;
				break;
			case 3:
				this.totalCookTime = value;
		}
	}

	@Override
	public int getFieldCount() {
		return 4;
	}

	@Override
	public void clear() {
		this.furnaceItemStacks.clear();
	}

	IItemHandler handlerTop = new SidedInvWrapper(this, EnumFacing.UP);
	IItemHandler handlerBottom = new SidedInvWrapper(this, EnumFacing.DOWN);
	IItemHandler handlerSide = new SidedInvWrapper(this, EnumFacing.WEST);

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		if (facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			if (facing == EnumFacing.DOWN)
				return (T) handlerBottom;
			else if (facing == EnumFacing.UP)
				return (T) handlerTop;
			else
				return (T) handlerSide;
		return super.getCapability(capability, facing);
	}
}
