package com.facebook.common.identifiers;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.util.UUID;

/* compiled from: user_custom_tags */
public final class SafeUUIDGenerator {
    public static UUID m2795a() {
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            UUID randomUUID = UUID.randomUUID();
            return randomUUID;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
