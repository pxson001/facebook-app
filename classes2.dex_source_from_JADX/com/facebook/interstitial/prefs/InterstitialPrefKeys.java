package com.facebook.interstitial.prefs;

import android.net.Uri;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: recent_ping_recv_count */
public class InterstitialPrefKeys {
    public static final PrefKey f7892a;
    public static final PrefKey f7893b;
    public static final PrefKey f7894c = ((PrefKey) f7892a.m2011a("triToId/"));
    public static final PrefKey f7895d = ((PrefKey) SharedPrefKeys.f987a.m2011a("last_impression/"));
    public static final PrefKey f7896e = ((PrefKey) f7892a.m2011a("AllTriggers"));
    public static final PrefKey f7897f = ((PrefKey) f7892a.m2011a("data_restored"));
    public static final PrefKey f7898g = ((PrefKey) SharedPrefKeys.f987a.m2011a("version/"));
    public static final PrefKey f7899h = ((PrefKey) SharedPrefKeys.f987a.m2011a("app_version/"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("interstitial/");
        f7892a = prefKey;
        f7893b = (PrefKey) prefKey.m2011a("data/");
    }

    public static PrefKey m12488a(String str) {
        return (PrefKey) f7893b.m2011a(Uri.encode(str));
    }

    public static PrefKey m12487a(InterstitialTrigger interstitialTrigger) {
        return (PrefKey) f7894c.m2011a(Uri.encode(interstitialTrigger.toString()));
    }

    public static PrefKey m12489b(String str) {
        return (PrefKey) f7895d.m2011a(Uri.encode(str));
    }
}
