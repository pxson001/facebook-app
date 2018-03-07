package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: placeTag */
public class GraphQLAppStoreApplicationDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAppStoreApplication.class, new GraphQLAppStoreApplicationDeserializer());
    }

    public GraphQLAppStoreApplicationDeserializer() {
        a(GraphQLAppStoreApplication.class);
    }

    public Object m6572a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLAppStoreApplication__JsonHelper.m6574a(jsonParser);
    }
}
