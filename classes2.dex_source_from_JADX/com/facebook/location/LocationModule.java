package com.facebook.location;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.executors.HandlerListeningExecutorServiceImpl;
import com.facebook.common.executors.ThreadPriority;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.util.TriState;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.iorg.common.zero.interfaces.ZeroFeatureVisibilityHelper;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import javax.inject.Provider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: mapped */
public class LocationModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static FbLocationManager m21685a(Provider<TriState> provider, GooglePlayServicesUtil googlePlayServicesUtil, ZeroFeatureVisibilityHelper zeroFeatureVisibilityHelper, Provider<GooglePlayFbLocationManager> provider2, Provider<AndroidPlatformFbLocationManager> provider3, Provider<MockStaticMpkFbLocationManager> provider4, PerfTestConfig perfTestConfig, FbSharedPreferences fbSharedPreferences, FbErrorReporter fbErrorReporter) {
        return FbLocationManagerProvider.m24991a(provider, googlePlayServicesUtil, zeroFeatureVisibilityHelper, provider2, provider3, provider4, perfTestConfig, fbSharedPreferences, fbErrorReporter);
    }

    @ProviderMethod
    static FbLocationContinuousListener m21686a(Provider<TriState> provider, GooglePlayServicesUtil googlePlayServicesUtil, ZeroFeatureVisibilityHelper zeroFeatureVisibilityHelper, Provider<GooglePlayFbLocationContinuousListener> provider2, Provider<AndroidPlatformFbLocationContinuousListener> provider3, Provider<MockStaticMpkFbLocationContinuousListener> provider4, PerfTestConfig perfTestConfig, FbErrorReporter fbErrorReporter) {
        return FbLocationContinuousListenerProvider.a(provider, googlePlayServicesUtil, zeroFeatureVisibilityHelper, provider2, provider3, provider4, perfTestConfig, fbErrorReporter);
    }

    @ProviderMethod
    @SuppressLint({"BadMethodUse-java.lang.Thread.start"})
    @Singleton
    @ForLocationNonUiThread
    static Handler m21684a(FbHandlerThreadFactory fbHandlerThreadFactory) {
        HandlerThread a = fbHandlerThreadFactory.m3580a("fglNonUiHandler", ThreadPriority.BACKGROUND);
        a.start();
        return new Handler(a.getLooper());
    }

    @ProviderMethod
    @SuppressLint({"BadMethodUse-java.lang.Thread.start"})
    @Singleton
    @ForLocationNonUiThread
    static ListeningScheduledExecutorService m21687a(Handler handler) {
        return new HandlerListeningExecutorServiceImpl(handler);
    }
}
