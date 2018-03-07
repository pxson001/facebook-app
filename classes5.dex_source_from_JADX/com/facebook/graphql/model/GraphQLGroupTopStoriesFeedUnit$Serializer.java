package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGroupTopStoriesFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friendEventMembers */
public final class GraphQLGroupTopStoriesFeedUnit$Serializer extends JsonSerializer<GraphQLGroupTopStoriesFeedUnit> {
    public final void m8495a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupTopStoriesFeedUnit graphQLGroupTopStoriesFeedUnit = (GraphQLGroupTopStoriesFeedUnit) obj;
        GraphQLGroupTopStoriesFeedUnitDeserializer.m5187a(graphQLGroupTopStoriesFeedUnit.w_(), graphQLGroupTopStoriesFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupTopStoriesFeedUnit.class, new GraphQLGroupTopStoriesFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLGroupTopStoriesFeedUnit.class, new GraphQLGroupTopStoriesFeedUnit$Serializer());
    }
}
