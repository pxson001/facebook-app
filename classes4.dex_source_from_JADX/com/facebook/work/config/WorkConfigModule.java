package com.facebook.work.config;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.work.config.community.WorkCommunityId;
import com.facebook.work.config.community.WorkCommunityName;
import com.facebook.work.config.community.WorkCommunitySubdomain;
import javax.annotation.Nullable;

@InjectorModule
/* compiled from: total_tax */
public class WorkConfigModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @WorkCommunityName
    @Nullable
    static String m1198a(FbSharedPreferences fbSharedPreferences) {
        return fbSharedPreferences.a(WorkPrefKeys.f850e, null);
    }

    @ProviderMethod
    @WorkCommunityId
    @Nullable
    public static String m1199b(FbSharedPreferences fbSharedPreferences) {
        return fbSharedPreferences.a(WorkPrefKeys.f849d, null);
    }

    @ProviderMethod
    @WorkCommunitySubdomain
    @Nullable
    static String m1200c(FbSharedPreferences fbSharedPreferences) {
        return fbSharedPreferences.a(WorkPrefKeys.f851f, null);
    }
}
