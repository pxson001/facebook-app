package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: optin_decline_confirm_text */
public class GraphQLLeadGenDataDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLeadGenData.class, new GraphQLLeadGenDataDeserializer());
    }

    public GraphQLLeadGenDataDeserializer() {
        a(GraphQLLeadGenData.class);
    }

    public Object m8818a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLLeadGenData__JsonHelper.m8820a(jsonParser);
    }
}
