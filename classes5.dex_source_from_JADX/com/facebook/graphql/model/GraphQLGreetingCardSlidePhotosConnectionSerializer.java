package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: from_bug_report_activity */
public class GraphQLGreetingCardSlidePhotosConnectionSerializer extends JsonSerializer<GraphQLGreetingCardSlidePhotosConnection> {
    public final void m8346a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGreetingCardSlidePhotosConnection__JsonHelper.m8348a(jsonGenerator, (GraphQLGreetingCardSlidePhotosConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGreetingCardSlidePhotosConnection.class, new GraphQLGreetingCardSlidePhotosConnectionSerializer());
    }
}
