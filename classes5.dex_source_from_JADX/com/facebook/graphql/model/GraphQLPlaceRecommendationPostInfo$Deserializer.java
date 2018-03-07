package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPlaceRecommendationPostInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WEAKLYENGAGED_BY_YOUR_FRIENDS */
public class GraphQLPlaceRecommendationPostInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPlaceRecommendationPostInfo.class, new GraphQLPlaceRecommendationPostInfo$Deserializer());
    }

    public Object m20889a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPlaceRecommendationPostInfoDeserializer.m5661a(jsonParser, (short) 165);
        Object graphQLPlaceRecommendationPostInfo = new GraphQLPlaceRecommendationPostInfo();
        ((BaseModel) graphQLPlaceRecommendationPostInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPlaceRecommendationPostInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLPlaceRecommendationPostInfo).a();
        }
        return graphQLPlaceRecommendationPostInfo;
    }
}
