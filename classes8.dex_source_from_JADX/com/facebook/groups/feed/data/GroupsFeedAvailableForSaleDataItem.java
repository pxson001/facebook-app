package com.facebook.groups.feed.data;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.feed.feedtype.AbstractFeedTypeDataItem;
import com.facebook.groups.feed.protocol.FetchGroupFeedMethod;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: faceweb/f?href=/pages/insights/overview/%s */
public class GroupsFeedAvailableForSaleDataItem extends AbstractFeedTypeDataItem {
    @Inject
    public GroupsFeedAvailableForSaleDataItem(Lazy<FetchGroupFeedMethod> lazy) {
        super(Name.t, lazy, false, false);
    }

    public final String m15600a(Intent intent, FeedType feedType) {
        return null;
    }

    public final FeedType m15599a(Intent intent) {
        return null;
    }
}
