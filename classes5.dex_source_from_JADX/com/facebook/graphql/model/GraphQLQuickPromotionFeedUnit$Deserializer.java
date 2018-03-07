package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLQuickPromotionFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VIEW_PAGE_NOTIFICATION_STORY */
public class GraphQLQuickPromotionFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQuickPromotionFeedUnit.class, new GraphQLQuickPromotionFeedUnit$Deserializer());
    }

    public Object m21233a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLQuickPromotionFeedUnitDeserializer.m5753a(jsonParser, (short) 124);
        Object graphQLQuickPromotionFeedUnit = new GraphQLQuickPromotionFeedUnit();
        ((BaseModel) graphQLQuickPromotionFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLQuickPromotionFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLQuickPromotionFeedUnit).a();
        }
        return graphQLQuickPromotionFeedUnit;
    }
}
