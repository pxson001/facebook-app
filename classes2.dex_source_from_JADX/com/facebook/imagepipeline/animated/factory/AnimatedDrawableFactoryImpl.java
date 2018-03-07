package com.facebook.imagepipeline.animated.factory;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.facebook.common.time.MonotonicClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawable;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryImpl.C06011;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableDiagnosticsImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableDiagnosticsNoop;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: memory_savings_max_story_count */
public class AnimatedDrawableFactoryImpl {
    private final AnimatedDrawableBackendProvider f14402a;
    private final C06011 f14403b;
    private final AnimatedDrawableUtil f14404c;
    private final ScheduledExecutorService f14405d;
    private final MonotonicClock f14406e = new C06021(this);
    private final Resources f14407f;

    /* compiled from: memory_savings_max_story_count */
    class C06021 implements MonotonicClock {
        final /* synthetic */ AnimatedDrawableFactoryImpl f14408a;

        C06021(AnimatedDrawableFactoryImpl animatedDrawableFactoryImpl) {
            this.f14408a = animatedDrawableFactoryImpl;
        }

        public long now() {
            return SystemClock.uptimeMillis();
        }
    }

    public AnimatedDrawableFactoryImpl(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, C06011 c06011, AnimatedDrawableUtil animatedDrawableUtil, ScheduledExecutorService scheduledExecutorService, Resources resources) {
        this.f14402a = animatedDrawableBackendProvider;
        this.f14403b = c06011;
        this.f14404c = animatedDrawableUtil;
        this.f14405d = scheduledExecutorService;
        this.f14407f = resources;
    }

    public final Drawable m20777a(CloseableImage closeableImage) {
        if (closeableImage instanceof CloseableAnimatedImage) {
            return m20776a(((CloseableAnimatedImage) closeableImage).a(), AnimatedDrawableOptions.a);
        }
        throw new UnsupportedOperationException("Unrecognized image class: " + closeableImage);
    }

    private AnimatedDrawable m20776a(AnimatedImageResult animatedImageResult, AnimatedDrawableOptions animatedDrawableOptions) {
        AnimatedImage animatedImage = animatedImageResult.a;
        return m20775a(animatedDrawableOptions, this.f14402a.mo2028a(animatedImageResult, new Rect(0, 0, animatedImage.mo2029a(), animatedImage.mo2032b())));
    }

    private AnimatedDrawable m20775a(AnimatedDrawableOptions animatedDrawableOptions, AnimatedDrawableBackend animatedDrawableBackend) {
        AnimatedDrawableDiagnostics animatedDrawableDiagnosticsImpl;
        DisplayMetrics displayMetrics = this.f14407f.getDisplayMetrics();
        C06011 c06011 = this.f14403b;
        AnimatedDrawableCachingBackend animatedDrawableCachingBackendImpl = new AnimatedDrawableCachingBackendImpl(c06011.f14397a, c06011.f14398b, c06011.f14399c, c06011.f14400d, animatedDrawableBackend, animatedDrawableOptions);
        if (animatedDrawableOptions.e) {
            animatedDrawableDiagnosticsImpl = new AnimatedDrawableDiagnosticsImpl(this.f14404c, displayMetrics);
        } else {
            animatedDrawableDiagnosticsImpl = AnimatedDrawableDiagnosticsNoop.a;
        }
        return new AnimatedDrawable(this.f14405d, animatedDrawableCachingBackendImpl, animatedDrawableDiagnosticsImpl, this.f14406e);
    }
}
