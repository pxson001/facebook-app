package com.facebook.prefs.shared;

import com.facebook.common.typedkey.TypedKey;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;

/* compiled from: share_external */
public class PrefKeyUtil {
    public static SortedMap<PrefKey, Object> m8910a(Map<PrefKey, Object> map, PrefKey prefKey) {
        SortedMap f = Maps.m844f();
        for (Entry entry : map.entrySet()) {
            if (((PrefKey) entry.getKey()).m2013a((TypedKey) prefKey)) {
                f.put(entry.getKey(), entry.getValue());
            }
        }
        return f;
    }
}
