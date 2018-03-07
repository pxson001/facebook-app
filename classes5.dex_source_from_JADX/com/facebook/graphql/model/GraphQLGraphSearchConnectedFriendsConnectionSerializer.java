package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: getForegroundTime */
public class GraphQLGraphSearchConnectedFriendsConnectionSerializer extends JsonSerializer<GraphQLGraphSearchConnectedFriendsConnection> {
    public final void m8145a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGraphSearchConnectedFriendsConnection__JsonHelper.m8147a(jsonGenerator, (GraphQLGraphSearchConnectedFriendsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGraphSearchConnectedFriendsConnection.class, new GraphQLGraphSearchConnectedFriendsConnectionSerializer());
    }
}
