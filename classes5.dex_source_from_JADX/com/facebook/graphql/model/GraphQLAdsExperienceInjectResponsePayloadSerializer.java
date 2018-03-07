package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: keyValues= */
public class GraphQLAdsExperienceInjectResponsePayloadSerializer extends JsonSerializer<GraphQLAdsExperienceInjectResponsePayload> {
    public final void m6479a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAdsExperienceInjectResponsePayload graphQLAdsExperienceInjectResponsePayload = (GraphQLAdsExperienceInjectResponsePayload) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        jsonGenerator.a("inject_status", graphQLAdsExperienceInjectResponsePayload.m6476a());
        if (graphQLAdsExperienceInjectResponsePayload.m6477j() != null) {
            jsonGenerator.a("viewer");
            GraphQLViewer__JsonHelper.a(jsonGenerator, graphQLAdsExperienceInjectResponsePayload.m6477j(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLAdsExperienceInjectResponsePayload.class, new GraphQLAdsExperienceInjectResponsePayloadSerializer());
    }
}
