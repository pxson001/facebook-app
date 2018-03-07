package com.facebook.feed.hscroll;

import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;

/* compiled from: onError MEDIA_ERROR_SERVER_DIED */
public class PaginatedHScrollFeedUnitCursorHelper {
    private final FbSharedPreferences f6225a;
    private final PrefKey f6226b;
    private String f6227c = null;

    public PaginatedHScrollFeedUnitCursorHelper(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
        this.f6225a = fbSharedPreferences;
        this.f6226b = prefKey;
    }

    public final synchronized void m6680a(String str) {
        if (str != null) {
            this.f6227c = str;
            this.f6225a.edit().a(this.f6226b, str).commit();
        }
    }
}
