package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.ResourceReleaser;

/* compiled from: setSurfaceTexture failed for Regular Video */
public class SimpleBitmapReleaser implements ResourceReleaser<Bitmap> {
    private static SimpleBitmapReleaser f2407a;

    public final void m2683a(Object obj) {
        ((Bitmap) obj).recycle();
    }

    public static SimpleBitmapReleaser m2682a() {
        if (f2407a == null) {
            f2407a = new SimpleBitmapReleaser();
        }
        return f2407a;
    }

    private SimpleBitmapReleaser() {
    }
}
