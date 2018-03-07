package com.facebook.feed.data.freshfeed;

import com.facebook.api.feed.xconfig.FreshFeedConfigReader;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.feed.model.ClientFeedUnitEdge;
import com.facebook.feed.rows.adapter.freshfeed.FreshFeedFeedUnitAdapterFactoryHolder;
import com.facebook.feed.rows.core.CachingFeedUnitAdapterFactory;
import com.facebook.feed.rows.core.FeedUnitAdapter;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Inject;

/* compiled from: search_results_page */
public class FreshFeedMultiRowStoryPreparer implements Runnable {
    private final DefaultProcessIdleExecutor f5871a;
    private final FreshFeedFeedUnitAdapterFactoryHolder f5872b;
    private final FreshFeedStoryCollection f5873c;
    private final FreshFeedConfigReader f5874d;

    @Inject
    public FreshFeedMultiRowStoryPreparer(DefaultProcessIdleExecutor defaultProcessIdleExecutor, FreshFeedFeedUnitAdapterFactoryHolder freshFeedFeedUnitAdapterFactoryHolder, @Assisted FreshFeedStoryCollection freshFeedStoryCollection, FreshFeedConfigReader freshFeedConfigReader) {
        this.f5871a = defaultProcessIdleExecutor;
        this.f5872b = freshFeedFeedUnitAdapterFactoryHolder;
        this.f5873c = freshFeedStoryCollection;
        this.f5874d = freshFeedConfigReader;
    }

    public final void m10031a() {
        ExecutorDetour.a(this.f5871a, this, -935663966);
    }

    public void run() {
        TracerDetour.a("FreshFeedMultiRowStoryPreparer.run", 774106026);
        try {
            CachingFeedUnitAdapterFactory a = this.f5872b.m10036a();
            if (a != null) {
                if (m10030a(a, this.f5874d.m9085e(5))) {
                    ExecutorDetour.a(this.f5871a, this, -533414898);
                }
                TracerDetour.a(-1875910582);
            }
        } finally {
            TracerDetour.a(400913453);
        }
    }

    private boolean m10030a(CachingFeedUnitAdapterFactory cachingFeedUnitAdapterFactory, int i) {
        int i2 = 0;
        while (i2 < i) {
            FreshFeedStoryCollection freshFeedStoryCollection = this.f5873c;
            ClientFeedUnitEdge b = freshFeedStoryCollection.f5850k.mo1419b(freshFeedStoryCollection.f5851l + i2);
            if (b == null && i2 < freshFeedStoryCollection.f5843d.size()) {
                b = (ClientFeedUnitEdge) freshFeedStoryCollection.f5843d.get(i2);
            }
            Object obj = b;
            String str = null;
            String a = CachingFeedUnitAdapterFactory.m19965a(obj, null);
            if (a != null) {
                FeedUnitAdapter feedUnitAdapter = (FeedUnitAdapter) cachingFeedUnitAdapterFactory.f13580b.get(a);
                if (feedUnitAdapter == null) {
                    str = cachingFeedUnitAdapterFactory.f13579a.mo2518a(obj, cachingFeedUnitAdapterFactory.f13581c);
                    cachingFeedUnitAdapterFactory.f13580b.put(a, str);
                }
            }
            String str2 = str;
            if (str2 != null) {
                Object obj2 = null;
                for (int i3 = 0; i3 < str2.m19044a(); i3++) {
                    if (str2.m19052e(i3)) {
                        obj2 = 1;
                        break;
                    }
                }
                if (obj2 != null) {
                    return true;
                }
            }
            i2++;
        }
        return false;
    }
}
