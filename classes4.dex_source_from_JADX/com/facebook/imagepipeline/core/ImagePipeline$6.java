package com.facebook.imagepipeline.core;

import android.net.Uri;
import com.android.internal.util.Predicate;
import com.facebook.cache.common.CacheKey;

/* compiled from: output_indicator */
class ImagePipeline$6 implements Predicate<CacheKey> {
    final /* synthetic */ Uri f5745a;
    final /* synthetic */ ImagePipeline f5746b;

    ImagePipeline$6(ImagePipeline imagePipeline, Uri uri) {
        this.f5746b = imagePipeline;
        this.f5745a = uri;
    }

    public boolean apply(Object obj) {
        return ((CacheKey) obj).a(this.f5745a);
    }
}
