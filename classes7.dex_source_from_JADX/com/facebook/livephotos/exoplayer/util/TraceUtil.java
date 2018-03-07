package com.facebook.livephotos.exoplayer.util;

import android.os.Trace;

/* compiled from: opacity */
public final class TraceUtil {
    private TraceUtil() {
    }

    public static void m9359a(String str) {
        if (Util.f7736a >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void m9358a() {
        if (Util.f7736a >= 18) {
            Trace.endSection();
        }
    }
}
