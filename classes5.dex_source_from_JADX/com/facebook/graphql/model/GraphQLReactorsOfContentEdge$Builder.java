package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: VIDEO_STORIES */
public class GraphQLReactorsOfContentEdge$Builder extends Builder {
    @Nullable
    public GraphQLFeedbackReactionInfo f12899d;
    @Nullable
    public GraphQLActor f12900e;

    public GraphQLReactorsOfContentEdge$Builder() {
        Preconditions.checkState(this instanceof GraphQLReactorsOfContentEdge$Builder);
    }

    public final GraphQLReactorsOfContentEdge m21347a() {
        return new GraphQLReactorsOfContentEdge(this);
    }
}
