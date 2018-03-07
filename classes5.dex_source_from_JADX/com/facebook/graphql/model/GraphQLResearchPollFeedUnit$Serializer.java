package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLResearchPollFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_HOME_PINNED_TOPICS_LIVE */
public final class GraphQLResearchPollFeedUnit$Serializer extends JsonSerializer<GraphQLResearchPollFeedUnit> {
    public final void m21400a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit = (GraphQLResearchPollFeedUnit) obj;
        GraphQLResearchPollFeedUnitDeserializer.m5812a(graphQLResearchPollFeedUnit.w_(), graphQLResearchPollFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLResearchPollFeedUnit.class, new GraphQLResearchPollFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLResearchPollFeedUnit.class, new GraphQLResearchPollFeedUnit$Serializer());
    }
}
