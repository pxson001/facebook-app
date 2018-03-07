package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: USE_APP */
public class GraphQLStorySetItemSerializer extends JsonSerializer<GraphQLStorySetItem> {
    public final void m21902a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStorySetItem__JsonHelper.m21904a(jsonGenerator, (GraphQLStorySetItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLStorySetItem.class, new GraphQLStorySetItemSerializer());
    }
}
