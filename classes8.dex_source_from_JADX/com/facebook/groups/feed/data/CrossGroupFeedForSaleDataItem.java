package com.facebook.groups.feed.data;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.feed.feedtype.AbstractFeedTypeDataItem;
import com.facebook.groups.feed.protocol.FetchGroupFeedMethod;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: faceweb/f?href=/pages_manager/help */
public class CrossGroupFeedForSaleDataItem extends AbstractFeedTypeDataItem {
    @Inject
    public CrossGroupFeedForSaleDataItem(Lazy<FetchGroupFeedMethod> lazy) {
        super(Name.p, lazy, false, false);
    }

    public final String m15593a(Intent intent, FeedType feedType) {
        return null;
    }

    public final FeedType m15592a(Intent intent) {
        return null;
    }
}
