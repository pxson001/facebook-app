package com.facebook.feed.fragment.generatedenvironments;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherWrapper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.photos.prefetch.PrefetchParams;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: network_info_may_have_idled */
public class HasPrefetcherImpl implements HasPrefetcher, HasRowKey {
    private final MultiRowImagePrefetcherWrapper f12555a;
    private final AbstractFbErrorReporter f12556b;
    @Nullable
    private RowKey f12557c;

    @Inject
    public HasPrefetcherImpl(@Assisted MultiRowImagePrefetcherWrapper multiRowImagePrefetcherWrapper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12555a = multiRowImagePrefetcherWrapper;
        this.f12556b = abstractFbErrorReporter;
    }

    public final void mo2434a(ImageRequest imageRequest, CallerContext callerContext) {
        m18634a(this.f12557c, imageRequest, callerContext);
    }

    public final void m18634a(RowKey rowKey, ImageRequest imageRequest, CallerContext callerContext) {
        if (imageRequest == null) {
            this.f12556b.m2340a("HasPrefetcherImpl", "Null imageParam is used for prefetch: " + callerContext.f5181b);
        } else if (rowKey == null) {
            this.f12556b.m2340a("HasPrefetcherImpl", "Null rowKey is used for prefetch: " + callerContext.f5181b);
        } else {
            this.f12555a.mo2000a(rowKey, new PrefetchParams(imageRequest, callerContext));
        }
    }

    public final void mo2428a(RowKey rowKey) {
        this.f12557c = rowKey;
    }

    public final void mo2460n() {
        this.f12557c = null;
    }

    public final boolean mo2461o() {
        return this.f12557c != null;
    }

    public final RowKey mo2459m() {
        if (this.f12557c != null) {
            return this.f12557c;
        }
        throw new IllegalStateException();
    }
}
