package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: in_progress */
public class GraphQLEventMembersConnection$Builder extends Builder {
    public int f3647d;
    public ImmutableList<GraphQLEventMembersEdge> f3648e;
    public ImmutableList<GraphQLActor> f3649f;
    @Nullable
    public GraphQLPageInfo f3650g;
    public int f3651h;
    public int f3652i;

    public GraphQLEventMembersConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLEventMembersConnection$Builder);
    }

    public final GraphQLEventMembersConnection m7240a() {
        return new GraphQLEventMembersConnection(this);
    }
}
