package com.facebook.feed.feedtype;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.feed.protocol.FetchNewsFeedMethod;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: app_rater_report */
public class PageNewsFeedTypeDataItem extends AbstractFeedTypeDataItem {
    @Inject
    public PageNewsFeedTypeDataItem(Lazy<FetchNewsFeedMethod> lazy) {
        super(Name.h, lazy);
    }

    public final String m22710a(Intent intent, FeedType feedType) {
        return null;
    }

    public final FeedType m22709a(Intent intent) {
        return new FeedType(intent.getStringExtra("page_feed_id"), Name.h);
    }
}
