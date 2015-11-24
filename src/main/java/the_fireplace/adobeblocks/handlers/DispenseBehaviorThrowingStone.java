package the_fireplace.adobeblocks.handlers;

import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;
import the_fireplace.adobeblocks.entity.projectile.EntityThrowingStone;

/**
 * @author The_Fireplace
 */
public class DispenseBehaviorThrowingStone extends BehaviorProjectileDispense {
		@Override
		protected IProjectile getProjectileEntity(World worldIn, IPosition position){
				return new EntityThrowingStone(worldIn, position.getX(), position.getY(), position.getZ());
			}
	}
