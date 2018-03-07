package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPageStoriesYouMissedFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: enable_ad_network_bridging */
public class GraphQLPageStoriesYouMissedFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageStoriesYouMissedFeedUnit.class, new GraphQLPageStoriesYouMissedFeedUnit$Deserializer());
    }

    public Object m9523a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPageStoriesYouMissedFeedUnitDeserializer.m5525a(jsonParser, (short) 562);
        Object graphQLPageStoriesYouMissedFeedUnit = new GraphQLPageStoriesYouMissedFeedUnit();
        ((BaseModel) graphQLPageStoriesYouMissedFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPageStoriesYouMissedFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLPageStoriesYouMissedFeedUnit).a();
        }
        return graphQLPageStoriesYouMissedFeedUnit;
    }
}
