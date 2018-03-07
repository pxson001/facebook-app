package com.facebook.groups.feed.data;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.feed.feedtype.AbstractFeedTypeDataItem;
import com.facebook.groups.feed.protocol.FetchGroupFeedMethod;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: faceweb/f?href=/pages/edit/admins/%s */
public class GroupsFeedOwnerAuthoredExpiredForSaleDataItem extends AbstractFeedTypeDataItem {
    @Inject
    public GroupsFeedOwnerAuthoredExpiredForSaleDataItem(Lazy<FetchGroupFeedMethod> lazy) {
        super(Name.s, lazy, false, false);
    }

    public final String m15617a(Intent intent, FeedType feedType) {
        return null;
    }

    public final FeedType m15616a(Intent intent) {
        return null;
    }
}
