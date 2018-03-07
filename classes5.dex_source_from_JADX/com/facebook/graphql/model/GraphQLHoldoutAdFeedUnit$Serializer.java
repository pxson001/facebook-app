package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLHoldoutAdFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: forceCodeForRefreshToken */
public final class GraphQLHoldoutAdFeedUnit$Serializer extends JsonSerializer<GraphQLHoldoutAdFeedUnit> {
    public final void m8606a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLHoldoutAdFeedUnit graphQLHoldoutAdFeedUnit = (GraphQLHoldoutAdFeedUnit) obj;
        GraphQLHoldoutAdFeedUnitDeserializer.m5218a(graphQLHoldoutAdFeedUnit.w_(), graphQLHoldoutAdFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLHoldoutAdFeedUnit.class, new GraphQLHoldoutAdFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLHoldoutAdFeedUnit.class, new GraphQLHoldoutAdFeedUnit$Serializer());
    }
}
