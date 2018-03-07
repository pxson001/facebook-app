package com.facebook.config.versioninfo.module;

import android.content.pm.PackageInfo;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.DefaultAppVersionInfo;
import com.facebook.config.versioninfo.VersionStringComparator;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: user_values/name/* */
public class VersionInfoModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static AppVersionInfo m2705a(PackageInfo packageInfo) {
        return new DefaultAppVersionInfo(packageInfo);
    }

    @ProviderMethod
    static VersionStringComparator m2706a() {
        return new VersionStringComparator();
    }
}
