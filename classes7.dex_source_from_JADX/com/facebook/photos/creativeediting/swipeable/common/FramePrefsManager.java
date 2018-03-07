package com.facebook.photos.creativeediting.swipeable.common;

import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.ultralight.Inject;

/* compiled from: mHeight */
public class FramePrefsManager {
    private static final PrefKey f9746b = ((PrefKey) ((PrefKey) SharedPrefKeys.a.a("frame_prefs_manager/")).a("last_frame_pack_nuxed_start_time"));
    public static final PrefKey f9747c = ((PrefKey) ((PrefKey) SharedPrefKeys.a.a("frame_prefs_manager/")).a("last_viewed_time"));
    @Inject
    public FbSharedPreferences f9748a;

    public static FramePrefsManager m11676b(InjectorLike injectorLike) {
        FramePrefsManager framePrefsManager = new FramePrefsManager();
        framePrefsManager.f9748a = (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike);
        return framePrefsManager;
    }

    public final void m11678a(long j) {
        this.f9748a.edit().a(f9746b, j).commit();
    }

    public final long m11677a() {
        return this.f9748a.a(f9746b, 0);
    }

    public final void m11679b(long j) {
        this.f9748a.edit().a(f9747c, j).commit();
    }

    public static FramePrefsManager m11675a(InjectorLike injectorLike) {
        return m11676b(injectorLike);
    }
}
