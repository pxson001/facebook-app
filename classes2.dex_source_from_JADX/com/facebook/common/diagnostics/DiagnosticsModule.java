package com.facebook.common.diagnostics;

import com.facebook.debug.pref.DebugLoggingPrefKeys;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.shared.FbSharedPreferences;
import javax.inject.Provider;

@InjectorModule
/* compiled from: video_home_badge_update_subscribe */
public class DiagnosticsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsDebugLogsEnabled
    public static Boolean m2304a(FbSharedPreferences fbSharedPreferences, Provider<Boolean> provider) {
        boolean z = false;
        if (!fbSharedPreferences.mo286a(DebugLoggingPrefKeys.f2809g, false)) {
            z = ((Boolean) provider.get()).booleanValue();
        }
        return Boolean.valueOf(fbSharedPreferences.mo286a(DebugLoggingPrefKeys.f2804b, z));
    }

    @ProviderMethod
    static VMMemoryInfo m2303a() {
        return new VMMemoryInfo(Runtime.getRuntime());
    }
}
