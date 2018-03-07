package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: inProgressLabel */
public class GraphQLEventMembersConnectionSerializer extends JsonSerializer<GraphQLEventMembersConnection> {
    public final void m7244a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventMembersConnection__JsonHelper.m7246a(jsonGenerator, (GraphQLEventMembersConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventMembersConnection.class, new GraphQLEventMembersConnectionSerializer());
    }
}
