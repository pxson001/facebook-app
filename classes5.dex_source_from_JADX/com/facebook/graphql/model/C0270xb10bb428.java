package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: placeProfilePicture */
public class C0270xb10bb428 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection.class, new C0270xb10bb428());
    }

    public C0270xb10bb428() {
        a(GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection.class);
    }

    public Object m6578a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return C0272xa537f5eb.m6580a(jsonParser);
    }
}
