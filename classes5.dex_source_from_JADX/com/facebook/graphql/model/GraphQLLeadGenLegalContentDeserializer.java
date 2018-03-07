package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: operationState */
public class GraphQLLeadGenLegalContentDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLeadGenLegalContent.class, new GraphQLLeadGenLegalContentDeserializer());
    }

    public GraphQLLeadGenLegalContentDeserializer() {
        a(GraphQLLeadGenLegalContent.class);
    }

    public Object m8879a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLLeadGenLegalContent__JsonHelper.m8881a(jsonParser);
    }
}
