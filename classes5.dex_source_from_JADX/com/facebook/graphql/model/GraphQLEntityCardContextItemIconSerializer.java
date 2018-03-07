package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: intermediate_image */
public class GraphQLEntityCardContextItemIconSerializer extends JsonSerializer<GraphQLEntityCardContextItemIcon> {
    public final void m7067a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEntityCardContextItemIcon__JsonHelper.m7069a(jsonGenerator, (GraphQLEntityCardContextItemIcon) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEntityCardContextItemIcon.class, new GraphQLEntityCardContextItemIconSerializer());
    }
}
