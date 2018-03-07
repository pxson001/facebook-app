package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ViewStub must have a valid layoutResource */
public class GraphQLPrivacyAudienceMemberDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivacyAudienceMember.class, new GraphQLPrivacyAudienceMemberDeserializer());
    }

    public GraphQLPrivacyAudienceMemberDeserializer() {
        a(GraphQLPrivacyAudienceMember.class);
    }

    public Object m20979a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPrivacyAudienceMember__JsonHelper.m20981a(jsonParser);
    }
}
