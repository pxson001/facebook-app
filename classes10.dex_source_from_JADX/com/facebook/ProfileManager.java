package com.facebook;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import org.json.JSONObject;

/* compiled from: event/{%s}/invite */
public final class ProfileManager {
    private static volatile ProfileManager f13840a;
    public final LocalBroadcastManager f13841b;
    private final ProfileCache f13842c;
    public Profile f13843d;

    private ProfileManager(LocalBroadcastManager localBroadcastManager, ProfileCache profileCache) {
        Validate.m25366a((Object) localBroadcastManager, "localBroadcastManager");
        Validate.m25366a((Object) profileCache, "profileCache");
        this.f13841b = localBroadcastManager;
        this.f13842c = profileCache;
    }

    public static ProfileManager m14138a() {
        if (f13840a == null) {
            synchronized (ProfileManager.class) {
                if (f13840a == null) {
                    f13840a = new ProfileManager(LocalBroadcastManager.a(FacebookSdk.m14051f()), new ProfileCache());
                }
            }
        }
        return f13840a;
    }

    final boolean m14141c() {
        Profile a = this.f13842c.m14137a();
        if (a == null) {
            return false;
        }
        m14139a(a, false);
        return true;
    }

    final void m14140a(Profile profile) {
        m14139a(profile, true);
    }

    private void m14139a(Profile profile, boolean z) {
        Object obj = this.f13843d;
        this.f13843d = profile;
        if (z) {
            if (profile != null) {
                ProfileCache profileCache = this.f13842c;
                Validate.m25366a((Object) profile, "profile");
                JSONObject c = profile.m14136c();
                if (c != null) {
                    profileCache.f13839a.edit().putString("com.facebook.ProfileManager.CachedProfile", c.toString()).apply();
                }
            } else {
                this.f13842c.f13839a.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
            }
        }
        if (!Utility.m25344a(obj, (Object) profile)) {
            Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
            intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", obj);
            intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", profile);
            this.f13841b.a(intent);
        }
    }
}
