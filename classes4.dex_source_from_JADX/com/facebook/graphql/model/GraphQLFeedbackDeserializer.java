package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: scroll_depth */
public class GraphQLFeedbackDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFeedback.class, new GraphQLFeedbackDeserializer());
    }

    public GraphQLFeedbackDeserializer() {
        a(GraphQLFeedback.class);
    }

    public Object m3217a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFeedback__JsonHelper.m3218a(jsonParser);
    }
}
