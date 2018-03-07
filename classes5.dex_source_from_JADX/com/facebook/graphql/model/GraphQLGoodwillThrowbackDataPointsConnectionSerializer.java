package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: google.com */
public class GraphQLGoodwillThrowbackDataPointsConnectionSerializer extends JsonSerializer<GraphQLGoodwillThrowbackDataPointsConnection> {
    public final void m7939a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillThrowbackDataPointsConnection__JsonHelper.m7941a(jsonGenerator, (GraphQLGoodwillThrowbackDataPointsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillThrowbackDataPointsConnection.class, new GraphQLGoodwillThrowbackDataPointsConnectionSerializer());
    }
}
