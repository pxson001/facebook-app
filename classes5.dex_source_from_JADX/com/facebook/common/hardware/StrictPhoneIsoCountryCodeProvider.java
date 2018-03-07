package com.facebook.common.hardware;

import android.telephony.TelephonyManager;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import java.util.Locale;

/* compiled from: sphericalPlayableUrlHdString */
public class StrictPhoneIsoCountryCodeProvider {
    private static final Class<?> f2610a = StrictPhoneIsoCountryCodeProvider.class;

    public static String m3720a(TelephonyManager telephonyManager) {
        Object simCountryIso = telephonyManager.getSimCountryIso();
        if (StringUtil.a(simCountryIso)) {
            simCountryIso = telephonyManager.getNetworkCountryIso();
        }
        if (!StringUtil.a(simCountryIso)) {
            return simCountryIso.toUpperCase(Locale.US);
        }
        BLog.a(f2610a, "No ISO country code detected!");
        return "";
    }
}
