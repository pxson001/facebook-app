package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: hd_playable_url */
public class GraphQLFocusedPhoto$Builder extends Builder {
    @Nullable
    public GraphQLVect2 f3772d;
    @Nullable
    public GraphQLPhoto f3773e;

    public GraphQLFocusedPhoto$Builder() {
        Preconditions.checkState(this instanceof GraphQLFocusedPhoto$Builder);
    }

    public final GraphQLFocusedPhoto m7521a() {
        return new GraphQLFocusedPhoto(this);
    }
}
