package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNKOWN */
public class GraphQLTimeRangeSerializer extends JsonSerializer<GraphQLTimeRange> {
    public final void m22113a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTimeRange__JsonHelper.m22115a(jsonGenerator, (GraphQLTimeRange) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTimeRange.class, new GraphQLTimeRangeSerializer());
    }
}
