package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLSinglePublisherVideoChannelsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VACATION_HOME_RENTAL */
public final class GraphQLSinglePublisherVideoChannelsConnection$Serializer extends JsonSerializer<GraphQLSinglePublisherVideoChannelsConnection> {
    public final void m21659a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSinglePublisherVideoChannelsConnection graphQLSinglePublisherVideoChannelsConnection = (GraphQLSinglePublisherVideoChannelsConnection) obj;
        GraphQLSinglePublisherVideoChannelsConnectionDeserializer.m5891a(graphQLSinglePublisherVideoChannelsConnection.w_(), graphQLSinglePublisherVideoChannelsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLSinglePublisherVideoChannelsConnection.class, new GraphQLSinglePublisherVideoChannelsConnection$Serializer());
        FbSerializerProvider.a(GraphQLSinglePublisherVideoChannelsConnection.class, new GraphQLSinglePublisherVideoChannelsConnection$Serializer());
    }
}
