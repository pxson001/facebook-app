package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_ios */
public class GraphQLSuggestedContentConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSuggestedContentConnection.class, new GraphQLSuggestedContentConnectionDeserializer());
    }

    public GraphQLSuggestedContentConnectionDeserializer() {
        a(GraphQLSuggestedContentConnection.class);
    }

    public Object m22015a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSuggestedContentConnection__JsonHelper.m22017a(jsonParser);
    }
}
