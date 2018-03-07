package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ogIconId */
public class GraphQLNegativeFeedbackActionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNegativeFeedbackAction.class, new GraphQLNegativeFeedbackActionDeserializer());
    }

    public GraphQLNegativeFeedbackActionDeserializer() {
        a(GraphQLNegativeFeedbackAction.class);
    }

    public Object m9234a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLNegativeFeedbackAction__JsonHelper.m9236a(jsonParser);
    }
}
