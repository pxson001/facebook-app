package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: future */
public class GraphQLGraphSearchQueryTitleSerializer extends JsonSerializer<GraphQLGraphSearchQueryTitle> {
    public final void m8262a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGraphSearchQueryTitle__JsonHelper.m8264a(jsonGenerator, (GraphQLGraphSearchQueryTitle) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGraphSearchQueryTitle.class, new GraphQLGraphSearchQueryTitleSerializer());
    }
}
