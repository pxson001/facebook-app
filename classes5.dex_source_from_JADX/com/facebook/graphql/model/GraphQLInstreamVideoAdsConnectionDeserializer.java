package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: option_text */
public class GraphQLInstreamVideoAdsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInstreamVideoAdsConnection.class, new GraphQLInstreamVideoAdsConnectionDeserializer());
    }

    public GraphQLInstreamVideoAdsConnectionDeserializer() {
        a(GraphQLInstreamVideoAdsConnection.class);
    }

    public Object m8737a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLInstreamVideoAdsConnection__JsonHelper.m8739a(jsonParser);
    }
}
