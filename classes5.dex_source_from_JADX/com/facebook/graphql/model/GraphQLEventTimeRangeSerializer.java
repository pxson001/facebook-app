package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: image_margin */
public class GraphQLEventTimeRangeSerializer extends JsonSerializer<GraphQLEventTimeRange> {
    public final void m7302a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventTimeRange__JsonHelper.m7304a(jsonGenerator, (GraphQLEventTimeRange) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventTimeRange.class, new GraphQLEventTimeRangeSerializer());
    }
}
