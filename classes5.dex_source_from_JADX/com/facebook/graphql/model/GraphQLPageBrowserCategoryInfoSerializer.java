package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: entity */
public class GraphQLPageBrowserCategoryInfoSerializer extends JsonSerializer<GraphQLPageBrowserCategoryInfo> {
    public final void m9477a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageBrowserCategoryInfo__JsonHelper.m9479a(jsonGenerator, (GraphQLPageBrowserCategoryInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPageBrowserCategoryInfo.class, new GraphQLPageBrowserCategoryInfoSerializer());
    }
}
