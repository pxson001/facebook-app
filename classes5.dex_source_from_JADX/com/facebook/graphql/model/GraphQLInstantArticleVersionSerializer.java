package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fetch_supported_reactions */
public class GraphQLInstantArticleVersionSerializer extends JsonSerializer<GraphQLInstantArticleVersion> {
    public final void m8729a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInstantArticleVersion__JsonHelper.m8731a(jsonGenerator, (GraphQLInstantArticleVersion) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLInstantArticleVersion.class, new GraphQLInstantArticleVersionSerializer());
    }
}
