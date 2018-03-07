package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: option_value */
public class GraphQLInstantArticleVersionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInstantArticleVersion.class, new GraphQLInstantArticleVersionDeserializer());
    }

    public GraphQLInstantArticleVersionDeserializer() {
        a(GraphQLInstantArticleVersion.class);
    }

    public Object m8728a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLInstantArticleVersion__JsonHelper.m8730a(jsonParser);
    }
}
