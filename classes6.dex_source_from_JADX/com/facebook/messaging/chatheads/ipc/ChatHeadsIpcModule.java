package com.facebook.messaging.chatheads.ipc;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.chatheads.ipc.annotations.IsChatHeadDebugShowInsideAppEnabled;
import com.facebook.prefs.shared.FbSharedPreferences;

@InjectorModule
/* compiled from: video_home_search_keyword_only */
public class ChatHeadsIpcModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsChatHeadDebugShowInsideAppEnabled
    public static Boolean m757a(FbSharedPreferences fbSharedPreferences) {
        return Boolean.valueOf(fbSharedPreferences.a(ChatHeadsIpcPrefKeys.f745b, false));
    }
}
