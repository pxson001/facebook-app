package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WATCH_MORE */
public class GraphQLPlaceReviewFeedUnitSerializer extends JsonSerializer<GraphQLPlaceReviewFeedUnit> {
    public final void m20912a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPlaceReviewFeedUnit graphQLPlaceReviewFeedUnit = (GraphQLPlaceReviewFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLPlaceReviewFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLPlaceReviewFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLPlaceReviewFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLPlaceReviewFeedUnit.g());
        }
        if (graphQLPlaceReviewFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLPlaceReviewFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLPlaceReviewFeedUnit.T_());
        jsonGenerator.a("items");
        if (graphQLPlaceReviewFeedUnit.l() != null) {
            jsonGenerator.d();
            for (GraphQLPlaceReviewFeedUnitItem graphQLPlaceReviewFeedUnitItem : graphQLPlaceReviewFeedUnit.l()) {
                if (graphQLPlaceReviewFeedUnitItem != null) {
                    GraphQLPlaceReviewFeedUnitItem__JsonHelper.m20910a(jsonGenerator, graphQLPlaceReviewFeedUnitItem, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPlaceReviewFeedUnit.o() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLPlaceReviewFeedUnit.o());
        }
        if (graphQLPlaceReviewFeedUnit.p() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPlaceReviewFeedUnit.p(), true);
        }
        if (graphQLPlaceReviewFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLPlaceReviewFeedUnit.k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLPlaceReviewFeedUnit.class, new GraphQLPlaceReviewFeedUnitSerializer());
    }
}
