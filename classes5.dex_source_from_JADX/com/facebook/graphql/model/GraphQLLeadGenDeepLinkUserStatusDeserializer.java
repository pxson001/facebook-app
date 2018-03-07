package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: optin_decline_button_text */
public class GraphQLLeadGenDeepLinkUserStatusDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLeadGenDeepLinkUserStatus.class, new GraphQLLeadGenDeepLinkUserStatusDeserializer());
    }

    public GraphQLLeadGenDeepLinkUserStatusDeserializer() {
        a(GraphQLLeadGenDeepLinkUserStatus.class);
    }

    public Object m8825a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLLeadGenDeepLinkUserStatus__JsonHelper.m8827a(jsonParser);
    }
}
