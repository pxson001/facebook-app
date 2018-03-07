package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: keyword_search */
public class GraphQLAdsExperienceDeclineResponsePayloadSerializer extends JsonSerializer<GraphQLAdsExperienceDeclineResponsePayload> {
    public final void m6470a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAdsExperienceDeclineResponsePayload graphQLAdsExperienceDeclineResponsePayload = (GraphQLAdsExperienceDeclineResponsePayload) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLAdsExperienceDeclineResponsePayload.m6467a() != null) {
            jsonGenerator.a("viewer");
            GraphQLViewer__JsonHelper.a(jsonGenerator, graphQLAdsExperienceDeclineResponsePayload.m6467a(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLAdsExperienceDeclineResponsePayload.class, new GraphQLAdsExperienceDeclineResponsePayloadSerializer());
    }
}
