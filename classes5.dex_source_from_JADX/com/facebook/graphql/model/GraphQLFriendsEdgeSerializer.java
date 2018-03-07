package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: has_link_menus */
public class GraphQLFriendsEdgeSerializer extends JsonSerializer<GraphQLFriendsEdge> {
    public final void m7618a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFriendsEdge__JsonHelper.m7620a(jsonGenerator, (GraphQLFriendsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFriendsEdge.class, new GraphQLFriendsEdgeSerializer());
    }
}
