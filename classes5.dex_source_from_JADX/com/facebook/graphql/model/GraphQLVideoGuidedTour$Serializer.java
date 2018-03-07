package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLVideoGuidedTourDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: This instance has been unsubscribed and the queue is no longer usable. */
public final class GraphQLVideoGuidedTour$Serializer extends JsonSerializer<GraphQLVideoGuidedTour> {
    public final void m22450a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLVideoGuidedTour graphQLVideoGuidedTour = (GraphQLVideoGuidedTour) obj;
        GraphQLVideoGuidedTourDeserializer.m6189a(graphQLVideoGuidedTour.w_(), graphQLVideoGuidedTour.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLVideoGuidedTour.class, new GraphQLVideoGuidedTour$Serializer());
        FbSerializerProvider.a(GraphQLVideoGuidedTour.class, new GraphQLVideoGuidedTour$Serializer());
    }
}
