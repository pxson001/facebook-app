package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNCONNECTED_STORY */
public class GraphQLTimezoneInfoSerializer extends JsonSerializer<GraphQLTimezoneInfo> {
    public final void m22237a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTimezoneInfo__JsonHelper.m22239a(jsonGenerator, (GraphQLTimezoneInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTimezoneInfo.class, new GraphQLTimezoneInfoSerializer());
    }
}
