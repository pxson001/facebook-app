package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_unlike */
public class GraphQLFeedbackContextDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFeedbackContext.class, new GraphQLFeedbackContextDeserializer());
    }

    public GraphQLFeedbackContextDeserializer() {
        a(GraphQLFeedbackContext.class);
    }

    public Object m7477a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFeedbackContext__JsonHelper.m7479a(jsonParser);
    }
}
