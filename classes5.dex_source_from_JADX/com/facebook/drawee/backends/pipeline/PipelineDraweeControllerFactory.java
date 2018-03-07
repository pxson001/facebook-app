package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactoryImpl;
import java.util.concurrent.Executor;

/* compiled from: [TT;)V */
public class PipelineDraweeControllerFactory {
    public Resources f11889a;
    public DeferredReleaser f11890b;
    public AnimatedDrawableFactoryImpl f11891c;
    public Executor f11892d;

    public PipelineDraweeControllerFactory(Resources resources, DeferredReleaser deferredReleaser, AnimatedDrawableFactoryImpl animatedDrawableFactoryImpl, Executor executor) {
        this.f11889a = resources;
        this.f11890b = deferredReleaser;
        this.f11891c = animatedDrawableFactoryImpl;
        this.f11892d = executor;
    }
}
