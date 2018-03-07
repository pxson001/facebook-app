package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: has_stickers */
public class GraphQLFriendingPossibilitiesEdgeSerializer extends JsonSerializer<GraphQLFriendingPossibilitiesEdge> {
    public final void m7600a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFriendingPossibilitiesEdge__JsonHelper.m7602a(jsonGenerator, (GraphQLFriendingPossibilitiesEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFriendingPossibilitiesEdge.class, new GraphQLFriendingPossibilitiesEdgeSerializer());
    }
}
