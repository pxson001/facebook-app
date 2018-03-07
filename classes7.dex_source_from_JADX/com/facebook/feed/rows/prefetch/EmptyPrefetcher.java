package com.facebook.feed.rows.prefetch;

import com.facebook.feed.rows.core.RowIdentifier;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.photos.prefetch.PrefetchParams;
import com.facebook.widget.listview.BaseProxyOnScrollListener;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;

/* compiled from: __default_type__ */
public class EmptyPrefetcher implements MultiRowImagePrefetcherWrapper {
    private static final OnScrollListener f20350a = new BaseProxyOnScrollListener();

    public final OnScrollListener m23475a() {
        return f20350a;
    }

    public final void m23477a(RowKey rowKey, PrefetchParams prefetchParams) {
    }

    public final void m23476a(RowIdentifier rowIdentifier) {
    }

    public final void m23478a(ScrollingViewProxy scrollingViewProxy) {
    }

    public final void m23479b() {
    }
}
