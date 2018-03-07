package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: V1 */
public class GraphQLSinglePublisherVideoChannelsConnectionSerializer extends JsonSerializer<GraphQLSinglePublisherVideoChannelsConnection> {
    public final void m21661a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSinglePublisherVideoChannelsConnection__JsonHelper.m21663a(jsonGenerator, (GraphQLSinglePublisherVideoChannelsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSinglePublisherVideoChannelsConnection.class, new GraphQLSinglePublisherVideoChannelsConnectionSerializer());
    }
}
