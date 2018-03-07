package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: info_snippets */
public class GraphQLEventInviteesConnectionSerializer extends JsonSerializer<GraphQLEventInviteesConnection> {
    public final void m7205a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventInviteesConnection__JsonHelper.m7207a(jsonGenerator, (GraphQLEventInviteesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventInviteesConnection.class, new GraphQLEventInviteesConnectionSerializer());
    }
}
