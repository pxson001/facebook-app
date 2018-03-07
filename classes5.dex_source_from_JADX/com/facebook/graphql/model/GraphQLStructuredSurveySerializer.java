package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UPSELL_SUGGESTION */
public class GraphQLStructuredSurveySerializer extends JsonSerializer<GraphQLStructuredSurvey> {
    public final void m21997a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStructuredSurvey__JsonHelper.m21999a(jsonGenerator, (GraphQLStructuredSurvey) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLStructuredSurvey.class, new GraphQLStructuredSurveySerializer());
    }
}
