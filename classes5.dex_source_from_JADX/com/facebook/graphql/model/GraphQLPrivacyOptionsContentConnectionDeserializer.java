package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: netego_friend_requests */
public class GraphQLPrivacyOptionsContentConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivacyOptionsContentConnection.class, new GraphQLPrivacyOptionsContentConnectionDeserializer());
    }

    public GraphQLPrivacyOptionsContentConnectionDeserializer() {
        a(GraphQLPrivacyOptionsContentConnection.class);
    }

    public Object m21007a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPrivacyOptionsContentConnection__JsonHelper.m21009a(jsonParser);
    }
}
