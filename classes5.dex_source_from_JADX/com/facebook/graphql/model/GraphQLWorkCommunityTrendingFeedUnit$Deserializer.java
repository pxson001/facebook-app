package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLWorkCommunityTrendingFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: TaggableActivityPreviewTemplate */
public class GraphQLWorkCommunityTrendingFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLWorkCommunityTrendingFeedUnit.class, new GraphQLWorkCommunityTrendingFeedUnit$Deserializer());
    }

    public Object m22502a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLWorkCommunityTrendingFeedUnitDeserializer.m6209a(jsonParser, (short) 546);
        Object graphQLWorkCommunityTrendingFeedUnit = new GraphQLWorkCommunityTrendingFeedUnit();
        ((BaseModel) graphQLWorkCommunityTrendingFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLWorkCommunityTrendingFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLWorkCommunityTrendingFeedUnit).a();
        }
        return graphQLWorkCommunityTrendingFeedUnit;
    }
}
