package com.facebook.location;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.util.TriState;
import com.facebook.iorg.common.zero.interfaces.ZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import javax.inject.Provider;

/* compiled from: jpg */
public class FbLocationContinuousListenerProvider {

    /* compiled from: jpg */
    /* synthetic */ class C04351 {
        static final /* synthetic */ int[] f9720a = new int[FbLocationImplementation.values().length];

        static {
            try {
                f9720a[FbLocationImplementation.ANDROID_PLATFORM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9720a[FbLocationImplementation.GOOGLE_PLAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9720a[FbLocationImplementation.MOCK_MPK_STATIC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static FbLocationContinuousListener m10148a(Provider<TriState> provider, GooglePlayServicesUtil googlePlayServicesUtil, ZeroFeatureVisibilityHelper zeroFeatureVisibilityHelper, Provider<GooglePlayFbLocationContinuousListener> provider2, Provider<AndroidPlatformFbLocationContinuousListener> provider3, Provider<MockStaticMpkFbLocationContinuousListener> provider4, PerfTestConfig perfTestConfig, FbErrorReporter fbErrorReporter) {
        FbLocationImplementation fbLocationImplementation;
        int[] iArr = C04351.f9720a;
        if (perfTestConfig.c()) {
            fbLocationImplementation = FbLocationImplementation.MOCK_MPK_STATIC;
        } else if (provider.get() == TriState.YES || zeroFeatureVisibilityHelper.a(ZeroFeatureKey.LOCATION_SERVICES_INTERSTITIAL) || !m10149a(googlePlayServicesUtil, fbErrorReporter)) {
            fbLocationImplementation = FbLocationImplementation.ANDROID_PLATFORM;
        } else {
            fbLocationImplementation = FbLocationImplementation.GOOGLE_PLAY;
        }
        switch (iArr[fbLocationImplementation.ordinal()]) {
            case 1:
                return (FbLocationContinuousListener) provider3.get();
            case 2:
                return (FbLocationContinuousListener) provider2.get();
            case 3:
                return (FbLocationContinuousListener) provider4.get();
            default:
                throw new IllegalStateException();
        }
    }

    public static boolean m10149a(GooglePlayServicesUtil googlePlayServicesUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        try {
            if (googlePlayServicesUtil.a() == 0) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            GooglePlayServicesExceptionUtil.a(e);
            abstractFbErrorReporter.a("continuous_location_provider", "GooglePlayServicesUtil error", e);
            return false;
        }
    }
}
