package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: messenger_content_subscription_option */
public class GraphQLVideoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLVideo.class, new GraphQLVideoDeserializer());
    }

    public GraphQLVideoDeserializer() {
        a(GraphQLVideo.class);
    }

    public Object m22448a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLVideo__JsonHelper.m22483a(jsonParser);
    }
}
