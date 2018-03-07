package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStructuredSurveyDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: USERNAME */
public class GraphQLStructuredSurvey$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStructuredSurvey.class, new GraphQLStructuredSurvey$Deserializer());
    }

    public Object m21938a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLStructuredSurveyDeserializer.m6001a(jsonParser, (short) 57);
        Object graphQLStructuredSurvey = new GraphQLStructuredSurvey();
        ((BaseModel) graphQLStructuredSurvey).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLStructuredSurvey instanceof Postprocessable) {
            return ((Postprocessable) graphQLStructuredSurvey).a();
        }
        return graphQLStructuredSurvey;
    }
}
