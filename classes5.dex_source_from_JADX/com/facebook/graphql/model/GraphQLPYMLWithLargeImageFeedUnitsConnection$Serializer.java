package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPYMLWithLargeImageFeedUnitsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: error changing cursor and caching columns */
public final class GraphQLPYMLWithLargeImageFeedUnitsConnection$Serializer extends JsonSerializer<GraphQLPYMLWithLargeImageFeedUnitsConnection> {
    public final void m9449a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPYMLWithLargeImageFeedUnitsConnection graphQLPYMLWithLargeImageFeedUnitsConnection = (GraphQLPYMLWithLargeImageFeedUnitsConnection) obj;
        GraphQLPYMLWithLargeImageFeedUnitsConnectionDeserializer.m5488a(graphQLPYMLWithLargeImageFeedUnitsConnection.w_(), graphQLPYMLWithLargeImageFeedUnitsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPYMLWithLargeImageFeedUnitsConnection.class, new GraphQLPYMLWithLargeImageFeedUnitsConnection$Serializer());
        FbSerializerProvider.a(GraphQLPYMLWithLargeImageFeedUnitsConnection.class, new GraphQLPYMLWithLargeImageFeedUnitsConnection$Serializer());
    }
}
