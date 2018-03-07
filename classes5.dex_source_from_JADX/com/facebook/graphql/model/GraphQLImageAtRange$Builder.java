package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: follow_up_action_text */
public class GraphQLImageAtRange$Builder extends Builder {
    @Nullable
    public GraphQLEntityWithImage f4277d;
    public int f4278e;
    public int f4279f;

    public GraphQLImageAtRange$Builder() {
        Preconditions.checkState(this instanceof GraphQLImageAtRange$Builder);
    }

    public final GraphQLImageAtRange m8617a() {
        return new GraphQLImageAtRange(this);
    }
}
