package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStoryGallerySurveyFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: Unable to retrieve Data power stats */
public class GraphQLStoryGallerySurveyFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStoryGallerySurveyFeedUnit.class, new GraphQLStoryGallerySurveyFeedUnit$Deserializer());
    }

    public Object m21866a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLStoryGallerySurveyFeedUnitDeserializer.m5968a(jsonParser, (short) 40);
        Object graphQLStoryGallerySurveyFeedUnit = new GraphQLStoryGallerySurveyFeedUnit();
        ((BaseModel) graphQLStoryGallerySurveyFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLStoryGallerySurveyFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLStoryGallerySurveyFeedUnit).a();
        }
        return graphQLStoryGallerySurveyFeedUnit;
    }
}
