package com.facebook.events.feed.data;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.events.feed.protocol.FetchEventFeedMethod;
import com.facebook.feed.feedtype.AbstractFeedTypeDataItem;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: selfupdate/ */
public class EventFeedStoriesDataItem extends AbstractFeedTypeDataItem {
    @Inject
    public EventFeedStoriesDataItem(Lazy<FetchEventFeedMethod> lazy) {
        super(Name.f5059n, lazy, false, false);
    }

    public final String mo1401a(Intent intent, FeedType feedType) {
        return null;
    }

    public final FeedType mo1400a(Intent intent) {
        return null;
    }
}
