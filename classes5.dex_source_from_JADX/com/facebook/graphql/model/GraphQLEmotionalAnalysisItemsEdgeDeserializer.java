package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pending_post_count */
public class GraphQLEmotionalAnalysisItemsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEmotionalAnalysisItemsEdge.class, new GraphQLEmotionalAnalysisItemsEdgeDeserializer());
    }

    public GraphQLEmotionalAnalysisItemsEdgeDeserializer() {
        a(GraphQLEmotionalAnalysisItemsEdge.class);
    }

    public Object m7030a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEmotionalAnalysisItemsEdge__JsonHelper.m7032a(jsonParser);
    }
}
