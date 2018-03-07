package com.facebook.ui.images.fetch;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.widget.images.UrlImage.UrlImageProgressListener;
import javax.annotation.Nullable;

/* compiled from: search_top_photos_module */
public class UrlImageFetchParams {
    public final FetchImageParams f5136a;
    public final UrlImageProgressListener f5137b;
    public final CallerContext f5138c;

    public UrlImageFetchParams(FetchImageParams fetchImageParams, @Nullable CallerContext callerContext, @Nullable UrlImageProgressListener urlImageProgressListener) {
        this.f5136a = fetchImageParams;
        this.f5137b = urlImageProgressListener;
        this.f5138c = callerContext;
    }

    public final String m7875a() {
        return this.f5138c != null ? this.f5138c.c() : "unknown";
    }
}
