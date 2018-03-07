package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLStoryGallerySurveyFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unable to retrieve Data power stats */
public final class GraphQLStoryGallerySurveyFeedUnit$Serializer extends JsonSerializer<GraphQLStoryGallerySurveyFeedUnit> {
    public final void m21867a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStoryGallerySurveyFeedUnit graphQLStoryGallerySurveyFeedUnit = (GraphQLStoryGallerySurveyFeedUnit) obj;
        GraphQLStoryGallerySurveyFeedUnitDeserializer.m5969a(graphQLStoryGallerySurveyFeedUnit.w_(), graphQLStoryGallerySurveyFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLStoryGallerySurveyFeedUnit.class, new GraphQLStoryGallerySurveyFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLStoryGallerySurveyFeedUnit.class, new GraphQLStoryGallerySurveyFeedUnit$Serializer());
    }
}
