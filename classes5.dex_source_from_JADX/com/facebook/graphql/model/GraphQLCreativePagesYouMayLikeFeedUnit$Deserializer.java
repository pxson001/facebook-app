package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLCreativePagesYouMayLikeFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: is-forced-subtitle */
public class GraphQLCreativePagesYouMayLikeFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCreativePagesYouMayLikeFeedUnit.class, new GraphQLCreativePagesYouMayLikeFeedUnit$Deserializer());
    }

    public Object m6893a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLCreativePagesYouMayLikeFeedUnitDeserializer.m4690a(jsonParser, (short) 121);
        Object graphQLCreativePagesYouMayLikeFeedUnit = new GraphQLCreativePagesYouMayLikeFeedUnit();
        ((BaseModel) graphQLCreativePagesYouMayLikeFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLCreativePagesYouMayLikeFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLCreativePagesYouMayLikeFeedUnit).a();
        }
        return graphQLCreativePagesYouMayLikeFeedUnit;
    }
}
