package com.facebook.http.protocol;

import com.facebook.http.protocol.ApiMethodRunner$Batch.Type;

/* compiled from: fbtrace_meta */
/* synthetic */ class BatchControllerRegistry$1 {
    static final /* synthetic */ int[] f11933a = new int[Type.values().length];

    static {
        try {
            f11933a[Type.NORMAL.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f11933a[Type.STREAMING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
