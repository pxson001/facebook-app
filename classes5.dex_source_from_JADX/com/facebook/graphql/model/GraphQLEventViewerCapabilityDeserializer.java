package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: parentIds */
public class GraphQLEventViewerCapabilityDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventViewerCapability.class, new GraphQLEventViewerCapabilityDeserializer());
    }

    public GraphQLEventViewerCapabilityDeserializer() {
        a(GraphQLEventViewerCapability.class);
    }

    public Object m7324a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventViewerCapability__JsonHelper.m7326a(jsonParser);
    }
}
