package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNORDERED_LIST_ITEM */
public class GraphQLTemporalEventInfoSerializer extends JsonSerializer<GraphQLTemporalEventInfo> {
    public final void m22102a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTemporalEventInfo__JsonHelper.m22104a(jsonGenerator, (GraphQLTemporalEventInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTemporalEventInfo.class, new GraphQLTemporalEventInfoSerializer());
    }
}
