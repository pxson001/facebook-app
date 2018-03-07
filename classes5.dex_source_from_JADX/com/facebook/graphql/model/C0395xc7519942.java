package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: owned_events */
public class C0395xc7519942 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupCreationSuggestionDefaultMembersConnection.class, new C0395xc7519942());
    }

    public C0395xc7519942() {
        a(GraphQLGroupCreationSuggestionDefaultMembersConnection.class);
    }

    public Object m8423a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return C0396xbb7ddb05.m8425a(jsonParser);
    }
}
