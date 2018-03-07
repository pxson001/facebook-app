package com.facebook.feed.feedtype;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.feed.protocol.FetchStoriesAboutPageFeedMethod;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: app_install_zero_rating_interstitial_cancel */
public class TrendingTopicFeedTypeDataItem extends AbstractFeedTypeDataItem {
    @Inject
    public TrendingTopicFeedTypeDataItem(Lazy<FetchStoriesAboutPageFeedMethod> lazy) {
        super(Name.j, lazy);
    }

    public final String m22718a(Intent intent, FeedType feedType) {
        return intent.getStringExtra("topic_name");
    }

    public final FeedType m22717a(Intent intent) {
        return new FeedType(intent.getStringExtra("topic_id"), Name.j);
    }
}
