package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLNewsFeedConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: events_calendar_subscription_status */
public final class GraphQLNewsFeedConnection$Serializer extends JsonSerializer<GraphQLNewsFeedConnection> {
    public final void m9252a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNewsFeedConnection graphQLNewsFeedConnection = (GraphQLNewsFeedConnection) obj;
        GraphQLNewsFeedConnectionDeserializer.m5423a(graphQLNewsFeedConnection.w_(), graphQLNewsFeedConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLNewsFeedConnection.class, new GraphQLNewsFeedConnection$Serializer());
        FbSerializerProvider.a(GraphQLNewsFeedConnection.class, new GraphQLNewsFeedConnection$Serializer());
    }
}
