package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photo_flow_id */
public class GraphQLComposerPrivacyGuardrailInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLComposerPrivacyGuardrailInfo.class, new GraphQLComposerPrivacyGuardrailInfoDeserializer());
    }

    public GraphQLComposerPrivacyGuardrailInfoDeserializer() {
        a(GraphQLComposerPrivacyGuardrailInfo.class);
    }

    public Object m6843a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLComposerPrivacyGuardrailInfo__JsonHelper.a(jsonParser);
    }
}
