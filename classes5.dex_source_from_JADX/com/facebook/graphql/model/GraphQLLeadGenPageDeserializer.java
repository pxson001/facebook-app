package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: operationId */
public class GraphQLLeadGenPageDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLeadGenPage.class, new GraphQLLeadGenPageDeserializer());
    }

    public GraphQLLeadGenPageDeserializer() {
        a(GraphQLLeadGenPage.class);
    }

    public Object m8890a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLLeadGenPage__JsonHelper.m8892a(jsonParser);
    }
}
