package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_entities */
public class GraphQLAndroidAppConfigDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAndroidAppConfig.class, new GraphQLAndroidAppConfigDeserializer());
    }

    public GraphQLAndroidAppConfigDeserializer() {
        a(GraphQLAndroidAppConfig.class);
    }

    public Object m6538a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLAndroidAppConfig__JsonHelper.m6540a(jsonParser);
    }
}
