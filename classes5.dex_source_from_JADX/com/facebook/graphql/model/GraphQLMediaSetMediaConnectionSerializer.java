package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: family */
public class GraphQLMediaSetMediaConnectionSerializer extends JsonSerializer<GraphQLMediaSetMediaConnection> {
    public final void m9072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMediaSetMediaConnection__JsonHelper.m9074a(jsonGenerator, (GraphQLMediaSetMediaConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLMediaSetMediaConnection.class, new GraphQLMediaSetMediaConnectionSerializer());
    }
}
