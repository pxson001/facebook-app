package com.facebook.location;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.util.TriState;
import com.facebook.iorg.common.zero.interfaces.ZeroFeatureVisibilityHelper;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import javax.inject.Provider;

/* compiled from: launched_from_tab */
public class FbLocationManagerProvider {

    /* compiled from: launched_from_tab */
    /* synthetic */ class C07151 {
        static final /* synthetic */ int[] f17766a = new int[FbLocationImplementation.values().length];

        static {
            try {
                f17766a[FbLocationImplementation.ANDROID_PLATFORM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17766a[FbLocationImplementation.GOOGLE_PLAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17766a[FbLocationImplementation.MOCK_MPK_STATIC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static FbLocationManager m24991a(Provider<TriState> provider, GooglePlayServicesUtil googlePlayServicesUtil, ZeroFeatureVisibilityHelper zeroFeatureVisibilityHelper, Provider<GooglePlayFbLocationManager> provider2, Provider<AndroidPlatformFbLocationManager> provider3, Provider<MockStaticMpkFbLocationManager> provider4, PerfTestConfig perfTestConfig, FbSharedPreferences fbSharedPreferences, FbErrorReporter fbErrorReporter) {
        switch (C07151.f17766a[m24992a(provider, zeroFeatureVisibilityHelper, googlePlayServicesUtil, perfTestConfig, fbSharedPreferences, fbErrorReporter).ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return (BaseFbLocationManager) provider3.get();
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return (BaseFbLocationManager) provider2.get();
            case 3:
                return (BaseFbLocationManager) provider4.get();
            default:
                throw new IllegalStateException();
        }
    }

    public static FbLocationImplementation m24992a(Provider<TriState> provider, ZeroFeatureVisibilityHelper zeroFeatureVisibilityHelper, GooglePlayServicesUtil googlePlayServicesUtil, PerfTestConfig perfTestConfig, FbSharedPreferences fbSharedPreferences, FbErrorReporter fbErrorReporter) {
        if (perfTestConfig.m2943c()) {
            return FbLocationImplementation.MOCK_MPK_STATIC;
        }
        FbLocationImplementationPref fbLocationImplementationPref = FbLocationImplementationPref.get(fbSharedPreferences.mo276a(LocationPrefKeys.f17768b, FbLocationImplementationPref.DEFAULT.key));
        if (fbLocationImplementationPref != FbLocationImplementationPref.DEFAULT) {
            if (m24993b(googlePlayServicesUtil, fbErrorReporter) || fbLocationImplementationPref != FbLocationImplementationPref.GOOGLE_PLAY_PREF) {
                return fbLocationImplementationPref.locationImplementation;
            }
            return FbLocationImplementation.ANDROID_PLATFORM;
        } else if (provider.get() == TriState.YES || zeroFeatureVisibilityHelper.m7924a(ZeroFeatureKey.LOCATION_SERVICES_INTERSTITIAL) || !m24993b(googlePlayServicesUtil, fbErrorReporter)) {
            return FbLocationImplementation.ANDROID_PLATFORM;
        } else {
            return FbLocationImplementation.GOOGLE_PLAY;
        }
    }

    public static boolean m24993b(GooglePlayServicesUtil googlePlayServicesUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        try {
            if (googlePlayServicesUtil.m24990a() == 0) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            GooglePlayServicesExceptionUtil.a(e);
            abstractFbErrorReporter.m2343a("location_manager_provider", "GooglePlayServicesUtil error", e);
            return false;
        }
    }
}
