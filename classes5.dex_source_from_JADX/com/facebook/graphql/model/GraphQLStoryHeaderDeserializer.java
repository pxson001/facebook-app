package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_ppd_tool */
public class GraphQLStoryHeaderDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStoryHeader.class, new GraphQLStoryHeaderDeserializer());
    }

    public GraphQLStoryHeaderDeserializer() {
        a(GraphQLStoryHeader.class);
    }

    public Object m21873a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLStoryHeader__JsonHelper.a(jsonParser);
    }
}
