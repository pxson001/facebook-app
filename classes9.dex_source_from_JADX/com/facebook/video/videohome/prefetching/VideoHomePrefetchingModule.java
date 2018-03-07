package com.facebook.video.videohome.prefetching;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.shared.FbSharedPreferences;

@InjectorModule
/* compiled from: shows a toast when prefetching starts/finishes */
public class VideoHomePrefetchingModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @VideoHomePrefetchInterval
    public static String m3126a(FbSharedPreferences fbSharedPreferences) {
        return fbSharedPreferences.a(VideoHomePrefetchPrefKeys.f3282b, "0");
    }
}
