package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_thumbnail_uri */
public class GraphQLFeedbackReactionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFeedbackReaction.class, new GraphQLFeedbackReactionDeserializer());
    }

    public GraphQLFeedbackReactionDeserializer() {
        a(GraphQLFeedbackReaction.class);
    }

    public Object m7485a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFeedbackReaction__JsonHelper.a(jsonParser);
    }
}
