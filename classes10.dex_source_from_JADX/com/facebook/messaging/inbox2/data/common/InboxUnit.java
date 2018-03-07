package com.facebook.messaging.inbox2.data.common;

import com.facebook.graphql.enums.GraphQLMessengerInboxUnitType;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: setPhotoOperation */
public class InboxUnit<T> {
    public final GraphQLMessengerInboxUnitType f2734a;
    public final NodesModel f2735b;
    @Nullable
    public final T f2736c;

    public InboxUnit(NodesModel nodesModel) {
        this(nodesModel, null);
    }

    public InboxUnit(NodesModel nodesModel, T t) {
        Preconditions.checkNotNull(nodesModel);
        this.f2734a = nodesModel.r();
        this.f2735b = nodesModel;
        this.f2736c = t;
    }
}
