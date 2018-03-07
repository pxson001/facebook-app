package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: options_menu */
public class GraphQLInstagramPhotosFromFriendsFeedUnitItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInstagramPhotosFromFriendsFeedUnitItem.class, new GraphQLInstagramPhotosFromFriendsFeedUnitItemDeserializer());
    }

    public GraphQLInstagramPhotosFromFriendsFeedUnitItemDeserializer() {
        a(GraphQLInstagramPhotosFromFriendsFeedUnitItem.class);
    }

    public Object m8716a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLInstagramPhotosFromFriendsFeedUnitItem__JsonHelper.m8718a(jsonParser);
    }
}
