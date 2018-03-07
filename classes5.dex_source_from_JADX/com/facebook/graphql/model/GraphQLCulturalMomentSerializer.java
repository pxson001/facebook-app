package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_suggestifier_voting */
public class GraphQLCulturalMomentSerializer extends JsonSerializer<GraphQLCulturalMoment> {
    public final void m6917a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCulturalMoment graphQLCulturalMoment = (GraphQLCulturalMoment) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLCulturalMoment.m6910j() != null) {
            jsonGenerator.a("cultural_moment_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLCulturalMoment.m6910j(), true);
        }
        if (graphQLCulturalMoment.m6911k() != null) {
            jsonGenerator.a("favicon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLCulturalMoment.m6911k(), true);
        }
        if (graphQLCulturalMoment.m6912l() != null) {
            jsonGenerator.a("id", graphQLCulturalMoment.m6912l());
        }
        if (graphQLCulturalMoment.m6913m() != null) {
            jsonGenerator.a("image_margin", graphQLCulturalMoment.m6913m());
        }
        if (graphQLCulturalMoment.m6914n() != null) {
            jsonGenerator.a("url", graphQLCulturalMoment.m6914n());
        }
        if (graphQLCulturalMoment.m6915o() != null) {
            jsonGenerator.a("cultural_moment_video");
            GraphQLVideo__JsonHelper.m22484a(jsonGenerator, graphQLCulturalMoment.m6915o(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLCulturalMoment.class, new GraphQLCulturalMomentSerializer());
    }
}
