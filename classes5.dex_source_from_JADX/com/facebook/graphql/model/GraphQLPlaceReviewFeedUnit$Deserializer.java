package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPlaceReviewFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WATERFALL */
public class GraphQLPlaceReviewFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPlaceReviewFeedUnit.class, new GraphQLPlaceReviewFeedUnit$Deserializer());
    }

    public Object m20895a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPlaceReviewFeedUnitDeserializer.m5664a(jsonParser, (short) 118);
        Object graphQLPlaceReviewFeedUnit = new GraphQLPlaceReviewFeedUnit();
        ((BaseModel) graphQLPlaceReviewFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPlaceReviewFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLPlaceReviewFeedUnit).a();
        }
        return graphQLPlaceReviewFeedUnit;
    }
}
