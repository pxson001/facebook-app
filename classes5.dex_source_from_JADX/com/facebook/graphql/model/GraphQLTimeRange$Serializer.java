package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTimeRangeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNLABELED_LINE_CHART */
public final class GraphQLTimeRange$Serializer extends JsonSerializer<GraphQLTimeRange> {
    public final void m22111a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTimeRange graphQLTimeRange = (GraphQLTimeRange) obj;
        GraphQLTimeRangeDeserializer.m6063a(graphQLTimeRange.w_(), graphQLTimeRange.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLTimeRange.class, new GraphQLTimeRange$Serializer());
        FbSerializerProvider.a(GraphQLTimeRange.class, new GraphQLTimeRange$Serializer());
    }
}
