package com.facebook.feed.menu.base;

import com.facebook.feed.annotations.IsNativeNewsFeedPrivacyEditingEnabled;
import com.facebook.feed.annotations.IsNativeNewsfeedSpamReportingEnabled;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.shared.FbSharedPreferences;

@InjectorModule
/* compiled from: group_commerce_sell_options_id */
public class BaseMenuModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsNativeNewsFeedPrivacyEditingEnabled
    public static Boolean m29495a(FbSharedPreferences fbSharedPreferences) {
        return Boolean.valueOf(fbSharedPreferences.mo286a(FeedPrefKeys.f5750n, true));
    }

    @ProviderMethod
    @IsNativeNewsfeedSpamReportingEnabled
    public static Boolean m29496b(FbSharedPreferences fbSharedPreferences) {
        return Boolean.valueOf(fbSharedPreferences.mo286a(FeedPrefKeys.f5746j, true));
    }
}
