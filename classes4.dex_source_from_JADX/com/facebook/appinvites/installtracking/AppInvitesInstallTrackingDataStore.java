package com.facebook.appinvites.installtracking;

import com.facebook.appinvites.data.AppInvitePrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: messaging_geo */
public class AppInvitesInstallTrackingDataStore {
    public final FbSharedPreferences f8087a;

    @Inject
    public AppInvitesInstallTrackingDataStore(FbSharedPreferences fbSharedPreferences) {
        this.f8087a = fbSharedPreferences;
    }

    public final Set<AppInvitesTrackedApp> m8371a() {
        Set<PrefKey> d = this.f8087a.d(AppInvitePrefKeys.f9815b);
        Set<String> a = Sets.a();
        for (PrefKey b : d) {
            a.add(b.b(AppInvitePrefKeys.f9815b).split("/")[0]);
        }
        Set<AppInvitesTrackedApp> a2 = Sets.a();
        for (String b2 : a) {
            a2.add(m8372b(b2));
        }
        return a2;
    }

    @Nullable
    public final AppInvitesTrackedApp m8372b(String str) {
        PrefKey prefKey = (PrefKey) ((PrefKey) AppInvitePrefKeys.f9815b.a(str)).a("/");
        if (this.f8087a.a((PrefKey) prefKey.a("invite_id"))) {
            return new AppInvitesTrackedApp(this.f8087a.a((PrefKey) prefKey.a("invite_id"), null), str, this.f8087a.a((PrefKey) prefKey.a("timestamp"), 0));
        }
        return null;
    }
}
