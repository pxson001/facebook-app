package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_places_editor_review_module */
public class GraphQLStorySetItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStorySetItem.class, new GraphQLStorySetItemDeserializer());
    }

    public GraphQLStorySetItemDeserializer() {
        a(GraphQLStorySetItem.class);
    }

    public Object m21901a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLStorySetItem__JsonHelper.m21903a(jsonParser);
    }
}
