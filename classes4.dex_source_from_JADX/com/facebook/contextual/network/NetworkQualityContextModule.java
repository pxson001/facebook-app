package com.facebook.contextual.network;

import com.facebook.common.network.ServerConnectionQualityManager;
import com.facebook.http.observer.DownloadBandwidthManager;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: stale_email */
public class NetworkQualityContextModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static NetworkQualityContextsProvider m1969a(DownloadBandwidthManager downloadBandwidthManager, ServerConnectionQualityManager serverConnectionQualityManager) {
        return new NetworkQualityContextsProvider(downloadBandwidthManager, serverConnectionQualityManager);
    }
}
