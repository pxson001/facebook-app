package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLRedSpaceVisibilityState;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;

/* compiled from: VIDEO_PLAY */
public class GraphQLRedSpaceStoryInfo$Builder extends Builder {
    public GraphQLRedSpaceVisibilityState f12910d = GraphQLRedSpaceVisibilityState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;

    public GraphQLRedSpaceStoryInfo$Builder() {
        Preconditions.checkState(this instanceof GraphQLRedSpaceStoryInfo$Builder);
    }

    public final GraphQLRedSpaceStoryInfo$Builder m21369a(GraphQLRedSpaceVisibilityState graphQLRedSpaceVisibilityState) {
        this.f12910d = graphQLRedSpaceVisibilityState;
        return this;
    }

    public final GraphQLRedSpaceStoryInfo m21370a() {
        return new GraphQLRedSpaceStoryInfo(this);
    }
}
