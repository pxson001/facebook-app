package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: instant_game_id */
public class GraphQLEntityWithImage$Builder extends Builder {
    @Nullable
    public String f3549d;
    @Nullable
    public GraphQLImage f3550e;
    @Nullable
    public GraphQLObjectType f3551f = null;

    public GraphQLEntityWithImage$Builder() {
        Preconditions.checkState(this instanceof GraphQLEntityWithImage$Builder);
    }

    public final GraphQLEntityWithImage m7095a() {
        return new GraphQLEntityWithImage(this);
    }
}
