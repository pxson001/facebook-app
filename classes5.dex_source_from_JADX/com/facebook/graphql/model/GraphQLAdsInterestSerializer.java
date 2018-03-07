package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: jt13 */
public class GraphQLAdsInterestSerializer extends JsonSerializer<GraphQLAdsInterest> {
    public final void m6496a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAdsInterest graphQLAdsInterest = (GraphQLAdsInterest) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLAdsInterest.m6492j() != null) {
            jsonGenerator.a("id", graphQLAdsInterest.m6492j());
        }
        if (graphQLAdsInterest.m6493k() != null) {
            jsonGenerator.a("name", graphQLAdsInterest.m6493k());
        }
        if (graphQLAdsInterest.m6494l() != null) {
            jsonGenerator.a("url", graphQLAdsInterest.m6494l());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLAdsInterest.class, new GraphQLAdsInterestSerializer());
    }
}
