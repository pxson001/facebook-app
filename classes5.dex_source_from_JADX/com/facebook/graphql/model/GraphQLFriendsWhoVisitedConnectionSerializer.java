package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: handle */
public class GraphQLFriendsWhoVisitedConnectionSerializer extends JsonSerializer<GraphQLFriendsWhoVisitedConnection> {
    public final void m7646a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFriendsWhoVisitedConnection__JsonHelper.m7648a(jsonGenerator, (GraphQLFriendsWhoVisitedConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFriendsWhoVisitedConnection.class, new GraphQLFriendsWhoVisitedConnectionSerializer());
    }
}
