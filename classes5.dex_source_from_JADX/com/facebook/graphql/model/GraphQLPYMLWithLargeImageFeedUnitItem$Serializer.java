package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPYMLWithLargeImageFeedUnitItemDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: error_codes */
public final class GraphQLPYMLWithLargeImageFeedUnitItem$Serializer extends JsonSerializer<GraphQLPYMLWithLargeImageFeedUnitItem> {
    public final void m9441a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPYMLWithLargeImageFeedUnitItem graphQLPYMLWithLargeImageFeedUnitItem = (GraphQLPYMLWithLargeImageFeedUnitItem) obj;
        GraphQLPYMLWithLargeImageFeedUnitItemDeserializer.m5485b(graphQLPYMLWithLargeImageFeedUnitItem.w_(), graphQLPYMLWithLargeImageFeedUnitItem.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPYMLWithLargeImageFeedUnitItem.class, new GraphQLPYMLWithLargeImageFeedUnitItem$Serializer());
        FbSerializerProvider.a(GraphQLPYMLWithLargeImageFeedUnitItem.class, new GraphQLPYMLWithLargeImageFeedUnitItem$Serializer());
    }
}
