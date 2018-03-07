package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: optin_decline_button_confirm_text */
public class GraphQLLeadGenErrorNodeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLeadGenErrorNode.class, new GraphQLLeadGenErrorNodeDeserializer());
    }

    public GraphQLLeadGenErrorNodeDeserializer() {
        a(GraphQLLeadGenErrorNode.class);
    }

    public Object m8831a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLLeadGenErrorNode__JsonHelper.m8833a(jsonParser);
    }
}
