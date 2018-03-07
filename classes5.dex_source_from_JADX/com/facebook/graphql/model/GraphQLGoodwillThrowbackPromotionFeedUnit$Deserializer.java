package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackPromotionFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: getRecentLogFiles */
public class GraphQLGoodwillThrowbackPromotionFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackPromotionFeedUnit.class, new GraphQLGoodwillThrowbackPromotionFeedUnit$Deserializer());
    }

    public Object m8098a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGoodwillThrowbackPromotionFeedUnitDeserializer.m5066a(jsonParser, (short) 34);
        Object graphQLGoodwillThrowbackPromotionFeedUnit = new GraphQLGoodwillThrowbackPromotionFeedUnit();
        ((BaseModel) graphQLGoodwillThrowbackPromotionFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGoodwillThrowbackPromotionFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLGoodwillThrowbackPromotionFeedUnit).a();
        }
        return graphQLGoodwillThrowbackPromotionFeedUnit;
    }
}
