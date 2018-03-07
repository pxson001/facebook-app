package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: imageLandscape */
public class GraphQLEventsOccurringHereConnectionSerializer extends JsonSerializer<GraphQLEventsOccurringHereConnection> {
    public final void m7356a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventsOccurringHereConnection__JsonHelper.m7358a(jsonGenerator, (GraphQLEventsOccurringHereConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventsOccurringHereConnection.class, new GraphQLEventsOccurringHereConnectionSerializer());
    }
}
