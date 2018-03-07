package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hash_string */
public class GraphQLFriendLocationFeedUnitItemSerializer extends JsonSerializer<GraphQLFriendLocationFeedUnitItem> {
    public final void m7579a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFriendLocationFeedUnitItem__JsonHelper.m7581a(jsonGenerator, (GraphQLFriendLocationFeedUnitItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFriendLocationFeedUnitItem.class, new GraphQLFriendLocationFeedUnitItemSerializer());
    }
}
