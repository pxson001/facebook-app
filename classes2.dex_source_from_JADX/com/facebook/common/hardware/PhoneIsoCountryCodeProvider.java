package com.facebook.common.hardware;

import android.telephony.TelephonyManager;
import com.facebook.debug.log.BLog;
import com.google.common.base.Strings;
import java.util.Locale;
import javax.inject.Provider;

/* compiled from: remove_member */
public class PhoneIsoCountryCodeProvider {
    private static final Class<?> f7612a = PhoneIsoCountryCodeProvider.class;

    public static String m12186a(TelephonyManager telephonyManager, Provider<Locale> provider) {
        String simCountryIso = telephonyManager.getSimCountryIso();
        if (Strings.isNullOrEmpty(simCountryIso)) {
            simCountryIso = telephonyManager.getNetworkCountryIso();
        }
        if (Strings.isNullOrEmpty(simCountryIso)) {
            simCountryIso = ((Locale) provider.get()).getCountry();
        }
        if (!Strings.isNullOrEmpty(simCountryIso)) {
            return simCountryIso.toUpperCase(Locale.US);
        }
        BLog.a(f7612a, "No ISO country code detected!");
        return null;
    }
}
