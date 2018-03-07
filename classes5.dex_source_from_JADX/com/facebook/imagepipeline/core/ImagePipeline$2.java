package com.facebook.imagepipeline.core;

import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: TRANSPARENT */
public class ImagePipeline$2 implements Supplier<DataSource<CloseableReference<PooledByteBuffer>>> {
    final /* synthetic */ ImageRequest f13687a;
    final /* synthetic */ Object f13688b;
    final /* synthetic */ ImagePipeline f13689c;

    public ImagePipeline$2(ImagePipeline imagePipeline, ImageRequest imageRequest, Object obj) {
        this.f13689c = imagePipeline;
        this.f13687a = imageRequest;
        this.f13688b = obj;
    }

    public final Object m23017a() {
        return this.f13689c.d(this.f13687a, this.f13688b);
    }

    public String toString() {
        return Objects.a(this).a("uri", this.f13687a.c).toString();
    }
}
