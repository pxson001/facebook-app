package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLInstreamVideoAdsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feedback_unsubscribe */
public final class GraphQLInstreamVideoAdsConnection$Serializer extends JsonSerializer<GraphQLInstreamVideoAdsConnection> {
    public final void m8736a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInstreamVideoAdsConnection graphQLInstreamVideoAdsConnection = (GraphQLInstreamVideoAdsConnection) obj;
        GraphQLInstreamVideoAdsConnectionDeserializer.m5270a(graphQLInstreamVideoAdsConnection.w_(), graphQLInstreamVideoAdsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLInstreamVideoAdsConnection.class, new GraphQLInstreamVideoAdsConnection$Serializer());
        FbSerializerProvider.a(GraphQLInstreamVideoAdsConnection.class, new GraphQLInstreamVideoAdsConnection$Serializer());
    }
}
