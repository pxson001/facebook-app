package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WEB_DESIGN */
public class GraphQLPlaceFlowInfoSerializer extends JsonSerializer<GraphQLPlaceFlowInfo> {
    public final void m20846a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPlaceFlowInfo__JsonHelper.m20848a(jsonGenerator, (GraphQLPlaceFlowInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPlaceFlowInfo.class, new GraphQLPlaceFlowInfoSerializer());
    }
}
