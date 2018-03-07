package com.facebook.crypto.util;

import java.io.IOException;

/* compiled from: syncContactsDelta (%d contacts) */
public class Assertions {
    public static void m1742a(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    public static void m1743b(boolean z, String str) {
        if (!z) {
            throw new IOException(str);
        }
    }
}
