package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: min_sponsored_gap */
public class GraphQLTranslationMetaDataDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTranslationMetaData.class, new GraphQLTranslationMetaDataDeserializer());
    }

    public GraphQLTranslationMetaDataDeserializer() {
        a(GraphQLTranslationMetaData.class);
    }

    public Object m22282a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTranslationMetaData__JsonHelper.m22284a(jsonParser);
    }
}
