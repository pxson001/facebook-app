package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: failed to crop photo to file */
public class GraphQLMegaphoneSerializer extends JsonSerializer<GraphQLMegaphone> {
    public final void m9104a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMegaphone__JsonHelper.m9106a(jsonGenerator, (GraphQLMegaphone) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLMegaphone.class, new GraphQLMegaphoneSerializer());
    }
}
