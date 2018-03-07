package com.facebook.groups.feed.data;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.feed.feedtype.AbstractFeedTypeDataItem;
import com.facebook.groups.feed.protocol.FetchGroupFeedMethod;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: faceweb/f?href=/pages/create/?referrer=bookmark */
public class GroupsFeedOwnerAuthoredSoldForSaleDataItem extends AbstractFeedTypeDataItem {
    @Inject
    public GroupsFeedOwnerAuthoredSoldForSaleDataItem(Lazy<FetchGroupFeedMethod> lazy) {
        super(Name.r, lazy, false, false);
    }

    public final String m15619a(Intent intent, FeedType feedType) {
        return null;
    }

    public final FeedType m15618a(Intent intent) {
        return null;
    }
}
