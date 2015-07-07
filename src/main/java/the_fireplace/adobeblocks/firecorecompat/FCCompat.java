package the_fireplace.adobeblocks.firecorecompat;

import the_fireplace.adobeblocks.AdobeBlocks;
import the_fireplace.fireplacecore.api.FCAPI;
import the_fireplace.fireplacecore.math.VersionMath;

public class FCCompat implements IFCCompat {

	@Override
	public void register() {
		FCAPI.registerModToVersionChecker(AdobeBlocks.MODNAME, AdobeBlocks.VERSION, VersionMath.getVersionFor("https://dl.dropboxusercontent.com/s/k6quuter62iuv7z/prerelease.version?dl=0"), VersionMath.getVersionFor("https://dl.dropboxusercontent.com/s/8sdl3cynu7345k4/release.version?dl=0"), AdobeBlocks.downloadURL, AdobeBlocks.MODID);
	}

}
