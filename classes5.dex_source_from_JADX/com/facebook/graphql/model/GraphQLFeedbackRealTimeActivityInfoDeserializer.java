package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_suggestions_on_liking_refresh */
public class GraphQLFeedbackRealTimeActivityInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFeedbackRealTimeActivityInfo.class, new GraphQLFeedbackRealTimeActivityInfoDeserializer());
    }

    public GraphQLFeedbackRealTimeActivityInfoDeserializer() {
        a(GraphQLFeedbackRealTimeActivityInfo.class);
    }

    public Object m7503a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFeedbackRealTimeActivityInfo__JsonHelper.m7505a(jsonParser);
    }
}
