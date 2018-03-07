package com.facebook.ui.images.fetch;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.common.FbHttpRequestCancelTrigger;
import com.facebook.ui.images.fetch.FetchImageRequest.FetchSource;
import com.facebook.widget.images.UrlImage.UrlImageProgressListener;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: engine_creation_succeeded */
public class FetchImageRequestBuilder {
    public FetchImageParams f12944a;
    @Nullable
    public FetchSource f12945b;
    public FbHttpRequestCancelTrigger f12946c;
    @Nullable
    public ImageReferrer f12947d;
    public CallerContext f12948e;
    @Nullable
    public UrlImageProgressListener f12949f;

    public FetchImageRequestBuilder(FetchImageParams fetchImageParams) {
        this.f12944a = fetchImageParams;
    }

    public final FetchImageRequestBuilder m13843a(CallerContext callerContext) {
        Preconditions.checkNotNull(callerContext);
        this.f12948e = callerContext;
        return this;
    }

    public final FetchImageRequest m13844g() {
        return new FetchImageRequest(this);
    }
}
