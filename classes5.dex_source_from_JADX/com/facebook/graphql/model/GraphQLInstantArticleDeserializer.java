package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: options_bar_menu */
public class GraphQLInstantArticleDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInstantArticle.class, new GraphQLInstantArticleDeserializer());
    }

    public GraphQLInstantArticleDeserializer() {
        a(GraphQLInstantArticle.class);
    }

    public Object m8724a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLInstantArticle__JsonHelper.m8732a(jsonParser);
    }
}
