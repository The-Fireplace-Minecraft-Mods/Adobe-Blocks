package the_fireplace.adobeblocks.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityThrowingStone extends EntityThrowable {
	public EntityThrowingStone(World worldIn) {
		super(worldIn);
	}

	public EntityThrowingStone(World worldIn, EntityLivingBase entity) {
		super(worldIn, entity);
	}

	public EntityThrowingStone(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	@Override
	protected void onImpact(RayTraceResult mop) {
		if (mop.entityHit != null) {
			byte damage = 2;

			if (mop.entityHit instanceof EntitySkeleton) {
				damage = 3;
			}

			mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);
		}

		if (!this.worldObj.isRemote) {
			this.setDead();
		}
	}
}
