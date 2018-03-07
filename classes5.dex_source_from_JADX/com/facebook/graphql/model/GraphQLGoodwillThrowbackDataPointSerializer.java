package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: googleSignInOptions */
public class GraphQLGoodwillThrowbackDataPointSerializer extends JsonSerializer<GraphQLGoodwillThrowbackDataPoint> {
    public final void m7933a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillThrowbackDataPoint__JsonHelper.m7935a(jsonGenerator, (GraphQLGoodwillThrowbackDataPoint) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillThrowbackDataPoint.class, new GraphQLGoodwillThrowbackDataPointSerializer());
    }
}
