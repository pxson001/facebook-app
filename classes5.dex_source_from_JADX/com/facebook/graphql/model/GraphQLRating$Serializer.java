package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLRatingDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEWER_SELF */
public final class GraphQLRating$Serializer extends JsonSerializer<GraphQLRating> {
    public final void m21307a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLRating graphQLRating = (GraphQLRating) obj;
        GraphQLRatingDeserializer.m5780a(graphQLRating.w_(), graphQLRating.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLRating.class, new GraphQLRating$Serializer());
        FbSerializerProvider.a(GraphQLRating.class, new GraphQLRating$Serializer());
    }
}
