package com.facebook.react.modules.storage;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import javax.annotation.Nullable;

/* compiled from: friends_nag_impressions/ */
public class AsyncStorageErrorUtil {
    static WritableMap m13752a(@Nullable String str, String str2) {
        WritableMap b = Arguments.m13388b();
        b.putString("message", str2);
        if (str != null) {
            b.putString("key", str);
        }
        return b;
    }

    static WritableMap m13751a(@Nullable String str) {
        return m13752a(str, "Invalid key");
    }

    static WritableMap m13753b(@Nullable String str) {
        return m13752a(str, "Invalid Value");
    }

    static WritableMap m13754c(@Nullable String str) {
        return m13752a(str, "Database Error");
    }
}
