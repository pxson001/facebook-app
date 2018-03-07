package com.facebook.widget.images;

import android.graphics.Canvas;
import com.facebook.common.references.CloseableReference;
import com.facebook.debug.log.BLog;
import com.facebook.imagepipeline.animated.base.AnimatedDrawable;
import com.facebook.imagepipeline.image.CloseableImage;

@Deprecated
/* compiled from: request_ref */
public class CloseableAnimatedDrawable extends CloseableForwardingDrawable {
    private static final Class<?> f5754a = CloseableAnimatedDrawable.class;
    private final CloseableReference<CloseableImage> f5755c;

    public CloseableAnimatedDrawable(AnimatedDrawable animatedDrawable, CloseableReference<CloseableImage> closeableReference) {
        super(animatedDrawable);
        this.f5755c = closeableReference.b();
    }

    public void draw(Canvas canvas) {
        if (m8357c()) {
            BLog.a(f5754a, "draw: Drawable %x already closed. Underlying closeable ref = %x", new Object[]{Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.f5755c))});
            return;
        }
        super.draw(canvas);
    }

    public void close() {
        if (m8358d()) {
            CloseableReference.c(this.f5755c);
        }
    }

    protected void finalize() {
        if (!m8357c()) {
            BLog.a(f5754a, "finalize: Drawable %x still open. Underlying closeable ref = %x, bitmap = %x", new Object[]{Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.f5755c)), Integer.valueOf(this.f5755c.e())});
            try {
                setCallback(null);
                close();
            } finally {
                super.finalize();
            }
        }
    }
}
