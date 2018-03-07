package com.facebook.push.prefs;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.shared.FbSharedPreferences;

@InjectorModule
/* compiled from: first_home_story_param */
public class ChatOnPrefModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsMobileOnlineAvailabilityEnabled
    public static Boolean m32028a(FbSharedPreferences fbSharedPreferences) {
        return Boolean.valueOf(fbSharedPreferences.mo286a(PushPrefKeys.f23602a, true));
    }
}
