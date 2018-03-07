package com.facebook.feed.feedtype;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.feed.protocol.FetchGoodFriendsFeedMethod;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: self */
public class GoodFriendsFeedTypeDataItem extends AbstractFeedTypeDataItem {
    @Inject
    public GoodFriendsFeedTypeDataItem(Lazy<FetchGoodFriendsFeedMethod> lazy) {
        super(Name.f5048c, lazy);
    }

    public final String mo1401a(Intent intent, FeedType feedType) {
        return null;
    }

    public final FeedType mo1400a(Intent intent) {
        return null;
    }
}
