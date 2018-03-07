package com.facebook.imagepipeline.image;

import com.facebook.common.logging.FLog;
import java.io.Closeable;

/* compiled from: last_read_timestamp_ms */
public abstract class CloseableImage implements Closeable {
    public abstract int mo2980b();

    public abstract boolean mo2981c();

    public abstract void close();

    public abstract int mo2984f();

    public abstract int mo2985g();

    public ImmutableQualityInfo mo2983d() {
        return ImmutableQualityInfo.f17879a;
    }

    public boolean mo2992e() {
        return false;
    }

    protected void finalize() {
        if (!mo2981c()) {
            FLog.a("CloseableImage", "finalize: %s %x still open.", new Object[]{getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this))});
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }
}
