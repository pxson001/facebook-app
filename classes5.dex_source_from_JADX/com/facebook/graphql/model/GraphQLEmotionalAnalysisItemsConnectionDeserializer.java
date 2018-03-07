package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pending_post_request_queue */
public class GraphQLEmotionalAnalysisItemsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEmotionalAnalysisItemsConnection.class, new GraphQLEmotionalAnalysisItemsConnectionDeserializer());
    }

    public GraphQLEmotionalAnalysisItemsConnectionDeserializer() {
        a(GraphQLEmotionalAnalysisItemsConnection.class);
    }

    public Object m7021a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEmotionalAnalysisItemsConnection__JsonHelper.m7023a(jsonParser);
    }
}
