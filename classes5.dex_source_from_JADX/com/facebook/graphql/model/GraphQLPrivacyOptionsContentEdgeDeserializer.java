package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: netego_canvas */
public class GraphQLPrivacyOptionsContentEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivacyOptionsContentEdge.class, new GraphQLPrivacyOptionsContentEdgeDeserializer());
    }

    public GraphQLPrivacyOptionsContentEdgeDeserializer() {
        a(GraphQLPrivacyOptionsContentEdge.class);
    }

    public Object m21015a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPrivacyOptionsContentEdge__JsonHelper.m21017a(jsonParser);
    }
}
