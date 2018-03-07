package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friends_clusters */
public class GraphQLGroupConfigurationsConnectionSerializer extends JsonSerializer<GraphQLGroupConfigurationsConnection> {
    public final void m8397a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupConfigurationsConnection__JsonHelper.m8399a(jsonGenerator, (GraphQLGroupConfigurationsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupConfigurationsConnection.class, new GraphQLGroupConfigurationsConnectionSerializer());
    }
}
