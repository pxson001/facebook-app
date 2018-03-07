package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: negative_feedback_action_type */
public class GraphQLProfileDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLProfile.class, new GraphQLProfileDeserializer());
    }

    public GraphQLProfileDeserializer() {
        a(GraphQLProfile.class);
    }

    public Object m21105a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLProfile__JsonHelper.m21114a(jsonParser);
    }
}
