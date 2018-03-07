package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: my_qr_code */
public class GraphQLResearchPollQuestionRespondersConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLResearchPollQuestionRespondersConnection.class, new GraphQLResearchPollQuestionRespondersConnectionDeserializer());
    }

    public GraphQLResearchPollQuestionRespondersConnectionDeserializer() {
        a(GraphQLResearchPollQuestionRespondersConnection.class);
    }

    public Object m21442a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLResearchPollQuestionRespondersConnection__JsonHelper.m21444a(jsonParser);
    }
}
