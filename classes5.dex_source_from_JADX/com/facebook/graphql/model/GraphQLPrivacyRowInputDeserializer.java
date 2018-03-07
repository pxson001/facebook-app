package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VideoChainingFeedUnit */
public class GraphQLPrivacyRowInputDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivacyRowInput.class, new GraphQLPrivacyRowInputDeserializer());
    }

    public GraphQLPrivacyRowInputDeserializer() {
        a(GraphQLPrivacyRowInput.class);
    }

    public Object m21024a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPrivacyRowInput__JsonHelper.a(jsonParser);
    }
}
