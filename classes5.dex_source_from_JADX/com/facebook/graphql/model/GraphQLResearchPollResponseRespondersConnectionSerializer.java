package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_CHANNEL_SIDEPANE */
public class GraphQLResearchPollResponseRespondersConnectionSerializer extends JsonSerializer<GraphQLResearchPollResponseRespondersConnection> {
    public final void m21462a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLResearchPollResponseRespondersConnection__JsonHelper.m21464a(jsonGenerator, (GraphQLResearchPollResponseRespondersConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLResearchPollResponseRespondersConnection.class, new GraphQLResearchPollResponseRespondersConnectionSerializer());
    }
}
