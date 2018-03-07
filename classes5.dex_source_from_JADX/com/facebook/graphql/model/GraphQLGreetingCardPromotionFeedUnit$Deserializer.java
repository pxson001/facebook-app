package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGreetingCardPromotionFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: fullLatestVersion */
public class GraphQLGreetingCardPromotionFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGreetingCardPromotionFeedUnit.class, new GraphQLGreetingCardPromotionFeedUnit$Deserializer());
    }

    public Object m8325a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGreetingCardPromotionFeedUnitDeserializer.m5125a(jsonParser, (short) 130);
        Object graphQLGreetingCardPromotionFeedUnit = new GraphQLGreetingCardPromotionFeedUnit();
        ((BaseModel) graphQLGreetingCardPromotionFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGreetingCardPromotionFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLGreetingCardPromotionFeedUnit).a();
        }
        return graphQLGreetingCardPromotionFeedUnit;
    }
}
