package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGoodwillHappyBirthdayCardDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: graph_search_chevron_report_place */
public final class GraphQLGoodwillHappyBirthdayCard$Serializer extends JsonSerializer<GraphQLGoodwillHappyBirthdayCard> {
    public final void m7885a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillHappyBirthdayCard graphQLGoodwillHappyBirthdayCard = (GraphQLGoodwillHappyBirthdayCard) obj;
        GraphQLGoodwillHappyBirthdayCardDeserializer.m5016a(graphQLGoodwillHappyBirthdayCard.w_(), graphQLGoodwillHappyBirthdayCard.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillHappyBirthdayCard.class, new GraphQLGoodwillHappyBirthdayCard$Serializer());
        FbSerializerProvider.a(GraphQLGoodwillHappyBirthdayCard.class, new GraphQLGoodwillHappyBirthdayCard$Serializer());
    }
}
