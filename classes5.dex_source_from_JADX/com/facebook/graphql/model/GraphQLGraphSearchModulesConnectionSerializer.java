package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: getCameraInstance failed */
public class GraphQLGraphSearchModulesConnectionSerializer extends JsonSerializer<GraphQLGraphSearchModulesConnection> {
    public final void m8170a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGraphSearchModulesConnection__JsonHelper.m8172a(jsonGenerator, (GraphQLGraphSearchModulesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGraphSearchModulesConnection.class, new GraphQLGraphSearchModulesConnectionSerializer());
    }
}
