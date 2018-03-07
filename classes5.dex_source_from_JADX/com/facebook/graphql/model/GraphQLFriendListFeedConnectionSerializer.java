package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hc_profile_browser */
public class GraphQLFriendListFeedConnectionSerializer extends JsonSerializer<GraphQLFriendListFeedConnection> {
    public final void m7548a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFriendListFeedConnection__JsonHelper.m7550a(jsonGenerator, (GraphQLFriendListFeedConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFriendListFeedConnection.class, new GraphQLFriendListFeedConnectionSerializer());
    }
}
