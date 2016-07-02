package the_fireplace.adobeblocks.proxy;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import the_fireplace.adobeblocks.entity.projectile.EntityThrowingStone;
import the_fireplace.adobeblocks.renderers.ThrowingStoneFactory;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityThrowingStone.class, new ThrowingStoneFactory());
	}
}
