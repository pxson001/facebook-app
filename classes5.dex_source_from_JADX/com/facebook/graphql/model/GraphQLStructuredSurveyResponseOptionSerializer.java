package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UPSELL_WITH_DATA_CONTROL */
public class GraphQLStructuredSurveyResponseOptionSerializer extends JsonSerializer<GraphQLStructuredSurveyResponseOption> {
    public final void m21993a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStructuredSurveyResponseOption__JsonHelper.m21995a(jsonGenerator, (GraphQLStructuredSurveyResponseOption) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLStructuredSurveyResponseOption.class, new GraphQLStructuredSurveyResponseOptionSerializer());
    }
}
