package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photos_at_page */
public class GraphQLCelebrationsFeedUnitItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCelebrationsFeedUnitItem.class, new GraphQLCelebrationsFeedUnitItemDeserializer());
    }

    public GraphQLCelebrationsFeedUnitItemDeserializer() {
        a(GraphQLCelebrationsFeedUnitItem.class);
    }

    public Object m6753a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLCelebrationsFeedUnitItem__JsonHelper.m6755a(jsonParser);
    }
}
