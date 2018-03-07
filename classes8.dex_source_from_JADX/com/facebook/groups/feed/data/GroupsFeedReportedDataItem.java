package com.facebook.groups.feed.data;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.feed.feedtype.AbstractFeedTypeDataItem;
import com.facebook.groups.feed.protocol.FetchGroupFeedMethod;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: faceweb/f?href=/draft_posts/?pageid=%s */
public class GroupsFeedReportedDataItem extends AbstractFeedTypeDataItem {
    @Inject
    public GroupsFeedReportedDataItem(Lazy<FetchGroupFeedMethod> lazy) {
        super(Name.w, lazy, false, false);
    }

    public final String m15631a(Intent intent, FeedType feedType) {
        return null;
    }

    public final FeedType m15630a(Intent intent) {
        return null;
    }
}
