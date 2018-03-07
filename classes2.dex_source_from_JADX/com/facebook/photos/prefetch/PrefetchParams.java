package com.facebook.photos.prefetch;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.common.base.Preconditions;

/* compiled from: graphql_subscriptions_unsubscribe */
public class PrefetchParams {
    public final ImageRequest f21908a;
    public final CallerContext f21909b;

    public PrefetchParams(ImageRequest imageRequest, CallerContext callerContext) {
        this.f21908a = (ImageRequest) Preconditions.checkNotNull(imageRequest);
        this.f21909b = (CallerContext) Preconditions.checkNotNull(callerContext);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PrefetchParams)) {
            return false;
        }
        PrefetchParams prefetchParams = (PrefetchParams) obj;
        if (this.f21908a.equals(prefetchParams.f21908a) && this.f21909b.equals(prefetchParams.f21909b)) {
            return true;
        }
        return false;
    }

    public final String m29725c() {
        return this.f21908a.f12746c.toString();
    }
}
