package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: UNSET_OR_UNRECOGNIZED_ENUM_VALUE */
public class GraphQLTaggableActivityIcon$Builder extends Builder {
    @Nullable
    public String f13254d;
    @Nullable
    public String f13255e;
    @Nullable
    public GraphQLImage f13256f;
    @Nullable
    public GraphQLImage f13257g;
    @Nullable
    public GraphQLImage f13258h;
    @Nullable
    public GraphQLImage f13259i;
    @Nullable
    public String f13260j;

    public GraphQLTaggableActivityIcon$Builder() {
        Preconditions.checkState(this instanceof GraphQLTaggableActivityIcon$Builder);
    }

    public final GraphQLTaggableActivityIcon m22049a() {
        return new GraphQLTaggableActivityIcon(this);
    }
}
