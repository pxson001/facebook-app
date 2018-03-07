package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLSurveyFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UP */
public class GraphQLSurveyFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSurveyFeedUnit.class, new GraphQLSurveyFeedUnit$Deserializer());
    }

    public Object m22028a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLSurveyFeedUnitDeserializer.m6024a(jsonParser, (short) 128);
        Object graphQLSurveyFeedUnit = new GraphQLSurveyFeedUnit();
        ((BaseModel) graphQLSurveyFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLSurveyFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLSurveyFeedUnit).a();
        }
        return graphQLSurveyFeedUnit;
    }
}
