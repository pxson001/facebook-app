package com.facebook.messaging.inbox2.data.common;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.EnumSet;

/* compiled from: setNavBarHidden */
public interface InboxUnitFetcher {
    ListenableFuture<InboxUnitResult> mo77a(InboxUnitParams inboxUnitParams);

    EnumSet<InboxUnitsToFetch> mo78a();

    void mo79a(NodesModel nodesModel);

    void mo80a(InboxUnitItem inboxUnitItem);

    boolean mo81b();
}
