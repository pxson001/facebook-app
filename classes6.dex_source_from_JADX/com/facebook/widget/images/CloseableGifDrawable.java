package com.facebook.widget.images;

import com.facebook.common.references.CloseableReference;
import com.facebook.debug.log.BLog;
import com.facebook.imagepipeline.image.CloseableGIFImageOld;
import com.facebook.imagepipeline.image.CloseableImage;
import com.google.common.base.Preconditions;
import gifdrawable.pl.droidsonroids.gif.GifDrawable;

/* compiled from: requestId */
public class CloseableGifDrawable extends CloseableForwardingDrawable {
    private static final Class<?> f5759a = CloseableGifDrawable.class;
    private final CloseableReference<CloseableImage> f5760c;

    public CloseableGifDrawable(CloseableReference<CloseableImage> closeableReference) {
        Preconditions.checkState(CloseableReference.a(closeableReference));
        super(new GifDrawable(((CloseableGIFImageOld) closeableReference.a()).b));
        this.f5760c = closeableReference.b();
    }

    public void close() {
        if (m8358d()) {
            CloseableReference.c(this.f5760c);
        }
    }

    protected void finalize() {
        if (!m8357c()) {
            BLog.a(f5759a, "finalize: CloseableGifDrawable %x still open. Underlying closeable ref = %x, GIF image = %x", new Object[]{Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.f5760c)), Integer.valueOf(this.f5760c.e())});
            try {
                setCallback(null);
                close();
            } finally {
                super.finalize();
            }
        }
    }
}
