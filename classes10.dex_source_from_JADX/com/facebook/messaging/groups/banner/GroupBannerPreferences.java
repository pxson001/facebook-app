package com.facebook.messaging.groups.banner;

import android.net.Uri;
import com.facebook.common.time.Clock;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.ultralight.Inject;

/* compiled from: sideloading_diode_screen_shown */
public class GroupBannerPreferences {
    public final FbSharedPreferences f2432a;
    public final Clock f2433b;

    @Inject
    public GroupBannerPreferences(FbSharedPreferences fbSharedPreferences, Clock clock) {
        this.f2432a = fbSharedPreferences;
        this.f2433b = clock;
    }

    public static PrefKey m2351b(ThreadKey threadKey) {
        return (PrefKey) ((PrefKey) MessagingPrefKeys.P.a(Uri.encode(Long.toString(threadKey.i())))).a("/viewed_group_join_request_banner_timestamp_ms");
    }
}
