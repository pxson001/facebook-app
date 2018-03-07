package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPaginatedPeopleYouMayKnowFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WRAPPER_OBJECT */
public final class GraphQLPaginatedPeopleYouMayKnowFeedUnit$Serializer extends JsonSerializer<GraphQLPaginatedPeopleYouMayKnowFeedUnit> {
    public final void m20614a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit = (GraphQLPaginatedPeopleYouMayKnowFeedUnit) obj;
        GraphQLPaginatedPeopleYouMayKnowFeedUnitDeserializer.m5565a(graphQLPaginatedPeopleYouMayKnowFeedUnit.w_(), graphQLPaginatedPeopleYouMayKnowFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPaginatedPeopleYouMayKnowFeedUnit.class, new GraphQLPaginatedPeopleYouMayKnowFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLPaginatedPeopleYouMayKnowFeedUnit.class, new GraphQLPaginatedPeopleYouMayKnowFeedUnit$Serializer());
    }
}
