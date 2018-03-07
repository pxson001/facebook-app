package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: permalink_node */
public class GraphQLDocumentElementDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLDocumentElement.class, new GraphQLDocumentElementDeserializer());
    }

    public GraphQLDocumentElementDeserializer() {
        a(GraphQLDocumentElement.class);
    }

    public Object m6952a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLDocumentElement__JsonHelper.m6954a(jsonParser);
    }
}
