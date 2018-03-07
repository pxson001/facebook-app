package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: isRetriable */
public class GraphQLConfigurationSerializer extends JsonSerializer<GraphQLConfiguration> {
    public final void m6858a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLConfiguration__JsonHelper.m6860a(jsonGenerator, (GraphQLConfiguration) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLConfiguration.class, new GraphQLConfigurationSerializer());
    }
}
