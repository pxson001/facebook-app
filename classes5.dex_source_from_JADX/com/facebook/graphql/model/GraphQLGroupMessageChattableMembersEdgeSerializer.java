package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friend_browser_list */
public class GraphQLGroupMessageChattableMembersEdgeSerializer extends JsonSerializer<GraphQLGroupMessageChattableMembersEdge> {
    public final void m8483a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupMessageChattableMembersEdge__JsonHelper.m8485a(jsonGenerator, (GraphQLGroupMessageChattableMembersEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupMessageChattableMembersEdge.class, new GraphQLGroupMessageChattableMembersEdgeSerializer());
    }
}
