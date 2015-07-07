package the_fireplace.adobeblocks.firecorecompat;

public class FCCompatDummy implements IFCCompat {

	@Override
	public void register() {
		System.out.println("Unable to check for updates due to missing Fireplace Core");
	}
}
