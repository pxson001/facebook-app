package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Set;

/* compiled from: [[link]] */
public class PipelineDraweeControllerBuilder extends AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> {
    private final ImagePipeline f11883a;
    private final PipelineDraweeControllerFactory f11884b;

    protected final DataSource m19939a(Object obj, Object obj2, boolean z) {
        ImageRequest imageRequest = (ImageRequest) obj;
        if (z) {
            return this.f11883a.b(imageRequest, obj2);
        }
        return this.f11883a.c(imageRequest, obj2);
    }

    public PipelineDraweeControllerBuilder(Context context, PipelineDraweeControllerFactory pipelineDraweeControllerFactory, ImagePipeline imagePipeline, Set<ControllerListener> set) {
        super(context, set);
        this.f11883a = imagePipeline;
        this.f11884b = pipelineDraweeControllerFactory;
    }

    public final SimpleDraweeControllerBuilder m19940a(Uri uri) {
        return (PipelineDraweeControllerBuilder) super.c(ImageRequest.a(uri));
    }

    protected final AbstractDraweeControllerBuilder m19942o() {
        return this;
    }

    protected final AbstractDraweeController m19941n() {
        DraweeController draweeController = this.o;
        if (draweeController instanceof PipelineDraweeController) {
            PipelineDraweeController pipelineDraweeController = (PipelineDraweeController) draweeController;
            pipelineDraweeController.a(m(), AbstractDraweeControllerBuilder.l(), c());
            return pipelineDraweeController;
        }
        PipelineDraweeControllerFactory pipelineDraweeControllerFactory = this.f11884b;
        return new PipelineDraweeController(pipelineDraweeControllerFactory.f11889a, pipelineDraweeControllerFactory.f11890b, pipelineDraweeControllerFactory.f11891c, pipelineDraweeControllerFactory.f11892d, m(), AbstractDraweeControllerBuilder.l(), c());
    }
}
