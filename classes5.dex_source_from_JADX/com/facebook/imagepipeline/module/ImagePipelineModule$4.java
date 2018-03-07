package com.facebook.imagepipeline.module;

import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;

/* compiled from: TOP_PARTNERS_VIDEOS */
final class ImagePipelineModule$4 implements AnimatedDrawableBackendProvider {
    final /* synthetic */ AnimatedDrawableUtil f13736a;

    ImagePipelineModule$4(AnimatedDrawableUtil animatedDrawableUtil) {
        this.f13736a = animatedDrawableUtil;
    }

    public final AnimatedDrawableBackend m23080a(AnimatedImageResult animatedImageResult, Rect rect) {
        return new AnimatedDrawableBackendImpl(this.f13736a, animatedImageResult, rect);
    }
}
