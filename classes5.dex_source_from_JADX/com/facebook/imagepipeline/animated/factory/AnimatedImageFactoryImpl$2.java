package com.facebook.imagepipeline.animated.factory;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback;
import java.util.List;

/* compiled from: TRAVEL_SITE */
class AnimatedImageFactoryImpl$2 implements Callback {
    final /* synthetic */ List f13626a;
    final /* synthetic */ AnimatedImageFactoryImpl f13627b;

    AnimatedImageFactoryImpl$2(AnimatedImageFactoryImpl animatedImageFactoryImpl, List list) {
        this.f13627b = animatedImageFactoryImpl;
        this.f13626a = list;
    }

    public final void mo1258a(int i, Bitmap bitmap) {
    }

    public final CloseableReference<Bitmap> mo1257a(int i) {
        return CloseableReference.b((CloseableReference) this.f13626a.get(i));
    }
}
