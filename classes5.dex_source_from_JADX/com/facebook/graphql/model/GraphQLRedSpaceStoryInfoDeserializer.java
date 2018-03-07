package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: native_app_url_segue */
public class GraphQLRedSpaceStoryInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLRedSpaceStoryInfo.class, new GraphQLRedSpaceStoryInfoDeserializer());
    }

    public GraphQLRedSpaceStoryInfoDeserializer() {
        a(GraphQLRedSpaceStoryInfo.class);
    }

    public Object m21373a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLRedSpaceStoryInfo__JsonHelper.m21375a(jsonParser);
    }
}
