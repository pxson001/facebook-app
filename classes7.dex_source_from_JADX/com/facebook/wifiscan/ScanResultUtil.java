package com.facebook.wifiscan;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* compiled from: d2a192990d68eeaa98f71958874edf6e */
public class ScanResultUtil {
    public static final Comparator<ScanResult> f16188a = new C12801();

    /* compiled from: d2a192990d68eeaa98f71958874edf6e */
    final class C12801 implements Comparator<ScanResult> {
        C12801() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((ScanResult) obj2).level - ((ScanResult) obj).level;
        }
    }

    private ScanResultUtil() {
    }
}
