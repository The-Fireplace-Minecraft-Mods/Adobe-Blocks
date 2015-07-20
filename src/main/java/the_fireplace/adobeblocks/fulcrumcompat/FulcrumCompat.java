package the_fireplace.adobeblocks.fulcrumcompat;

import the_fireplace.adobeblocks.AdobeBlocks;
import the_fireplace.fulcrum.api.API;
import the_fireplace.fulcrum.math.VersionMath;

public class FulcrumCompat implements IFulcrumCompat {

	@Override
	public void register() {
		API.registerModToVersionChecker(AdobeBlocks.MODNAME, AdobeBlocks.VERSION, VersionMath.getVersionFor("https://dl.dropboxusercontent.com/s/k6quuter62iuv7z/prerelease.version?dl=0"), VersionMath.getVersionFor("https://dl.dropboxusercontent.com/s/8sdl3cynu7345k4/release.version?dl=0"), AdobeBlocks.downloadURL, AdobeBlocks.MODID);
	}

}
