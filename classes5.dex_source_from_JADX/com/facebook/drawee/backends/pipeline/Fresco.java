package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;

/* compiled from: [[placeholder_ */
public class Fresco {
    public static PipelineDraweeControllerBuilderSupplier f11882a;

    private Fresco() {
    }

    public static PipelineDraweeControllerBuilder m19937a() {
        return f11882a.m19944b();
    }

    public static void m19938a(Context context) {
        ImagePipelineFactory.a(ImagePipelineConfig.a(context).c());
        PipelineDraweeControllerBuilderSupplier pipelineDraweeControllerBuilderSupplier = new PipelineDraweeControllerBuilderSupplier(context);
        f11882a = pipelineDraweeControllerBuilderSupplier;
        SimpleDraweeView.f11983a = pipelineDraweeControllerBuilderSupplier;
    }
}
