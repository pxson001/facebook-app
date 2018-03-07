package com.facebook.feed.feedtype;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.feed.protocol.FetchPageFeedMethod;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: app_requests */
public class PageFeedTypeDataItem extends AbstractFeedTypeDataItem {
    @Inject
    public PageFeedTypeDataItem(Lazy<FetchPageFeedMethod> lazy) {
        super(Name.g, lazy);
    }

    public final String m22708a(Intent intent, FeedType feedType) {
        return null;
    }

    public final FeedType m22707a(Intent intent) {
        return new FeedType(intent.getStringExtra("page_feed_id"), Name.g);
    }
}
