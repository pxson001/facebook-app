package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLSaleGroupsNearYouFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_ANNOTATION */
public final class GraphQLSaleGroupsNearYouFeedUnit$Serializer extends JsonSerializer<GraphQLSaleGroupsNearYouFeedUnit> {
    public final void m21509a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit = (GraphQLSaleGroupsNearYouFeedUnit) obj;
        GraphQLSaleGroupsNearYouFeedUnitDeserializer.m5844a(graphQLSaleGroupsNearYouFeedUnit.w_(), graphQLSaleGroupsNearYouFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLSaleGroupsNearYouFeedUnit.class, new GraphQLSaleGroupsNearYouFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLSaleGroupsNearYouFeedUnit.class, new GraphQLSaleGroupsNearYouFeedUnit$Serializer());
    }
}
