package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: focus */
public class GraphQLImageOverlay$Builder extends Builder {
    public ImmutableList<GraphQLProfile> f4280d;
    @Nullable
    public String f4281e;
    @Nullable
    public GraphQLImage f4282f;
    @Nullable
    public GraphQLObjectType f4283g = null;

    public GraphQLImageOverlay$Builder() {
        Preconditions.checkState(this instanceof GraphQLImageOverlay$Builder);
    }
}
