package com.facebook.orca.threadlist;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitItemsModel;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory;

/* compiled from: navbar */
public class InboxUnitThreadItemProvider extends AbstractAssistedProvider<InboxUnitThreadItem> {
    public final InboxUnitThreadItem m6195a(NodesModel nodesModel, MessengerInboxUnitItemsModel messengerInboxUnitItemsModel, ThreadSummary threadSummary) {
        return new InboxUnitThreadItem(MessengerThreadTileViewDataFactory.a(this), nodesModel, messengerInboxUnitItemsModel, threadSummary);
    }
}
