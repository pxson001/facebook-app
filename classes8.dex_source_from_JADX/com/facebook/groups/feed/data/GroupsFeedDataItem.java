package com.facebook.groups.feed.data;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.feed.feedtype.AbstractFeedTypeDataItem;
import com.facebook.groups.feed.protocol.FetchGroupFeedMethod;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: faceweb/f?href=/pages/edit/notifications/%s */
public class GroupsFeedDataItem extends AbstractFeedTypeDataItem {
    @Inject
    public GroupsFeedDataItem(Lazy<FetchGroupFeedMethod> lazy) {
        super(Name.o, lazy, false, false);
    }

    public final String m15608a(Intent intent, FeedType feedType) {
        return null;
    }

    public final FeedType m15607a(Intent intent) {
        return null;
    }
}
