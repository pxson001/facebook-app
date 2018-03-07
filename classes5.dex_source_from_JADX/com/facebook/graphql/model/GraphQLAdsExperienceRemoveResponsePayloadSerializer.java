package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: key=? */
public class GraphQLAdsExperienceRemoveResponsePayloadSerializer extends JsonSerializer<GraphQLAdsExperienceRemoveResponsePayload> {
    public final void m6486a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAdsExperienceRemoveResponsePayload graphQLAdsExperienceRemoveResponsePayload = (GraphQLAdsExperienceRemoveResponsePayload) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLAdsExperienceRemoveResponsePayload.m6483a() != null) {
            jsonGenerator.a("viewer");
            GraphQLViewer__JsonHelper.a(jsonGenerator, graphQLAdsExperienceRemoveResponsePayload.m6483a(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLAdsExperienceRemoveResponsePayload.class, new GraphQLAdsExperienceRemoveResponsePayloadSerializer());
    }
}
