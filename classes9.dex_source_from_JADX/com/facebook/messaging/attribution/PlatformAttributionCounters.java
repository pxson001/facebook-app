package com.facebook.messaging.attribution;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Inject;

/* compiled from: outgoing_peer_to_peer_payment_requests */
public class PlatformAttributionCounters {
    private static final PrefKey f7842a;
    public static final PrefKey f7843b;
    public static final PrefKey f7844c = ((PrefKey) f7842a.a("stats/"));
    public final FbSharedPreferences f7845d;
    public final Clock f7846e;

    public static PlatformAttributionCounters m8075a(InjectorLike injectorLike) {
        return new PlatformAttributionCounters((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    static {
        PrefKey prefKey = (PrefKey) MessagingPrefKeys.b.a("platform_apps/");
        f7842a = prefKey;
        f7843b = (PrefKey) prefKey.a("install_launch_timestamp");
    }

    public static PrefKey m8076b(String str) {
        return (PrefKey) ((PrefKey) ((PrefKey) f7844c.a(str)).a("/install_launch/")).a("count");
    }

    @Inject
    public PlatformAttributionCounters(FbSharedPreferences fbSharedPreferences, Clock clock) {
        this.f7845d = fbSharedPreferences;
        this.f7846e = clock;
    }
}
