package com.google.android.gms.appdatasearch;

import java.util.HashMap;
import java.util.Map;

public class zzh {
    private static final String[] f20589a = new String[]{"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};
    private static final Map<String, Integer> f20590b = new HashMap(f20589a.length);

    static {
        int i = 0;
        while (i < f20589a.length) {
            f20590b.put(f20589a[i], Integer.valueOf(i));
            i++;
        }
    }

    public static String m20080a(int i) {
        return (i < 0 || i >= f20589a.length) ? null : f20589a[i];
    }
}
