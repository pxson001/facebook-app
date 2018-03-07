package com.facebook.feed.ui.imageloader;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.adaptiveimagequality.base.ImageQuality;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

/* compiled from: There is no default route.  The media router has not yet been fully initialized. */
public class AsyncFeedImagePrefetchHelper {
    private final FeedImagePreloader f22195a;
    private final CopyOnWriteArrayList<FeedUnit> f22196b = new CopyOnWriteArrayList();

    public static AsyncFeedImagePrefetchHelper m24843b(InjectorLike injectorLike) {
        return new AsyncFeedImagePrefetchHelper(AsyncFeedImagePrefetcher.m24847a(injectorLike), (FeedImagePreloaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedImagePreloaderProvider.class));
    }

    @Inject
    public AsyncFeedImagePrefetchHelper(AsyncFeedImagePrefetcher asyncFeedImagePrefetcher, FeedImagePreloaderProvider feedImagePreloaderProvider) {
        this.f22195a = feedImagePreloaderProvider.a(CallerContext.a(getClass(), "prefetch_newsfeed_image_in_bkg"), asyncFeedImagePrefetcher);
    }

    public final void m24844a(FeedUnit feedUnit) {
        this.f22196b.add(feedUnit);
    }

    public final void m24845a(ImageQuality imageQuality) {
        Iterator it = this.f22196b.iterator();
        while (it.hasNext()) {
            this.f22195a.m24864a(FeedProps.c((FeedUnit) it.next()), imageQuality);
        }
        this.f22196b.clear();
    }

    public static AsyncFeedImagePrefetchHelper m24842a(InjectorLike injectorLike) {
        return m24843b(injectorLike);
    }
}
