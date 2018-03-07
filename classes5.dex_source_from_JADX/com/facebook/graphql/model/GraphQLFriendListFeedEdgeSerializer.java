package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hc_friend_browser */
public class GraphQLFriendListFeedEdgeSerializer extends JsonSerializer<GraphQLFriendListFeedEdge> {
    public final void m7559a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFriendListFeedEdge__JsonHelper.m7561a(jsonGenerator, (GraphQLFriendListFeedEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFriendListFeedEdge.class, new GraphQLFriendListFeedEdgeSerializer());
    }
}
