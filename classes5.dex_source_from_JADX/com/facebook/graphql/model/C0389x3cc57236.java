package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ownerUserId */
public class C0389x3cc57236 extends FbJsonDeserializer {
    public Object m8388a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLGroupCanToggleCommentDisablingOnPostActionLink graphQLGroupCanToggleCommentDisablingOnPostActionLink = new GraphQLGroupCanToggleCommentDisablingOnPostActionLink();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLGroupCanToggleCommentDisablingOnPostActionLink = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                C0390x30f1b3f9.m8390a(graphQLGroupCanToggleCommentDisablingOnPostActionLink, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLGroupCanToggleCommentDisablingOnPostActionLink;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupCanToggleCommentDisablingOnPostActionLink.class, new C0389x3cc57236());
    }

    public C0389x3cc57236() {
        a(GraphQLGroupCanToggleCommentDisablingOnPostActionLink.class);
    }
}
