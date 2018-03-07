package com.facebook.qe.api;

import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: unexpected short read of  */
public class ExposureLoggerFilter {
    public final AtomicIntegerArray f1977a;

    public ExposureLoggerFilter(int i) {
        this.f1977a = new AtomicIntegerArray(i);
        m4007a();
    }

    public final void m4007a() {
        int length = this.f1977a.length();
        for (int i = 0; i < length; i++) {
            this.f1977a.set(i, 0);
        }
    }
}
