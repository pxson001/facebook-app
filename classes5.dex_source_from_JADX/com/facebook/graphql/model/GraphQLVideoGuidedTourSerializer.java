package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: There was no converter wrapped in this ConverterWrapper. */
public class GraphQLVideoGuidedTourSerializer extends JsonSerializer<GraphQLVideoGuidedTour> {
    public final void m22464a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLVideoGuidedTour__JsonHelper.m22466a(jsonGenerator, (GraphQLVideoGuidedTour) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLVideoGuidedTour.class, new GraphQLVideoGuidedTourSerializer());
    }
}
