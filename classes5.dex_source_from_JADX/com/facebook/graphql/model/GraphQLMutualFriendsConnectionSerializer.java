package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: facebook.com */
public class GraphQLMutualFriendsConnectionSerializer extends JsonSerializer<GraphQLMutualFriendsConnection> {
    public final void m9145a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMutualFriendsConnection__JsonHelper.m9147a(jsonGenerator, (GraphQLMutualFriendsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLMutualFriendsConnection.class, new GraphQLMutualFriendsConnectionSerializer());
    }
}
