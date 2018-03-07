package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photo_hash */
public class GraphQLComposedDocumentDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLComposedDocument.class, new GraphQLComposedDocumentDeserializer());
    }

    public GraphQLComposedDocumentDeserializer() {
        a(GraphQLComposedDocument.class);
    }

    public Object m6836a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLComposedDocument__JsonHelper.m6838a(jsonParser);
    }
}
