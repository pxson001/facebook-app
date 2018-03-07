package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: jewel_install_messenger_promo_fragment */
public class GraphQLAlbumsConnection$Builder extends Builder {
    public ImmutableList<GraphQLAlbum> f3343d;
    @Nullable
    public GraphQLPageInfo f3344e;

    public GraphQLAlbumsConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLAlbumsConnection$Builder);
    }

    public final GraphQLAlbumsConnection m6513a() {
        return new GraphQLAlbumsConnection(this);
    }
}
