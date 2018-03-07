package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_tag_dialog */
public class GraphQLFeedbackReactionInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFeedbackReactionInfo.class, new GraphQLFeedbackReactionInfoDeserializer());
    }

    public GraphQLFeedbackReactionInfoDeserializer() {
        a(GraphQLFeedbackReactionInfo.class);
    }

    public Object m7489a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFeedbackReactionInfo__JsonHelper.a(jsonParser);
    }
}
