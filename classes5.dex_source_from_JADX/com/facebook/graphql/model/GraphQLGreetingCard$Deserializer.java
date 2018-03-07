package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGreetingCardDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: full_address */
public class GraphQLGreetingCard$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGreetingCard.class, new GraphQLGreetingCard$Deserializer());
    }

    public Object m8322a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGreetingCardDeserializer.m5122a(jsonParser, (short) 52);
        Object graphQLGreetingCard = new GraphQLGreetingCard();
        ((BaseModel) graphQLGreetingCard).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGreetingCard instanceof Postprocessable) {
            return ((Postprocessable) graphQLGreetingCard).a();
        }
        return graphQLGreetingCard;
    }
}
