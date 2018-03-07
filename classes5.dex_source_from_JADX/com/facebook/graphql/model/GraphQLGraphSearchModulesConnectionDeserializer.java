package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_after_party_card */
public class GraphQLGraphSearchModulesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchModulesConnection.class, new GraphQLGraphSearchModulesConnectionDeserializer());
    }

    public GraphQLGraphSearchModulesConnectionDeserializer() {
        a(GraphQLGraphSearchModulesConnection.class);
    }

    public Object m8169a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGraphSearchModulesConnection__JsonHelper.m8171a(jsonParser);
    }
}
