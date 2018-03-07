package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: UNKNOWN_ERR */
public class GraphQLTimelineAppCollectionMembershipStateInfo$Builder extends Builder {
    @Nullable
    public String f13325d;
    @Nullable
    public GraphQLTextWithEntities f13326e;

    public GraphQLTimelineAppCollectionMembershipStateInfo$Builder() {
        Preconditions.checkState(this instanceof GraphQLTimelineAppCollectionMembershipStateInfo$Builder);
    }

    public final GraphQLTimelineAppCollectionMembershipStateInfo m22152a() {
        return new GraphQLTimelineAppCollectionMembershipStateInfo(this);
    }
}
