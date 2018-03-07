package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: openid */
public class GraphQLLeadGenPrivacyNodeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLeadGenPrivacyNode.class, new GraphQLLeadGenPrivacyNodeDeserializer());
    }

    public GraphQLLeadGenPrivacyNodeDeserializer() {
        a(GraphQLLeadGenPrivacyNode.class);
    }

    public Object m8900a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLLeadGenPrivacyNode__JsonHelper.m8902a(jsonParser);
    }
}
