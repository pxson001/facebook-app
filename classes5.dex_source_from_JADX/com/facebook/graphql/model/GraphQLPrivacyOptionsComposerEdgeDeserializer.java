package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: netego_group */
public class GraphQLPrivacyOptionsComposerEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivacyOptionsComposerEdge.class, new GraphQLPrivacyOptionsComposerEdgeDeserializer());
    }

    public GraphQLPrivacyOptionsComposerEdgeDeserializer() {
        a(GraphQLPrivacyOptionsComposerEdge.class);
    }

    public Object m21001a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPrivacyOptionsComposerEdge__JsonHelper.a(jsonParser);
    }
}
