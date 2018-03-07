package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feed_touch_perf */
public class GraphQLLeadGenDataSerializer extends JsonSerializer<GraphQLLeadGenData> {
    public final void m8819a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLeadGenData__JsonHelper.m8821a(jsonGenerator, (GraphQLLeadGenData) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLLeadGenData.class, new GraphQLLeadGenDataSerializer());
    }
}
