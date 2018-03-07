package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_surface_events_tab */
public class GraphQLFeedbackRealTimeActivityActorsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFeedbackRealTimeActivityActorsConnection.class, new GraphQLFeedbackRealTimeActivityActorsConnectionDeserializer());
    }

    public GraphQLFeedbackRealTimeActivityActorsConnectionDeserializer() {
        a(GraphQLFeedbackRealTimeActivityActorsConnection.class);
    }

    public Object m7497a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFeedbackRealTimeActivityActorsConnection__JsonHelper.m7499a(jsonParser);
    }
}
