package com.facebook.http.onion.prefs;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.debug.log.BLog;
import com.facebook.http.onion.OnionRewriteRule;
import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: sticker_asserts */
public class OnionRewriteXConfig extends XConfig {
    public static final XConfigSetting f1777c = new XConfigSetting(f1779e, "rules");
    public static final XConfigSetting f1778d = new XConfigSetting(f1779e, "exemptions");
    private static final XConfigName f1779e = new XConfigName("fbot_onion_rewrite");
    private static final ImmutableSet<XConfigSetting> f1780f = ImmutableSet.of(f1777c, f1778d);

    @Inject
    public OnionRewriteXConfig() {
        super(f1779e, f1780f);
    }

    public static List<OnionRewriteRule> m1941a(String str) {
        try {
            return (List) FbObjectMapper.i().a(str, new 1());
        } catch (Throwable e) {
            BLog.a(OnionRewriteXConfig.class, "Failed to decode onion rules", e);
            return new ArrayList();
        }
    }

    public static List<String> m1942b(String str) {
        try {
            return (List) FbObjectMapper.i().a(str, new 2());
        } catch (Throwable e) {
            BLog.a(OnionRewriteXConfig.class, "Failed to decode onion string array", e);
            return new ArrayList();
        }
    }
}
