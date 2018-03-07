package com.facebook.selfupdate;

import android.annotation.TargetApi;
import com.facebook.appupdate.AppUpdateInjector;
import com.facebook.appupdate.AppUpdateOperationFactory;
import com.facebook.appupdate.SelfUpdateLauncher;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.shared.FbSharedPreferences;
import javax.inject.Singleton;

@InjectorModule
@TargetApi(9)
/* compiled from: ranking_unavailable */
public class SelfUpdateModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static AppUpdateInjector m12758a(FbandroidAppConfiguration fbandroidAppConfiguration) {
        if (!AppUpdateInjector.m12766b()) {
            AppUpdateInjector.m12764a(fbandroidAppConfiguration);
        }
        return AppUpdateInjector.m12762a();
    }

    @ProviderMethod
    static SelfUpdateLauncher m12759a(AppUpdateInjector appUpdateInjector) {
        return appUpdateInjector.m12780f();
    }

    @ProviderMethod
    public static AppUpdateOperationFactory m12761b(AppUpdateInjector appUpdateInjector) {
        return appUpdateInjector.m12779e();
    }

    @ProviderMethod
    @SelfUpdateLaunchInterval
    public static Long m12760a(FbSharedPreferences fbSharedPreferences) {
        return Long.valueOf(fbSharedPreferences.mo277a(SelfUpdateConstants.f8165F, 21600000));
    }
}
