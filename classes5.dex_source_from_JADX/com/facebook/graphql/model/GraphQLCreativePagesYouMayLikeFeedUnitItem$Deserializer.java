package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLCreativePagesYouMayLikeFeedUnitItemDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: is-default */
public class GraphQLCreativePagesYouMayLikeFeedUnitItem$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCreativePagesYouMayLikeFeedUnitItem.class, new GraphQLCreativePagesYouMayLikeFeedUnitItem$Deserializer());
    }

    public Object m6896a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLCreativePagesYouMayLikeFeedUnitItemDeserializer.m4693a(jsonParser, (short) 350);
        Object graphQLCreativePagesYouMayLikeFeedUnitItem = new GraphQLCreativePagesYouMayLikeFeedUnitItem();
        ((BaseModel) graphQLCreativePagesYouMayLikeFeedUnitItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLCreativePagesYouMayLikeFeedUnitItem instanceof Postprocessable) {
            return ((Postprocessable) graphQLCreativePagesYouMayLikeFeedUnitItem).a();
        }
        return graphQLCreativePagesYouMayLikeFeedUnitItem;
    }
}
