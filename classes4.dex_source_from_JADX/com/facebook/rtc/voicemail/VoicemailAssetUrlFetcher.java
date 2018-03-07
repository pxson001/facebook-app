package com.facebook.rtc.voicemail;

import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.xconfig.core.XConfigReader;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: local_contact_id=? */
public class VoicemailAssetUrlFetcher {
    public final FbSharedPreferences f9206a;
    public final Clock f9207b;
    private final XConfigReader f9208c;

    @Inject
    public VoicemailAssetUrlFetcher(FbSharedPreferences fbSharedPreferences, Clock clock, XConfigReader xConfigReader) {
        this.f9206a = fbSharedPreferences;
        this.f9207b = clock;
        this.f9208c = xConfigReader;
    }

    @Nullable
    public final String m9551a() {
        Object a = this.f9208c.a(RtcVoicemailConfig.f1881d, null);
        String str = null;
        if (!StringUtil.a(a)) {
            String h = m9550h();
            for (String split : a.split(";")) {
                String[] split2 = split.split("=");
                if (h.equals(split2[0].trim())) {
                    str = split2[1].trim();
                    break;
                }
            }
        }
        return str;
    }

    @Nullable
    public final String m9552b() {
        return this.f9206a.a(m9548f(), null);
    }

    public static PrefKey m9548f() {
        return (PrefKey) SharedPrefKeys.c.a("rtc_voicemail_asset_url_" + m9550h());
    }

    public static PrefKey m9549g() {
        return (PrefKey) SharedPrefKeys.c.a("rtc_voicemail_asset_url_download_time_" + m9550h());
    }

    public static String m9550h() {
        return Locale.getDefault().getLanguage();
    }
}
