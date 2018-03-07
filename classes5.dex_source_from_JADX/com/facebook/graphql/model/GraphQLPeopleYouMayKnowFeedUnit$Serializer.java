package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPeopleYouMayKnowFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WORKPLACE_OFFICE */
public final class GraphQLPeopleYouMayKnowFeedUnit$Serializer extends JsonSerializer<GraphQLPeopleYouMayKnowFeedUnit> {
    public final void m20674a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPeopleYouMayKnowFeedUnit graphQLPeopleYouMayKnowFeedUnit = (GraphQLPeopleYouMayKnowFeedUnit) obj;
        GraphQLPeopleYouMayKnowFeedUnitDeserializer.m5586a(graphQLPeopleYouMayKnowFeedUnit.w_(), graphQLPeopleYouMayKnowFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPeopleYouMayKnowFeedUnit.class, new GraphQLPeopleYouMayKnowFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLPeopleYouMayKnowFeedUnit.class, new GraphQLPeopleYouMayKnowFeedUnit$Serializer());
    }
}
