package com.facebook.feed.feedtype;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.feed.data.typemanager.PreferredFeedTypeManager;
import com.facebook.feed.protocol.FetchNewsFeedMethod;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: selected_uris */
public class NewsFeedTypeDataItem extends AbstractFeedTypeDataItem {
    private final PreferredFeedTypeManager f5767a;

    @Inject
    public NewsFeedTypeDataItem(Lazy<FetchNewsFeedMethod> lazy, PreferredFeedTypeManager preferredFeedTypeManager) {
        super(Name.f5046a, lazy);
        this.f5767a = preferredFeedTypeManager;
    }

    public final String mo1401a(Intent intent, FeedType feedType) {
        return null;
    }

    public final FeedType mo1400a(Intent intent) {
        String stringExtra = intent.getStringExtra("feed_type");
        if (stringExtra == null) {
            return this.f5767a.m4200a();
        }
        FeedType feedType;
        if (FeedType.f5038a.m8961a().equalsIgnoreCase(stringExtra)) {
            feedType = FeedType.f5038a;
        } else if (FeedType.f5039b.m8961a().equalsIgnoreCase(stringExtra)) {
            feedType = FeedType.f5039b;
        } else {
            feedType = null;
        }
        FeedType feedType2 = feedType;
        return feedType2 == null ? FeedType.f5039b : feedType2;
    }
}
