package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: UI_EXPLORER */
public class GraphQLTopReactionsEdge$Builder extends Builder {
    @Nullable
    public GraphQLFeedbackReactionInfo f13357d;
    public int f13358e;

    public GraphQLTopReactionsEdge$Builder() {
        Preconditions.checkState(this instanceof GraphQLTopReactionsEdge$Builder);
    }

    public final GraphQLTopReactionsEdge m22252a() {
        return new GraphQLTopReactionsEdge(this);
    }
}
