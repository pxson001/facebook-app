package com.facebook.orca.threadlist;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.facebook.messaging.montage.inboxcomposer.MontageInboxComposerData;
import javax.annotation.Nullable;

/* compiled from: ndt_no_thread_key */
public class InboxUnitMontageComposerItem extends InboxUnitItem {
    @Nullable
    public final MontageInboxComposerData f6488f;

    public InboxUnitMontageComposerItem(NodesModel nodesModel, @Nullable MontageInboxComposerData montageInboxComposerData) {
        super(nodesModel);
        this.f6488f = montageInboxComposerData;
    }

    public final InboxItemType m6181a() {
        return InboxItemType.V2_MONTAGE_COMPOSER_HEADER;
    }

    public final InboxItemViewType m6182b() {
        return InboxItemViewType.V2_MONTAGE_COMPOSER_HEADER;
    }

    public final String m6183d() {
        return "tap_montage_composer";
    }

    public final boolean m6184e() {
        return true;
    }
}
