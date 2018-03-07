package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: optin_decline_button_cancel_text */
public class GraphQLLeadGenInfoFieldDataDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLeadGenInfoFieldData.class, new GraphQLLeadGenInfoFieldDataDeserializer());
    }

    public GraphQLLeadGenInfoFieldDataDeserializer() {
        a(GraphQLLeadGenInfoFieldData.class);
    }

    public Object m8850a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLLeadGenInfoFieldData__JsonHelper.m8852a(jsonParser);
    }
}
