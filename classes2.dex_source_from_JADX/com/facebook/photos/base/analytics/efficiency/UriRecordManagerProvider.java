package com.facebook.photos.base.analytics.efficiency;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: onavo_android_app_bookmark_gk */
public class UriRecordManagerProvider extends AbstractAssistedProvider<UriRecordManager> {
    public final UriRecordManager m16408a(String str) {
        return new UriRecordManager(FbSharedPreferencesImpl.m1826a((InjectorLike) this), str);
    }
}
