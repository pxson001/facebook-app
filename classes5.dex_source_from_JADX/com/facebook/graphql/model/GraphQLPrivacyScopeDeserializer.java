package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: netego_album */
public class GraphQLPrivacyScopeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivacyScope.class, new GraphQLPrivacyScopeDeserializer());
    }

    public GraphQLPrivacyScopeDeserializer() {
        a(GraphQLPrivacyScope.class);
    }

    public Object m21031a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPrivacyScope__JsonHelper.m21033a(jsonParser);
    }
}
