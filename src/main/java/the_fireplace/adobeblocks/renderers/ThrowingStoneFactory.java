package the_fireplace.adobeblocks.renderers;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import the_fireplace.adobeblocks.entity.projectile.EntityThrowingStone;

/**
 * @author The_Fireplace
 */
public class ThrowingStoneFactory implements IRenderFactory<EntityThrowingStone> {
	@Override
	public Render<? super EntityThrowingStone> createRenderFor(RenderManager manager) {
		return new RenderThrowingStone(manager);
	}
}
