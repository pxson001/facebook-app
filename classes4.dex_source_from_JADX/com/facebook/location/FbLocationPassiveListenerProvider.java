package com.facebook.location;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.util.TriState;
import javax.inject.Provider;

/* compiled from: gsf_installation_status */
public class FbLocationPassiveListenerProvider {
    public static FbLocationPassiveListener m11376a(Provider<TriState> provider, GooglePlayServicesUtil googlePlayServicesUtil, Provider<GooglePlayFbLocationPassiveListener> provider2, Provider<AndroidPlatformFbLocationPassiveListener> provider3, FbErrorReporter fbErrorReporter) {
        switch (1.a[m11375a(provider, googlePlayServicesUtil, fbErrorReporter).ordinal()]) {
            case 1:
                return (FbLocationPassiveListener) provider3.get();
            case 2:
                return (FbLocationPassiveListener) provider2.get();
            default:
                throw new IllegalStateException();
        }
    }

    public static FbLocationImplementation m11375a(Provider<TriState> provider, GooglePlayServicesUtil googlePlayServicesUtil, FbErrorReporter fbErrorReporter) {
        if (provider.get() == TriState.YES || !m11377a(googlePlayServicesUtil, fbErrorReporter)) {
            return FbLocationImplementation.ANDROID_PLATFORM;
        }
        return FbLocationImplementation.GOOGLE_PLAY;
    }

    private static boolean m11377a(GooglePlayServicesUtil googlePlayServicesUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        try {
            if (googlePlayServicesUtil.a() == 0) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            GooglePlayServicesExceptionUtil.a(e);
            abstractFbErrorReporter.a("passive_location_provider", "GooglePlayServicesUtil error", e);
            return false;
        }
    }
}
