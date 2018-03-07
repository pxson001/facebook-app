package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_page_old_source */
public class GraphQLDocumentElementSerializer extends JsonSerializer<GraphQLDocumentElement> {
    public final void m6953a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLDocumentElement__JsonHelper.m6955a(jsonGenerator, (GraphQLDocumentElement) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLDocumentElement.class, new GraphQLDocumentElementSerializer());
    }
}
