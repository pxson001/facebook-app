package com.facebook.messaging.neue.shared;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.annotations.IsFetchUserRankedThreadsOnlyEnabled;
import com.facebook.messaging.annotations.IsLogPlatformAppInstallsEnabled;

@InjectorModule
/* compiled from: isPin */
public class NeueSharedModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsFetchUserRankedThreadsOnlyEnabled
    public static Boolean m13099a() {
        return Boolean.valueOf(false);
    }

    @ProviderMethod
    @IsLogPlatformAppInstallsEnabled
    public static Boolean m13100b() {
        return Boolean.valueOf(false);
    }
}
