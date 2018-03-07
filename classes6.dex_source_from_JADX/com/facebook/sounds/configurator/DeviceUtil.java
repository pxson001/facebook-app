package com.facebook.sounds.configurator;

import android.os.Build;

/* compiled from: overlayShadowDrawingEnabled */
public abstract class DeviceUtil {
    public static DeviceProfile m23653a() {
        String str = Build.MODEL;
        if (str == null) {
            str = "";
        }
        if (str.matches(".*GT-I9305.*") || str.matches(".*GT-I9300T.*") || str.matches(".*SGH-T999.*") || str.matches(".*SGH-I747.*") || str.matches(".*SCH-R530.*") || str.matches(".*SCH-I535.*") || str.matches(".*SCH-R530U.*") || str.matches(".*SCH-R530M.*") || str.matches(".*SPH-L710.*") || str.matches(".*SHV-E210S.*") || str.matches(".*SHV-E210K.*")) {
            return DeviceProfile.SAMSUNG_S3;
        }
        if (str.matches(".*SCH-I545.*") || str.matches(".*SGH-I337.*") || str.matches(".*SGH-M919.*") || str.matches(".*SPH-L720.*") || str.matches(".*GT-I9505.*") || str.matches(".*SGH-I537.*") || str.matches(".*GT-I9505G.*") || str.matches(".*GT-I9500.*") || str.matches(".*SGH-I337M.*")) {
            return DeviceProfile.SAMSUNG_S4;
        }
        if (str.matches(".*SM-G900.*")) {
            return DeviceProfile.SAMSUNG_S5;
        }
        if (str.matches(".*HTC One.*") || str.matches(".*HTCONE.*") || str.matches(".*HTC6500LVW.*") || str.matches(".*HTC_PN071.*")) {
            return DeviceProfile.HTC_ONE;
        }
        if (str.matches(".*XT102.*")) {
            return DeviceProfile.MOTO_E;
        }
        if (str.matches(".*LG-D82.*")) {
            return DeviceProfile.NEXUS_5;
        }
        return DeviceProfile.DEFAULT;
    }
}
