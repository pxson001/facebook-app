package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGroupsYouShouldJoinFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fqlMultiQueryMethod */
public final class GraphQLGroupsYouShouldJoinFeedUnit$Serializer extends JsonSerializer<GraphQLGroupsYouShouldJoinFeedUnit> {
    public final void m8544a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupsYouShouldJoinFeedUnit graphQLGroupsYouShouldJoinFeedUnit = (GraphQLGroupsYouShouldJoinFeedUnit) obj;
        GraphQLGroupsYouShouldJoinFeedUnitDeserializer.m5204a(graphQLGroupsYouShouldJoinFeedUnit.w_(), graphQLGroupsYouShouldJoinFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupsYouShouldJoinFeedUnit.class, new GraphQLGroupsYouShouldJoinFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLGroupsYouShouldJoinFeedUnit.class, new GraphQLGroupsYouShouldJoinFeedUnit$Serializer());
    }
}
