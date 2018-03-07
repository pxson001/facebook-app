package com.facebook.feed.feedtype;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.feed.protocol.FetchFriendListFeedMethod;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: self_id */
public class FriendListFeedTypeDataItem extends AbstractFeedTypeDataItem {
    @Inject
    public FriendListFeedTypeDataItem(Lazy<FetchFriendListFeedMethod> lazy) {
        super(Name.f5047b, lazy);
    }

    public final String mo1401a(Intent intent, FeedType feedType) {
        return intent.getStringExtra("friend_list_name");
    }

    public final FeedType mo1400a(Intent intent) {
        return new FeedType(intent.getStringExtra("friend_list_feed_id"), Name.f5047b);
    }
}
