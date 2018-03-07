package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pinned_post */
public class GraphQLAttributionEntryDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAttributionEntry.class, new GraphQLAttributionEntryDeserializer());
    }

    public GraphQLAttributionEntryDeserializer() {
        a(GraphQLAttributionEntry.class);
    }

    public Object m6614a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLAttributionEntry__JsonHelper.m6616a(jsonParser);
    }
}
