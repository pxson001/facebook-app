package com.facebook.debug.viewserver;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

@InjectorModule
/* compiled from: quick_experiment_event */
public class ViewServerModule extends AbstractLibraryModule {
    static final PrefKey f8361a = ((PrefKey) SharedPrefKeys.f989c.m2011a("view_server_enabled"));

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @IsViewServerEnabled
    @ProviderMethod
    public static Boolean m12873a(FbSharedPreferences fbSharedPreferences) {
        if (fbSharedPreferences.mo284a()) {
            return Boolean.valueOf(fbSharedPreferences.mo286a(f8361a, false));
        }
        return Boolean.valueOf(false);
    }
}
