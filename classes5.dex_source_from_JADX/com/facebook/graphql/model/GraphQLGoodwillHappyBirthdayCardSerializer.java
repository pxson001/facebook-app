package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: graph_search_chevron_incorrect_place_category */
public class GraphQLGoodwillHappyBirthdayCardSerializer extends JsonSerializer<GraphQLGoodwillHappyBirthdayCard> {
    public final void m7887a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillHappyBirthdayCard__JsonHelper.m7889a(jsonGenerator, (GraphQLGoodwillHappyBirthdayCard) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillHappyBirthdayCard.class, new GraphQLGoodwillHappyBirthdayCardSerializer());
    }
}
