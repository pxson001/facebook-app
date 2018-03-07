package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: netego_note */
public class GraphQLPrivacyEducationInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivacyEducationInfo.class, new GraphQLPrivacyEducationInfoDeserializer());
    }

    public GraphQLPrivacyEducationInfoDeserializer() {
        a(GraphQLPrivacyEducationInfo.class);
    }

    public Object m20985a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPrivacyEducationInfo__JsonHelper.m20987a(jsonParser);
    }
}
