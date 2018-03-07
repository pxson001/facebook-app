package com.facebook.prefs.shared;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import com.facebook.proguard.annotations.DoNotStrip;

@InjectorModule
/* compiled from: data_usage/ */
public class FbSharedPreferencesModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @DoNotStrip
    public static FbSharedPreferences getInstanceForTest_FbSharedPreferences(FbInjector fbInjector) {
        return (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
    }
}
