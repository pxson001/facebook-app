package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: isThrowbackPost */
public class GraphQLComposedDocumentSerializer extends JsonSerializer<GraphQLComposedDocument> {
    public final void m6837a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLComposedDocument__JsonHelper.m6839a(jsonGenerator, (GraphQLComposedDocument) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLComposedDocument.class, new GraphQLComposedDocumentSerializer());
    }
}
