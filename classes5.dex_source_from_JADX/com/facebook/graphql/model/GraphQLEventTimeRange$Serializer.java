package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEventTimeRangeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: image_overlays */
public final class GraphQLEventTimeRange$Serializer extends JsonSerializer<GraphQLEventTimeRange> {
    public final void m7300a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventTimeRange graphQLEventTimeRange = (GraphQLEventTimeRange) obj;
        GraphQLEventTimeRangeDeserializer.m4835a(graphQLEventTimeRange.w_(), graphQLEventTimeRange.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLEventTimeRange.class, new GraphQLEventTimeRange$Serializer());
        FbSerializerProvider.a(GraphQLEventTimeRange.class, new GraphQLEventTimeRange$Serializer());
    }
}
