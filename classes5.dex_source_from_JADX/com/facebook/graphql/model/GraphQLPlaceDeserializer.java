package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: new_pin */
public class GraphQLPlaceDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPlace.class, new GraphQLPlaceDeserializer());
    }

    public GraphQLPlaceDeserializer() {
        a(GraphQLPlace.class);
    }

    public Object m20836a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPlace__JsonHelper.m20921a(jsonParser);
    }
}
