package com.facebook.groups.feed.data;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.feed.feedtype.AbstractFeedTypeDataItem;
import com.facebook.groups.feed.protocol.FetchGroupFeedMethod;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: faceweb/f?href=/help/pagesmanager/617442505033579 */
public class GroupsFeedPinnedDataItem extends AbstractFeedTypeDataItem {
    @Inject
    public GroupsFeedPinnedDataItem(Lazy<FetchGroupFeedMethod> lazy) {
        super(Name.v, lazy, false, false);
    }

    public final String m15629a(Intent intent, FeedType feedType) {
        return null;
    }

    public final FeedType m15628a(Intent intent) {
        return null;
    }
}
