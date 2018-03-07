package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VITAMIN_SUPPLEMENTS */
public class GraphQLProfileVideoSerializer extends JsonSerializer<GraphQLProfileVideo> {
    public final void m21110a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLProfileVideo__JsonHelper.m21112a(jsonGenerator, (GraphQLProfileVideo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLProfileVideo.class, new GraphQLProfileVideoSerializer());
    }
}
