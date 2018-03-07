package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friends_who_used_contact_importer_on_messenger_count */
public class GraphQLGreetingCardSlidesConnectionSerializer extends JsonSerializer<GraphQLGreetingCardSlidesConnection> {
    public final void m8356a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGreetingCardSlidesConnection__JsonHelper.m8358a(jsonGenerator, (GraphQLGreetingCardSlidesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGreetingCardSlidesConnection.class, new GraphQLGreetingCardSlidesConnectionSerializer());
    }
}
