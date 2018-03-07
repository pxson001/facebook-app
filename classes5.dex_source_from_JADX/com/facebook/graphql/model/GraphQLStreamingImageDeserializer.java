package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_page_browser */
public class GraphQLStreamingImageDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStreamingImage.class, new GraphQLStreamingImageDeserializer());
    }

    public GraphQLStreamingImageDeserializer() {
        a(GraphQLStreamingImage.class);
    }

    public Object m21927a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLStreamingImage__JsonHelper.m21929a(jsonParser);
    }
}
