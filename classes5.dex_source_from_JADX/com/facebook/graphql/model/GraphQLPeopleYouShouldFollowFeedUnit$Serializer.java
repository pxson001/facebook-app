package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPeopleYouShouldFollowFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WIZARD_SEARCH */
public final class GraphQLPeopleYouShouldFollowFeedUnit$Serializer extends JsonSerializer<GraphQLPeopleYouShouldFollowFeedUnit> {
    public final void m20693a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPeopleYouShouldFollowFeedUnit graphQLPeopleYouShouldFollowFeedUnit = (GraphQLPeopleYouShouldFollowFeedUnit) obj;
        GraphQLPeopleYouShouldFollowFeedUnitDeserializer.m5594a(graphQLPeopleYouShouldFollowFeedUnit.w_(), graphQLPeopleYouShouldFollowFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPeopleYouShouldFollowFeedUnit.class, new GraphQLPeopleYouShouldFollowFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLPeopleYouShouldFollowFeedUnit.class, new GraphQLPeopleYouShouldFollowFeedUnit$Serializer());
    }
}
