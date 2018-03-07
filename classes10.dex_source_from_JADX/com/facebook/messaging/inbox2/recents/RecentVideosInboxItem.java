package com.facebook.messaging.inbox2.recents;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.google.common.collect.ImmutableList;

/* compiled from: selfupdate_click_not_now */
public class RecentVideosInboxItem extends InboxUnitItem implements InboxRecentItemsData {
    private final ImmutableList<RecentVideoInboxItem> f2959f;

    public RecentVideosInboxItem(NodesModel nodesModel, ImmutableList<RecentVideoInboxItem> immutableList) {
        super(nodesModel);
        this.f2959f = immutableList;
    }

    public final InboxItemType m2943a() {
        return InboxItemType.V2_RECENT_VIDEOS;
    }

    public final InboxItemViewType m2944b() {
        return InboxItemViewType.V2_RECENT_ITEMS;
    }

    public final String m2945d() {
        return "tap_recent_videos";
    }

    public final ImmutableList<RecentVideoInboxItem> mf_() {
        return this.f2959f;
    }

    public final boolean m2946e() {
        return false;
    }
}
