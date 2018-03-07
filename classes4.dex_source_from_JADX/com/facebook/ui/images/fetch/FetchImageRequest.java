package com.facebook.ui.images.fetch;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.common.FbHttpRequestCancelTrigger;
import com.facebook.widget.images.UrlImage.UrlImageProgressListener;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: engine_failure */
public class FetchImageRequest {
    public final FetchImageParams f12938a;
    @Nullable
    public final FetchSource f12939b;
    public final FbHttpRequestCancelTrigger f12940c;
    @Nullable
    public final ImageReferrer f12941d;
    public final CallerContext f12942e;
    @Nullable
    public final UrlImageProgressListener f12943f;

    /* compiled from: engine_failure */
    public enum FetchSource {
        CACHE_ONLY,
        NETWORK_ONLY,
        CACHE_OR_NETWORK
    }

    FetchImageRequest(FetchImageRequestBuilder fetchImageRequestBuilder) {
        this.f12938a = fetchImageRequestBuilder.f12944a;
        FetchSource fetchSource = fetchImageRequestBuilder.f12945b;
        if (fetchImageRequestBuilder.f12944a != null && fetchImageRequestBuilder.f12944a.f12957h) {
            boolean z = fetchSource == null || fetchSource == FetchSource.CACHE_ONLY;
            Preconditions.checkArgument(z, "Conflict with deprecated API, impossible request");
        }
        this.f12939b = fetchSource;
        FbHttpRequestCancelTrigger fbHttpRequestCancelTrigger = fetchImageRequestBuilder.f12946c;
        if (fbHttpRequestCancelTrigger == null) {
            fbHttpRequestCancelTrigger = new FbHttpRequestCancelTrigger();
        }
        this.f12940c = fbHttpRequestCancelTrigger;
        this.f12941d = fetchImageRequestBuilder.f12947d;
        this.f12942e = (CallerContext) Preconditions.checkNotNull(fetchImageRequestBuilder.f12948e);
        this.f12943f = fetchImageRequestBuilder.f12949f;
    }

    public static FetchImageRequestBuilder m13836a(FetchImageRequest fetchImageRequest) {
        FetchImageRequestBuilder a = new FetchImageRequestBuilder(fetchImageRequest.f12938a).m13843a(fetchImageRequest.f12942e);
        a.f12945b = fetchImageRequest.f12939b;
        a = a;
        a.f12946c = fetchImageRequest.f12940c;
        a = a;
        a.f12947d = fetchImageRequest.f12941d;
        a = a;
        a.f12949f = fetchImageRequest.f12943f;
        return a;
    }

    public final FetchImageParams m13837a() {
        return this.f12938a;
    }

    @Nullable
    public final FetchSource m13838b() {
        return this.f12939b;
    }

    public final FbHttpRequestCancelTrigger m13839c() {
        return this.f12940c;
    }

    @Nullable
    public final ImageReferrer m13840d() {
        return this.f12941d;
    }

    public final CallerContext m13841e() {
        return this.f12942e;
    }

    public final UrlImageProgressListener m13842f() {
        return this.f12943f;
    }
}
