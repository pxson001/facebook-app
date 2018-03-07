package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLQuickPromotionPeopleYouMayKnowFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VIEW_PAGE_ADMIN_POST */
public class GraphQLQuickPromotionPeopleYouMayKnowFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQuickPromotionPeopleYouMayKnowFeedUnit.class, new GraphQLQuickPromotionPeopleYouMayKnowFeedUnit$Deserializer());
    }

    public Object m21251a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLQuickPromotionPeopleYouMayKnowFeedUnitDeserializer.m5761a(jsonParser, (short) 522);
        Object graphQLQuickPromotionPeopleYouMayKnowFeedUnit = new GraphQLQuickPromotionPeopleYouMayKnowFeedUnit();
        ((BaseModel) graphQLQuickPromotionPeopleYouMayKnowFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLQuickPromotionPeopleYouMayKnowFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLQuickPromotionPeopleYouMayKnowFeedUnit).a();
        }
        return graphQLQuickPromotionPeopleYouMayKnowFeedUnit;
    }
}
