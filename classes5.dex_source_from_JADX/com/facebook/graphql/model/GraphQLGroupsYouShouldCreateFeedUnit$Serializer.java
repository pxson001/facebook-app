package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGroupsYouShouldCreateFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: frames_cta */
public final class GraphQLGroupsYouShouldCreateFeedUnit$Serializer extends JsonSerializer<GraphQLGroupsYouShouldCreateFeedUnit> {
    public final void m8522a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupsYouShouldCreateFeedUnit graphQLGroupsYouShouldCreateFeedUnit = (GraphQLGroupsYouShouldCreateFeedUnit) obj;
        GraphQLGroupsYouShouldCreateFeedUnitDeserializer.m5196a(graphQLGroupsYouShouldCreateFeedUnit.w_(), graphQLGroupsYouShouldCreateFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupsYouShouldCreateFeedUnit.class, new GraphQLGroupsYouShouldCreateFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLGroupsYouShouldCreateFeedUnit.class, new GraphQLGroupsYouShouldCreateFeedUnit$Serializer());
    }
}
