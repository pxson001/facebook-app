package com.facebook.groups.feed.data;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.feed.feedtype.AbstractFeedTypeDataItem;
import com.facebook.groups.feed.protocol.FetchGroupFeedMethod;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: faceweb/f?href=/pages/edit/general/%s */
public class GroupsFeedOwnerAuthoredAvailableForSaleDataItem extends AbstractFeedTypeDataItem {
    @Inject
    public GroupsFeedOwnerAuthoredAvailableForSaleDataItem(Lazy<FetchGroupFeedMethod> lazy) {
        super(Name.q, lazy, false, false);
    }

    public final String m15615a(Intent intent, FeedType feedType) {
        return null;
    }

    public final FeedType m15614a(Intent intent) {
        return null;
    }
}
