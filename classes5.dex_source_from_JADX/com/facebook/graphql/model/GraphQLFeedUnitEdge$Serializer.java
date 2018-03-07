package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFeedUnitEdgeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hookRun */
public final class GraphQLFeedUnitEdge$Serializer extends JsonSerializer<GraphQLFeedUnitEdge> {
    public final void m7468a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) obj;
        GraphQLFeedUnitEdgeDeserializer.m4888b(graphQLFeedUnitEdge.w_(), graphQLFeedUnitEdge.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFeedUnitEdge.class, new GraphQLFeedUnitEdge$Serializer());
        FbSerializerProvider.a(GraphQLFeedUnitEdge.class, new GraphQLFeedUnitEdge$Serializer());
    }
}
