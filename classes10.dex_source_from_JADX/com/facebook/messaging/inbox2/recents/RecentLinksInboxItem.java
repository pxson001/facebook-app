package com.facebook.messaging.inbox2.recents;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.google.common.collect.ImmutableList;

/* compiled from: selfupdate_get_response_queue_download_from_oxygen */
public class RecentLinksInboxItem extends InboxUnitItem implements InboxRecentItemsData {
    private final ImmutableList<RecentLinkInboxItem> f2947f;

    public RecentLinksInboxItem(NodesModel nodesModel, ImmutableList<RecentLinkInboxItem> immutableList) {
        super(nodesModel);
        this.f2947f = immutableList;
    }

    public final InboxItemType m2931a() {
        return InboxItemType.V2_RECENT_LINKS;
    }

    public final InboxItemViewType m2932b() {
        return InboxItemViewType.V2_RECENT_ITEMS;
    }

    public final String m2933d() {
        return "tap_recent_links";
    }

    public final ImmutableList<RecentLinkInboxItem> mf_() {
        return this.f2947f;
    }

    public final boolean m2934e() {
        return false;
    }
}
