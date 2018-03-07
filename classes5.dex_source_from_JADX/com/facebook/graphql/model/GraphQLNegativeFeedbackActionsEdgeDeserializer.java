package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ogHideAttachment */
public class GraphQLNegativeFeedbackActionsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNegativeFeedbackActionsEdge.class, new GraphQLNegativeFeedbackActionsEdgeDeserializer());
    }

    public GraphQLNegativeFeedbackActionsEdgeDeserializer() {
        a(GraphQLNegativeFeedbackActionsEdge.class);
    }

    public Object m9247a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLNegativeFeedbackActionsEdge__JsonHelper.m9249a(jsonParser);
    }
}
