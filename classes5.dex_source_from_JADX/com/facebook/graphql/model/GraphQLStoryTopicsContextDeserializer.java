package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_page_browser_invite */
public class GraphQLStoryTopicsContextDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStoryTopicsContext.class, new GraphQLStoryTopicsContextDeserializer());
    }

    public GraphQLStoryTopicsContextDeserializer() {
        a(GraphQLStoryTopicsContext.class);
    }

    public Object m21918a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLStoryTopicsContext__JsonHelper.m21920a(jsonParser);
    }
}
