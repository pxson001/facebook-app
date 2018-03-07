package com.facebook.video.videohome.prefetching;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: sidebar */
public class String_VideoHomePrefetchIntervalMethodAutoProvider extends AbstractProvider<String> {
    public Object get() {
        return VideoHomePrefetchingModule.m3126a((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}
