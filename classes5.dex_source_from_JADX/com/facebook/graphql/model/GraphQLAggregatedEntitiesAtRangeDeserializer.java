package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_list_items */
public class GraphQLAggregatedEntitiesAtRangeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAggregatedEntitiesAtRange.class, new GraphQLAggregatedEntitiesAtRangeDeserializer());
    }

    public GraphQLAggregatedEntitiesAtRangeDeserializer() {
        a(GraphQLAggregatedEntitiesAtRange.class);
    }

    public Object m6500a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLAggregatedEntitiesAtRange__JsonHelper.m6502a(jsonParser);
    }
}
