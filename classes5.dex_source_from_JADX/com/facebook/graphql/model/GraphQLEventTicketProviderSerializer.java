package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: image_source */
public class GraphQLEventTicketProviderSerializer extends JsonSerializer<GraphQLEventTicketProvider> {
    public final void m7296a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventTicketProvider__JsonHelper.m7298a(jsonGenerator, (GraphQLEventTicketProvider) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventTicketProvider.class, new GraphQLEventTicketProviderSerializer());
    }
}
