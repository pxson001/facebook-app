package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_ios_composer_edit */
public class GraphQLSubstoriesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSubstoriesConnection.class, new GraphQLSubstoriesConnectionDeserializer());
    }

    public GraphQLSubstoriesConnectionDeserializer() {
        a(GraphQLSubstoriesConnection.class);
    }

    public Object m22005a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSubstoriesConnection__JsonHelper.m22007a(jsonParser);
    }
}
