package com.facebook.widget.images;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.references.CloseableReference;
import com.facebook.debug.log.BLog;
import com.facebook.imagepipeline.image.CloseableAnimatedBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.ui.images.webp.BitmapAnimationDrawable;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

@Deprecated
/* compiled from: request_ack */
public class CloseableBitmapDrawable extends CloseableForwardingDrawable {
    private static final Class<?> f5756c = CloseableBitmapDrawable.class;
    @VisibleForTesting
    public final CloseableReference<CloseableImage> f5757a;
    public BitmapType f5758d;

    /* compiled from: request_ack */
    public enum BitmapType {
        STATIC,
        ANIMATED
    }

    public CloseableBitmapDrawable(Resources resources, CloseableReference<CloseableImage> closeableReference) {
        super(m8359a(resources, closeableReference));
        this.f5757a = closeableReference.b();
        if (((CloseableImage) closeableReference.a()) instanceof CloseableAnimatedBitmap) {
            this.f5758d = BitmapType.ANIMATED;
        } else {
            this.f5758d = BitmapType.STATIC;
        }
    }

    private static Drawable m8359a(Resources resources, CloseableReference<CloseableImage> closeableReference) {
        Preconditions.checkNotNull(resources);
        Preconditions.checkState(CloseableReference.a(closeableReference));
        CloseableImage closeableImage = (CloseableImage) closeableReference.a();
        if (closeableImage instanceof CloseableStaticBitmap) {
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
            Preconditions.checkNotNull(closeableStaticBitmap.a());
            return new BitmapDrawable(resources, closeableStaticBitmap.a());
        } else if (closeableImage instanceof CloseableAnimatedBitmap) {
            CloseableAnimatedBitmap closeableAnimatedBitmap = (CloseableAnimatedBitmap) closeableImage;
            Preconditions.checkNotNull(closeableAnimatedBitmap.b);
            Preconditions.checkNotNull(closeableAnimatedBitmap.c);
            return new BitmapAnimationDrawable(resources, closeableAnimatedBitmap.b, closeableAnimatedBitmap.c);
        } else {
            throw new UnsupportedOperationException("Unrecognized image class: " + closeableImage);
        }
    }

    public void draw(Canvas canvas) {
        if (m8357c()) {
            BLog.a(f5756c, "draw: Drawable %x already closed. Underlying closeable ref = %x", new Object[]{Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.f5757a))});
            return;
        }
        super.draw(canvas);
    }

    public void close() {
        if (m8358d()) {
            CloseableReference.c(this.f5757a);
        }
    }

    protected void finalize() {
        if (!m8357c()) {
            BLog.a(f5756c, "finalize: Drawable %x still open. Underlying closeable ref = %x, bitmap = %x", new Object[]{Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.f5757a)), Integer.valueOf(this.f5757a.e())});
            try {
                setCallback(null);
                close();
            } finally {
                super.finalize();
            }
        }
    }
}
