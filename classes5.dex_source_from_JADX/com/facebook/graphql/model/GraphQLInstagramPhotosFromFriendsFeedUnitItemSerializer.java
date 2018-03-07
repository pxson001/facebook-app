package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fileName */
public class GraphQLInstagramPhotosFromFriendsFeedUnitItemSerializer extends JsonSerializer<GraphQLInstagramPhotosFromFriendsFeedUnitItem> {
    public final void m8717a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInstagramPhotosFromFriendsFeedUnitItem__JsonHelper.m8719a(jsonGenerator, (GraphQLInstagramPhotosFromFriendsFeedUnitItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLInstagramPhotosFromFriendsFeedUnitItem.class, new GraphQLInstagramPhotosFromFriendsFeedUnitItemSerializer());
    }
}
