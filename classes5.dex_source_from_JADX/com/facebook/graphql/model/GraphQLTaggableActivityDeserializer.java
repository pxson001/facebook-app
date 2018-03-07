package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_game_uri */
public class GraphQLTaggableActivityDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTaggableActivity.class, new GraphQLTaggableActivityDeserializer());
    }

    public GraphQLTaggableActivityDeserializer() {
        a(GraphQLTaggableActivity.class);
    }

    public Object m22048a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTaggableActivity__JsonHelper.m22082a(jsonParser);
    }
}
