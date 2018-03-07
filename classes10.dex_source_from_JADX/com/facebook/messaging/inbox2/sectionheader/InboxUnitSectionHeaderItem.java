package com.facebook.messaging.inbox2.sectionheader;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.facebook.messaging.inbox2.items.InboxUnitItem.SpecialItemType;

/* compiled from: selection_type */
public class InboxUnitSectionHeaderItem extends InboxUnitItem {
    public final String f2965f;
    public final int f2966g;
    public final boolean f2967h;

    public InboxUnitSectionHeaderItem(NodesModel nodesModel) {
        this(nodesModel, -1, false);
    }

    public InboxUnitSectionHeaderItem(NodesModel nodesModel, int i, boolean z) {
        super(nodesModel, SpecialItemType.SECTION_HEADER);
        this.f2965f = nodesModel.q().a();
        this.f2966g = i;
        this.f2967h = z;
    }

    public final InboxItemType m2953a() {
        return InboxItemType.V2_SECTION_HEADER;
    }

    public final InboxItemViewType m2954b() {
        return InboxItemViewType.V2_SECTION_HEADER;
    }

    public final String m2955d() {
        return null;
    }

    public final boolean m2956e() {
        return false;
    }
}
