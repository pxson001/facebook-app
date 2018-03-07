package com.facebook.proxygen;

import java.util.Map;

/* compiled from: mDialtoneManualSwitcherStub should not be null */
public final class TraceEventUtil {
    public static int readIntMeta(Map<String, String> map, String str, int i) {
        if (map.containsKey(str)) {
            try {
                i = Integer.parseInt((String) map.get(str));
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    public static boolean readBooleanMeta(Map<String, String> map, String str, boolean z) {
        if (!map.containsKey(str)) {
            return z;
        }
        if (Boolean.parseBoolean((String) map.get(str))) {
            return true;
        }
        if (((String) map.get(str)).equals("1")) {
            return true;
        }
        return false;
    }

    public static String readStrMeta(Map<String, String> map, String str, String str2) {
        return !map.containsKey(str) ? str2 : (String) map.get(str);
    }
}
