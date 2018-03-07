package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: i-frame-interval */
public class GraphQLFaceBoxSerializer extends JsonSerializer<GraphQLFaceBox> {
    public final void m7435a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFaceBox__JsonHelper.m7453a(jsonGenerator, (GraphQLFaceBox) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFaceBox.class, new GraphQLFaceBoxSerializer());
    }
}
