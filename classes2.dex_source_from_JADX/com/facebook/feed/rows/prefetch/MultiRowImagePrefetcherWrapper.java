package com.facebook.feed.rows.prefetch;

import com.facebook.feed.rows.core.RowIdentifier;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.photos.prefetch.PrefetchParams;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;

/* compiled from: pages/messaging/private_reply/dialog/%s/%s */
public interface MultiRowImagePrefetcherWrapper {
    OnScrollListener mo1998a();

    void mo1999a(RowIdentifier rowIdentifier);

    void mo2000a(RowKey rowKey, PrefetchParams prefetchParams);

    void mo2001a(ScrollingViewProxy scrollingViewProxy);

    void mo2002b();
}
