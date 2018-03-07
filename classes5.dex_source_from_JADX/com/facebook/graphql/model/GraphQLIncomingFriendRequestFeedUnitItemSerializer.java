package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fixed */
public class GraphQLIncomingFriendRequestFeedUnitItemSerializer extends JsonSerializer<GraphQLIncomingFriendRequestFeedUnitItem> {
    public final void m8669a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLIncomingFriendRequestFeedUnitItem__JsonHelper.m8671a(jsonGenerator, (GraphQLIncomingFriendRequestFeedUnitItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLIncomingFriendRequestFeedUnitItem.class, new GraphQLIncomingFriendRequestFeedUnitItemSerializer());
    }
}
