package com.facebook.feed.feedtype;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.feed.protocol.FetchStoriesAboutPageFeedMethod;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: app_link_type */
public class StoriesAboutPageFeedTypeDataItem extends AbstractFeedTypeDataItem {
    @Inject
    public StoriesAboutPageFeedTypeDataItem(Lazy<FetchStoriesAboutPageFeedMethod> lazy) {
        super(Name.i, lazy);
    }

    public final String m22714a(Intent intent, FeedType feedType) {
        return intent.getStringExtra("fragment_title");
    }

    public final FeedType m22713a(Intent intent) {
        return new FeedType(String.valueOf(intent.getLongExtra("com.facebook.katana.profile.id", -1)), Name.i);
    }
}
