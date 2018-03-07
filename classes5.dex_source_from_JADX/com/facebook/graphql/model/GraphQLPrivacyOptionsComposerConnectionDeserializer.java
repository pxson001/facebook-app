package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: netego_messenger */
public class GraphQLPrivacyOptionsComposerConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivacyOptionsComposerConnection.class, new GraphQLPrivacyOptionsComposerConnectionDeserializer());
    }

    public GraphQLPrivacyOptionsComposerConnectionDeserializer() {
        a(GraphQLPrivacyOptionsComposerConnection.class);
    }

    public Object m20997a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPrivacyOptionsComposerConnection__JsonHelper.a(jsonParser);
    }
}
