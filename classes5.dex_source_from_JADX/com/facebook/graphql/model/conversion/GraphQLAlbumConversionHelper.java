package com.facebook.graphql.model.conversion;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntity.Builder;
import javax.annotation.Nullable;

/* compiled from: TURKISH_RESTAURANT */
public final class GraphQLAlbumConversionHelper {
    @Nullable
    public static GraphQLEntity m22601a(GraphQLAlbum graphQLAlbum) {
        Builder builder = new Builder();
        builder.m = graphQLAlbum.u();
        builder.t = graphQLAlbum.y();
        builder.u = graphQLAlbum.A();
        builder.P = graphQLAlbum.G();
        builder.S = new GraphQLObjectType(63344207);
        return builder.a();
    }
}
