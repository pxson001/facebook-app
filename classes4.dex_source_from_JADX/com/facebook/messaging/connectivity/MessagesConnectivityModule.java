package com.facebook.messaging.connectivity;

import android.annotation.SuppressLint;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.connectivity.annotations.ConnectionStatusForBusinessActivity;
import com.facebook.messaging.connectivity.annotations.ConnectionStatusForMessengerHomeFragment;
import com.facebook.messaging.connectivity.annotations.ConnectionStatusForThreadViewFragment;
import com.facebook.messaging.connectivity.annotations.IsConnStatusBannerEnabled;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: mStateSync */
public class MessagesConnectivityModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsConnStatusBannerEnabled
    public static Boolean m8808a(FbAppType fbAppType) {
        return Boolean.valueOf(fbAppType.j == Product.MESSENGER);
    }

    @ProviderMethod
    @SuppressLint({"ProviderUsage"})
    @ConnectionStatusForMessengerHomeFragment
    static ConnectionStatusNotification m8807a(ConnectionStatusNotificationProvider connectionStatusNotificationProvider) {
        return connectionStatusNotificationProvider.a(ConnectionStatusSurface.MESSENGER_HOME_FRAGMENT);
    }

    @ProviderMethod
    @ConnectionStatusForThreadViewFragment
    @SuppressLint({"ProviderUsage"})
    public static ConnectionStatusNotification m8809b(ConnectionStatusNotificationProvider connectionStatusNotificationProvider) {
        return connectionStatusNotificationProvider.a(ConnectionStatusSurface.THREAD_VIEW);
    }

    @ProviderMethod
    @SuppressLint({"ProviderUsage"})
    @ConnectionStatusForBusinessActivity
    public static ConnectionStatusNotification m8810c(ConnectionStatusNotificationProvider connectionStatusNotificationProvider) {
        return connectionStatusNotificationProvider.a(ConnectionStatusSurface.BUSINESS_ACTIVITY);
    }

    @ProviderMethod
    @Singleton
    static ConnectionStatusMonitor m8806a(SimplifiedConnectivityBannerExperimentController simplifiedConnectivityBannerExperimentController) {
        return simplifiedConnectivityBannerExperimentController.f8492e;
    }
}
