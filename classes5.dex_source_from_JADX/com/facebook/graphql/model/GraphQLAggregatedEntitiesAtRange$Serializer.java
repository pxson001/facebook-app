package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLAggregatedEntitiesAtRangeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: journal.tmp */
public final class GraphQLAggregatedEntitiesAtRange$Serializer extends JsonSerializer<GraphQLAggregatedEntitiesAtRange> {
    public final void m6499a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAggregatedEntitiesAtRange graphQLAggregatedEntitiesAtRange = (GraphQLAggregatedEntitiesAtRange) obj;
        GraphQLAggregatedEntitiesAtRangeDeserializer.m4548b(graphQLAggregatedEntitiesAtRange.w_(), graphQLAggregatedEntitiesAtRange.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLAggregatedEntitiesAtRange.class, new GraphQLAggregatedEntitiesAtRange$Serializer());
        FbSerializerProvider.a(GraphQLAggregatedEntitiesAtRange.class, new GraphQLAggregatedEntitiesAtRange$Serializer());
    }
}
