package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ogHideObjectAttachment */
public class GraphQLNegativeFeedbackActionsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNegativeFeedbackActionsConnection.class, new GraphQLNegativeFeedbackActionsConnectionDeserializer());
    }

    public GraphQLNegativeFeedbackActionsConnectionDeserializer() {
        a(GraphQLNegativeFeedbackActionsConnection.class);
    }

    public Object m9241a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9243a(jsonParser);
    }
}
