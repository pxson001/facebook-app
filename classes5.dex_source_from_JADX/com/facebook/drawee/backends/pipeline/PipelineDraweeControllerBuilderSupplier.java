package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactoryImpl;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryImpl;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import java.util.Set;

/* compiled from: [[I */
public class PipelineDraweeControllerBuilderSupplier implements Supplier<PipelineDraweeControllerBuilder> {
    private final Context f11885a;
    private final ImagePipeline f11886b;
    private final PipelineDraweeControllerFactory f11887c;
    private final Set<ControllerListener> f11888d;

    public final /* synthetic */ Object m19943a() {
        return m19944b();
    }

    public PipelineDraweeControllerBuilderSupplier(Context context) {
        this(context, ImagePipelineFactory.a());
    }

    private PipelineDraweeControllerBuilderSupplier(Context context, ImagePipelineFactory imagePipelineFactory) {
        this(context, imagePipelineFactory, null);
    }

    private PipelineDraweeControllerBuilderSupplier(Context context, ImagePipelineFactory imagePipelineFactory, Set<ControllerListener> set) {
        this.f11885a = context;
        this.f11886b = imagePipelineFactory.h();
        AnimatedFactoryImpl b = imagePipelineFactory.b();
        AnimatedDrawableFactoryImpl animatedDrawableFactoryImpl = null;
        if (b != null) {
            animatedDrawableFactoryImpl = b.a(context);
        }
        this.f11887c = new PipelineDraweeControllerFactory(context.getResources(), DeferredReleaser.a(), animatedDrawableFactoryImpl, UiThreadImmediateExecutorService.b());
        this.f11888d = set;
    }

    public final PipelineDraweeControllerBuilder m19944b() {
        return new PipelineDraweeControllerBuilder(this.f11885a, this.f11887c, this.f11886b, this.f11888d);
    }
}
