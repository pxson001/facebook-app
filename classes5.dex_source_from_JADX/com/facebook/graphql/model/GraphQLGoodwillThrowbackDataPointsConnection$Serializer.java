package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackDataPointsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: google.message_id */
public final class GraphQLGoodwillThrowbackDataPointsConnection$Serializer extends JsonSerializer<GraphQLGoodwillThrowbackDataPointsConnection> {
    public final void m7937a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillThrowbackDataPointsConnection graphQLGoodwillThrowbackDataPointsConnection = (GraphQLGoodwillThrowbackDataPointsConnection) obj;
        GraphQLGoodwillThrowbackDataPointsConnectionDeserializer.m5031a(graphQLGoodwillThrowbackDataPointsConnection.w_(), graphQLGoodwillThrowbackDataPointsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillThrowbackDataPointsConnection.class, new GraphQLGoodwillThrowbackDataPointsConnection$Serializer());
        FbSerializerProvider.a(GraphQLGoodwillThrowbackDataPointsConnection.class, new GraphQLGoodwillThrowbackDataPointsConnection$Serializer());
    }
}
