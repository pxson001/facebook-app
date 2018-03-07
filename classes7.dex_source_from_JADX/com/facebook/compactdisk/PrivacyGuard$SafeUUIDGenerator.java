package com.facebook.compactdisk;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.util.UUID;

/* compiled from: trimmed_length */
public class PrivacyGuard$SafeUUIDGenerator {
    public static UUID m1261a() {
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            UUID randomUUID = UUID.randomUUID();
            return randomUUID;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
