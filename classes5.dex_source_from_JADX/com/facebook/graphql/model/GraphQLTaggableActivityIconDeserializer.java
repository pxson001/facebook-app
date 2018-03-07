package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_feed_zero_state */
public class GraphQLTaggableActivityIconDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTaggableActivityIcon.class, new GraphQLTaggableActivityIconDeserializer());
    }

    public GraphQLTaggableActivityIconDeserializer() {
        a(GraphQLTaggableActivityIcon.class);
    }

    public Object m22052a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTaggableActivityIcon__JsonHelper.m22054a(jsonParser);
    }
}
