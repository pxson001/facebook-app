package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPYMLWithLargeImageFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: error_for_logging */
public final class GraphQLPYMLWithLargeImageFeedUnit$Serializer extends JsonSerializer<GraphQLPYMLWithLargeImageFeedUnit> {
    public final void m9438a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPYMLWithLargeImageFeedUnit graphQLPYMLWithLargeImageFeedUnit = (GraphQLPYMLWithLargeImageFeedUnit) obj;
        GraphQLPYMLWithLargeImageFeedUnitDeserializer.m5481a(graphQLPYMLWithLargeImageFeedUnit.w_(), graphQLPYMLWithLargeImageFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPYMLWithLargeImageFeedUnit.class, new GraphQLPYMLWithLargeImageFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLPYMLWithLargeImageFeedUnit.class, new GraphQLPYMLWithLargeImageFeedUnit$Serializer());
    }
}
