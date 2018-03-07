package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place */
public class GraphQLApproximateCountDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLApproximateCount.class, new GraphQLApproximateCountDeserializer());
    }

    public GraphQLApproximateCountDeserializer() {
        a(GraphQLApproximateCount.class);
    }

    public Object m6597a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLApproximateCount__JsonHelper.m6599a(jsonParser);
    }
}
