package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: narrowLandscapeImage */
public class GraphQLResearchPollMultipleChoiceResponseDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLResearchPollMultipleChoiceResponse.class, new GraphQLResearchPollMultipleChoiceResponseDeserializer());
    }

    public GraphQLResearchPollMultipleChoiceResponseDeserializer() {
        a(GraphQLResearchPollMultipleChoiceResponse.class);
    }

    public Object m21432a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLResearchPollMultipleChoiceResponse__JsonHelper.m21434a(jsonParser);
    }
}
