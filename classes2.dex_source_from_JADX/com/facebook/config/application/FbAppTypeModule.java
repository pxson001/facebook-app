package com.facebook.config.application;

import com.facebook.common.build.BuildConstants;
import com.facebook.common.build.IsInternalBuild;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.build.SignatureType;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: wirehog_user */
public class FbAppTypeModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
        binderImpl.m1344a(PlatformAppConfig.class).mo200b(FbAppType.class);
        binderImpl.m1348b(FbAppType.class).mo198a(new FbAppTypeMethodAutoProvider());
    }

    @ProviderMethod
    static FbAppType m1448c() {
        FbAppType fbAppType = FbAppType.a;
        if (fbAppType != null) {
            return fbAppType;
        }
        throw new IllegalStateException("Application did not provide its own FbAppType");
    }

    @ProviderMethod
    public static IntendedAudience m1449c(FbAppType fbAppType) {
        return fbAppType.i;
    }

    @ProviderMethod
    static Product m1444a(FbAppType fbAppType) {
        return fbAppType.j;
    }

    @ProviderMethod
    static SignatureType m1446b(FbAppType fbAppType) {
        return fbAppType.k;
    }

    @ProviderMethod
    @Singleton
    @IsInternalBuild
    static Boolean m1445a() {
        return Boolean.valueOf(BuildConstants.i);
    }

    @ProviderMethod
    @Singleton
    @IsWorkBuild
    static Boolean m1447b() {
        return Boolean.valueOf(BuildConstants.j);
    }
}
