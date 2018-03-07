package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: gysj */
public class GraphQLFriendsWhoVisitedEdgeSerializer extends JsonSerializer<GraphQLFriendsWhoVisitedEdge> {
    public final void m7655a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFriendsWhoVisitedEdge__JsonHelper.m7657a(jsonGenerator, (GraphQLFriendsWhoVisitedEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFriendsWhoVisitedEdge.class, new GraphQLFriendsWhoVisitedEdgeSerializer());
    }
}
