package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mutation_type */
public class GraphQLResearchPollResponseRespondersConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLResearchPollResponseRespondersConnection.class, new GraphQLResearchPollResponseRespondersConnectionDeserializer());
    }

    public GraphQLResearchPollResponseRespondersConnectionDeserializer() {
        a(GraphQLResearchPollResponseRespondersConnection.class);
    }

    public Object m21461a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLResearchPollResponseRespondersConnection__JsonHelper.m21463a(jsonParser);
    }
}
