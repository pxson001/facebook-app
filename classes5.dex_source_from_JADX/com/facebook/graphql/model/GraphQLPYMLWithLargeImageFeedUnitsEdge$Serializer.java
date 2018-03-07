package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPYMLWithLargeImageFeedUnitsEdgeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: entry_point_description */
public final class GraphQLPYMLWithLargeImageFeedUnitsEdge$Serializer extends JsonSerializer<GraphQLPYMLWithLargeImageFeedUnitsEdge> {
    public final void m9455a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPYMLWithLargeImageFeedUnitsEdge graphQLPYMLWithLargeImageFeedUnitsEdge = (GraphQLPYMLWithLargeImageFeedUnitsEdge) obj;
        GraphQLPYMLWithLargeImageFeedUnitsEdgeDeserializer.m5491b(graphQLPYMLWithLargeImageFeedUnitsEdge.w_(), graphQLPYMLWithLargeImageFeedUnitsEdge.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPYMLWithLargeImageFeedUnitsEdge.class, new GraphQLPYMLWithLargeImageFeedUnitsEdge$Serializer());
        FbSerializerProvider.a(GraphQLPYMLWithLargeImageFeedUnitsEdge.class, new GraphQLPYMLWithLargeImageFeedUnitsEdge$Serializer());
    }
}
