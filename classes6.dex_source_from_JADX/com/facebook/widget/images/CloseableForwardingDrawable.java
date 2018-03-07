package com.facebook.widget.images;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import javax.annotation.concurrent.GuardedBy;

@Deprecated
/* compiled from: request_seen */
public abstract class CloseableForwardingDrawable extends ForwardingDrawable implements Closeable {
    private static final Class<?> f5752a = CloseableForwardingDrawable.class;
    @GuardedBy("this")
    private boolean f5753c = false;

    public CloseableForwardingDrawable(Drawable drawable) {
        super(drawable);
    }

    public final synchronized boolean m8357c() {
        return this.f5753c;
    }

    @VisibleForTesting
    private synchronized boolean m8355b() {
        boolean z = true;
        synchronized (this) {
            if (this.f5753c) {
                z = false;
            } else {
                this.f5753c = true;
            }
        }
        return z;
    }

    @VisibleForTesting
    final boolean m8358d() {
        m8356e();
        return m8355b();
    }

    @TargetApi(11)
    @VisibleForTesting
    private void m8356e() {
        if (VERSION.SDK_INT >= 11 && getCallback() != null) {
            throw new IllegalStateException("Trying to close drawable while it's still being attached to the view tree: " + getCallback());
        }
    }

    public void draw(Canvas canvas) {
        if (m8357c()) {
            BLog.b(f5752a, "CloseableForwardingDrawable: draw while closed: %x", new Object[]{Integer.valueOf(System.identityHashCode(this))});
            return;
        }
        super.draw(canvas);
    }
}
