package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGoodwillHappyBirthdayCardDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: graph_search_chevron_report_place */
public class GraphQLGoodwillHappyBirthdayCard$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillHappyBirthdayCard.class, new GraphQLGoodwillHappyBirthdayCard$Deserializer());
    }

    public Object m7884a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGoodwillHappyBirthdayCardDeserializer.m5015a(jsonParser, (short) 395);
        Object graphQLGoodwillHappyBirthdayCard = new GraphQLGoodwillHappyBirthdayCard();
        ((BaseModel) graphQLGoodwillHappyBirthdayCard).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGoodwillHappyBirthdayCard instanceof Postprocessable) {
            return ((Postprocessable) graphQLGoodwillHappyBirthdayCard).a();
        }
        return graphQLGoodwillHappyBirthdayCard;
    }
}
