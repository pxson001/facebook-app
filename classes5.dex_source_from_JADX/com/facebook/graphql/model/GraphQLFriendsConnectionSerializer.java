package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: has_media_fbids */
public class GraphQLFriendsConnectionSerializer extends JsonSerializer<GraphQLFriendsConnection> {
    public final void m7607a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFriendsConnection__JsonHelper.m7609a(jsonGenerator, (GraphQLFriendsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFriendsConnection.class, new GraphQLFriendsConnectionSerializer());
    }
}
