package com.facebook.android.crypto.keychain;

import java.security.SecureRandom;

/* compiled from: optimistic_scan_cumulative_processing_time_ms */
public class FixedSecureRandom extends SecureRandom {
    public synchronized void nextBytes(byte[] bArr) {
        SecureRandomFix.a();
        super.nextBytes(bArr);
    }
}
