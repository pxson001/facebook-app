package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStoryInsightsDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: Unable to create thumbnail bitmap. */
public class GraphQLStoryInsights$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStoryInsights.class, new GraphQLStoryInsights$Deserializer());
    }

    public Object m21875a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLStoryInsightsDeserializer.m5974a(jsonParser, (short) 262);
        Object graphQLStoryInsights = new GraphQLStoryInsights();
        ((BaseModel) graphQLStoryInsights).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLStoryInsights instanceof Postprocessable) {
            return ((Postprocessable) graphQLStoryInsights).a();
        }
        return graphQLStoryInsights;
    }
}
