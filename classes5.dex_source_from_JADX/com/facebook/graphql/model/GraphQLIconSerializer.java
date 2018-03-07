package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: follow_up_title */
public class GraphQLIconSerializer extends JsonSerializer<GraphQLIcon> {
    public final void m8612a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLIcon__JsonHelper.m8614a(jsonGenerator, (GraphQLIcon) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLIcon.class, new GraphQLIconSerializer());
    }
}
