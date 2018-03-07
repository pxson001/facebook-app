package com.facebook.messaging.inbox2.trendinggifs;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLResult;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: selection_rank */
public class TrendingGifInboxItem extends InboxUnitItem {
    public final ExternalMediaGraphQLResult f2968f;

    public TrendingGifInboxItem(NodesModel nodesModel, ExternalMediaGraphQLResult externalMediaGraphQLResult) {
        super(nodesModel);
        this.f2968f = externalMediaGraphQLResult;
    }

    protected final long m2962h() {
        return (long) m2957n().hashCode();
    }

    protected final String m2963j() {
        return this.d.j() + ":" + m2957n();
    }

    private String m2957n() {
        if (this.f2968f.e.u != null) {
            return this.f2968f.e.u;
        }
        if (this.f2968f.c != null) {
            return this.f2968f.c;
        }
        return Long.toString((long) this.f2968f.e.c.hashCode());
    }

    public final InboxItemType m2958a() {
        return InboxItemType.V2_TRENDING_GIF_ITEM;
    }

    public final InboxItemViewType m2959b() {
        return InboxItemViewType.V2_TRENDING_GIF_ITEM;
    }

    public final String m2960d() {
        return "tap_trending_gif_item";
    }

    public final boolean m2961e() {
        return false;
    }
}
