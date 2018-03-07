package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: placeAttachmentRemoved */
public class GraphQLApplicationDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLApplication.class, new GraphQLApplicationDeserializer());
    }

    public GraphQLApplicationDeserializer() {
        a(GraphQLApplication.class);
    }

    public Object m6585a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLApplication__JsonHelper.m6587a(jsonParser);
    }
}
