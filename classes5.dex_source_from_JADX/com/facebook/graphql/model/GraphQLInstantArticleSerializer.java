package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ffl */
public class GraphQLInstantArticleSerializer extends JsonSerializer<GraphQLInstantArticle> {
    public final void m8725a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInstantArticle__JsonHelper.m8733a(jsonGenerator, (GraphQLInstantArticle) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLInstantArticle.class, new GraphQLInstantArticleSerializer());
    }
}
