package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPageOutcomeButtonDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: enabled_favorite_icon */
public final class GraphQLPageOutcomeButton$Serializer extends JsonSerializer<GraphQLPageOutcomeButton> {
    public final void m9503a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageOutcomeButton graphQLPageOutcomeButton = (GraphQLPageOutcomeButton) obj;
        GraphQLPageOutcomeButtonDeserializer.m5517a(graphQLPageOutcomeButton.w_(), graphQLPageOutcomeButton.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPageOutcomeButton.class, new GraphQLPageOutcomeButton$Serializer());
        FbSerializerProvider.a(GraphQLPageOutcomeButton.class, new GraphQLPageOutcomeButton$Serializer());
    }
}
