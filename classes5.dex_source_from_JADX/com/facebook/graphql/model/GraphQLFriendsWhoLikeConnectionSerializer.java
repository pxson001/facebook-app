package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hasMediaFbIds */
public class GraphQLFriendsWhoLikeConnectionSerializer extends JsonSerializer<GraphQLFriendsWhoLikeConnection> {
    public final void m7640a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFriendsWhoLikeConnection__JsonHelper.m7642a(jsonGenerator, (GraphQLFriendsWhoLikeConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFriendsWhoLikeConnection.class, new GraphQLFriendsWhoLikeConnectionSerializer());
    }
}
