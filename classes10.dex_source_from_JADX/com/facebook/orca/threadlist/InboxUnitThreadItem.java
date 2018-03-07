package com.facebook.orca.threadlist;

import com.facebook.inject.Assisted;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitItemsModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory;
import com.google.common.base.Charsets;
import com.google.common.hash.Hasher;
import javax.inject.Inject;

/* compiled from: ndt_delta_received */
public class InboxUnitThreadItem extends InboxUnitItem {
    private final MessengerThreadTileViewDataFactory f6490f;
    public final ThreadSummary f6491g;

    @Inject
    InboxUnitThreadItem(MessengerThreadTileViewDataFactory messengerThreadTileViewDataFactory, @Assisted NodesModel nodesModel, @Assisted MessengerInboxUnitItemsModel messengerInboxUnitItemsModel, @Assisted ThreadSummary threadSummary) {
        super(nodesModel, messengerInboxUnitItemsModel);
        this.f6490f = messengerThreadTileViewDataFactory;
        this.f6491g = threadSummary;
    }

    public final InboxItemType m6189a() {
        return InboxItemType.V2_THREAD;
    }

    public final InboxItemViewType m6190b() {
        return this.f6490f.b(this.f6491g) < 2 ? InboxItemViewType.THREAD_SINGLE : InboxItemViewType.THREAD_MULTI;
    }

    protected final long m6193h() {
        Hasher a = InboxUnitItem.a.a();
        a.a(this.d.j(), Charsets.UTF_8);
        ThreadKey threadKey = this.f6491g.a;
        long j = (((((threadKey.b * 63) + threadKey.d) * 63) + threadKey.e) * 63) + threadKey.c;
        if (threadKey.f != null) {
            j = (j * 63) + ((long) threadKey.f.hashCode());
        }
        a.a(j);
        return a.a().c();
    }

    protected final String m6194j() {
        if (this.e != null) {
            return this.e.j();
        }
        return this.d.j() + ":" + this.f6491g.a.i();
    }

    public final String m6191d() {
        return "tap_conversation_thread";
    }

    public final boolean m6192e() {
        return true;
    }
}
