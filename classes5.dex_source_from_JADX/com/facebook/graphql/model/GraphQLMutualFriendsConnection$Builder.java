package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: facebookSignInOptions */
public class GraphQLMutualFriendsConnection$Builder extends Builder {
    public int f4521d;
    public ImmutableList<GraphQLUser> f4522e;
    @Nullable
    public GraphQLPageInfo f4523f;

    public GraphQLMutualFriendsConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLMutualFriendsConnection$Builder);
    }
}
