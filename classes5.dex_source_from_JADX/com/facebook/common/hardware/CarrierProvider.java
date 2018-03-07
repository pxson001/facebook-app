package com.facebook.common.hardware;

import android.telephony.TelephonyManager;
import com.google.common.base.Strings;

/* compiled from: sphericalPreferredFov */
public class CarrierProvider {
    public static Carrier m3713a(TelephonyManager telephonyManager) {
        String networkOperator = telephonyManager.getNetworkOperator();
        int i = 0;
        if (!Strings.isNullOrEmpty(networkOperator) && networkOperator.length() >= 3) {
            i = m3714c(networkOperator.substring(0, 3));
        }
        int i2 = i;
        if (Strings.isNullOrEmpty(networkOperator) || networkOperator.length() <= 3) {
            i = 0;
        } else {
            i = m3714c(networkOperator.substring(3));
        }
        return Carrier.fromMncMcc(i2, i);
    }

    public static int m3714c(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
