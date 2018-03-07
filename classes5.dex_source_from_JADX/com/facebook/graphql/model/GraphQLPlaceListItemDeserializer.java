package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: new_item_default_privacy */
public class GraphQLPlaceListItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPlaceListItem.class, new GraphQLPlaceListItemDeserializer());
    }

    public GraphQLPlaceListItemDeserializer() {
        a(GraphQLPlaceListItem.class);
    }

    public Object m20860a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPlaceListItem__JsonHelper.m20872a(jsonParser);
    }
}
