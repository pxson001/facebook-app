package com.facebook.common.manifest;

import android.content.Context;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: raw_phone_number */
public class ManifestModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    static AppBuildInfoReader m12736a(Context context, ManifestReader manifestReader) {
        return new AppBuildInfoReader(context, manifestReader);
    }

    @ProviderMethod
    @Singleton
    static AppBuildInfo m12735a(AppBuildInfoReader appBuildInfoReader) {
        return appBuildInfoReader.a();
    }

    @ProviderMethod
    static ManifestReader m12737a(Context context) {
        return new ManifestReader(context);
    }
}
