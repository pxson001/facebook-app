package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pending_places_for_attachment */
public class GraphQLEntityAtRangeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEntityAtRange.class, new GraphQLEntityAtRangeDeserializer());
    }

    public GraphQLEntityAtRangeDeserializer() {
        a(GraphQLEntityAtRange.class);
    }

    public Object m7042a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEntityAtRange__JsonHelper.m7044a(jsonParser);
    }
}
