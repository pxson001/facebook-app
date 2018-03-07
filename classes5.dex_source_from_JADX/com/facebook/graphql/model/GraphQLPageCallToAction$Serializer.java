package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPageCallToActionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: engagement_pyml */
public final class GraphQLPageCallToAction$Serializer extends JsonSerializer<GraphQLPageCallToAction> {
    public final void m9481a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageCallToAction graphQLPageCallToAction = (GraphQLPageCallToAction) obj;
        GraphQLPageCallToActionDeserializer.m5500a(graphQLPageCallToAction.w_(), graphQLPageCallToAction.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPageCallToAction.class, new GraphQLPageCallToAction$Serializer());
        FbSerializerProvider.a(GraphQLPageCallToAction.class, new GraphQLPageCallToAction$Serializer());
    }
}
