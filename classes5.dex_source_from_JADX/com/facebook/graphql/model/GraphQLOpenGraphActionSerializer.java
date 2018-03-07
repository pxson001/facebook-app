package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: event_buy_ticket_display_url */
public class GraphQLOpenGraphActionSerializer extends JsonSerializer<GraphQLOpenGraphAction> {
    public final void m9394a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLOpenGraphAction__JsonHelper.m9396a(jsonGenerator, (GraphQLOpenGraphAction) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLOpenGraphAction.class, new GraphQLOpenGraphActionSerializer());
    }
}
