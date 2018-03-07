package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: fire_review_after_snap */
public class GraphQLInlineActivity$Builder extends Builder {
    @Nullable
    public String f4307d;
    @Nullable
    public GraphQLNode f4308e;
    @Nullable
    public GraphQLTaggableActivity f4309f;
    @Nullable
    public GraphQLTaggableActivityIcon f4310g;
    @Nullable
    public String f4311h;

    public GraphQLInlineActivity$Builder() {
        Preconditions.checkState(this instanceof GraphQLInlineActivity$Builder);
    }

    public final GraphQLInlineActivity m8691a() {
        return new GraphQLInlineActivity(this);
    }
}
