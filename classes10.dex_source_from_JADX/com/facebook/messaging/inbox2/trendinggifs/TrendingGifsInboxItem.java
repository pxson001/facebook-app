package com.facebook.messaging.inbox2.trendinggifs;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;

/* compiled from: selection_ids */
public class TrendingGifsInboxItem extends InboxUnitItem {
    public TrendingGifsInboxItem(NodesModel nodesModel) {
        super(nodesModel);
    }

    public final InboxItemType m2969a() {
        return InboxItemType.V2_TRENDING_GIFS;
    }

    public final InboxItemViewType m2970b() {
        return InboxItemViewType.V2_TRENDING_GIFS;
    }

    public final String m2971d() {
        return "tap_trending_gifs_unit";
    }

    public final boolean m2972e() {
        return false;
    }
}
