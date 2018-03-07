package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: has_viewer_saved */
public class GraphQLFriendingPossibilitiesConnectionSerializer extends JsonSerializer<GraphQLFriendingPossibilitiesConnection> {
    public final void m7586a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFriendingPossibilitiesConnection__JsonHelper.m7588a(jsonGenerator, (GraphQLFriendingPossibilitiesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFriendingPossibilitiesConnection.class, new GraphQLFriendingPossibilitiesConnectionSerializer());
    }
}
