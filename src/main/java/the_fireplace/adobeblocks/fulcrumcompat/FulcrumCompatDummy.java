package the_fireplace.adobeblocks.fulcrumcompat;

public class FulcrumCompatDummy implements IFulcrumCompat {

	@Override
	public void register() {
		System.out.println("Unable to check for updates due to missing Fireplace Core");
	}
}
