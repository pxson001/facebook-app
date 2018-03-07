package com.facebook.http.onion.prefs;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.debug.log.BLog;
import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: stickerSearchParams */
public class OrbotSignaturesXConfig extends XConfig {
    public static final XConfigSetting f1781c;
    private static final XConfigName f1782d = new XConfigName("fbot_orbot_signatures");
    private static final ImmutableSet<XConfigSetting> f1783e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1782d, "valid_signatures");
        f1781c = xConfigSetting;
        f1783e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public OrbotSignaturesXConfig() {
        super(f1782d, f1783e);
    }

    public static List<String> m1943a(String str) {
        try {
            return (List) FbObjectMapper.i().a(str, new 1());
        } catch (Throwable e) {
            BLog.a(OrbotSignaturesXConfig.class, "Failed to decode orbot signatures", e);
            return new ArrayList();
        }
    }
}
