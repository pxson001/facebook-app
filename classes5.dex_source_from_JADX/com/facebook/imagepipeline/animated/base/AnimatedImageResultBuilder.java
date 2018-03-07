package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.List;

/* compiled from: TREEHOUSE_ANDROID_GROUPS_TAB_MENU */
public class AnimatedImageResultBuilder {
    public final AnimatedImage f13618a;
    public CloseableReference<Bitmap> f13619b;
    public List<CloseableReference<Bitmap>> f13620c;
    public int f13621d;

    AnimatedImageResultBuilder(AnimatedImage animatedImage) {
        this.f13618a = animatedImage;
    }

    public final AnimatedImageResultBuilder m22887a(CloseableReference<Bitmap> closeableReference) {
        this.f13619b = CloseableReference.b(closeableReference);
        return this;
    }

    public final AnimatedImageResultBuilder m22886a(int i) {
        this.f13621d = i;
        return this;
    }

    public final AnimatedImageResultBuilder m22888a(List<CloseableReference<Bitmap>> list) {
        this.f13620c = CloseableReference.a(list);
        return this;
    }

    public final AnimatedImageResult m22889e() {
        try {
            AnimatedImageResult animatedImageResult = new AnimatedImageResult(this);
            return animatedImageResult;
        } finally {
            CloseableReference.c(this.f13619b);
            this.f13619b = null;
            CloseableReference.a(this.f13620c);
            this.f13620c = null;
        }
    }
}
