package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: intern_match_manager_suggest_match */
public class GraphQLEntityAtRange$Builder extends Builder {
    @Nullable
    public GraphQLEntity f3530d;
    public int f3531e;
    public int f3532f;

    public GraphQLEntityAtRange$Builder() {
        Preconditions.checkState(this instanceof GraphQLEntityAtRange$Builder);
    }

    public final GraphQLEntityAtRange m7039a() {
        return new GraphQLEntityAtRange(this);
    }
}
