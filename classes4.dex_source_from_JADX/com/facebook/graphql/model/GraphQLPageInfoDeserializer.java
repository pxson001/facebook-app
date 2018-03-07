package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: has_viewer_posted_for_birthday */
public class GraphQLPageInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageInfo.class, new GraphQLPageInfoDeserializer());
    }

    public GraphQLPageInfoDeserializer() {
        a(GraphQLPageInfo.class);
    }

    public Object m11278a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPageInfo__JsonHelper.m11279a(jsonParser);
    }
}
