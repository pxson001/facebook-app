package com.facebook.assetdownload;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: sticky_changed_by_fetch */
public class AssetDownloadModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static AssetDownloadXConfig m1925a() {
        return new AssetDownloadXConfig();
    }
}
