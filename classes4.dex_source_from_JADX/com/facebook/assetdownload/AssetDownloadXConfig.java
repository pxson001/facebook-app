package com.facebook.assetdownload;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;

/* compiled from: stickers_db_properties */
public class AssetDownloadXConfig extends XConfig {
    public static final XConfigName f1666c = new XConfigName("android_assetdownload");
    public static final XConfigSetting f1667d = new XConfigSetting(f1666c, "TRIGGER_INTERVAL_MS");
    public static final XConfigSetting f1668e = new XConfigSetting(f1666c, "MAX_NUMBER_OF_FAILURES");
    public static final XConfigSetting f1669f = new XConfigSetting(f1666c, "MAX_DATA_WIFI_BYTES");
    public static final XConfigSetting f1670g = new XConfigSetting(f1666c, "MAX_DATA_OTHER_BYTES");
    public static final XConfigSetting f1671h = new XConfigSetting(f1666c, "MAX_TIME_PER_SESSION_MS");
    public static final XConfigSetting f1672i = new XConfigSetting(f1666c, "MAX_TIME_TO_WAIT_FOR_WIFI");
    private static final ImmutableSet<XConfigSetting> f1673j = ImmutableSet.of(f1667d, f1668e, f1669f, f1670g, f1671h, f1672i, new XConfigSetting[0]);

    public AssetDownloadXConfig() {
        super(f1666c, f1673j);
    }
}
