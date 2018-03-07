package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_checkin */
public class GraphQLClientBumpingPlaceHolderFeedUnitSerializer extends JsonSerializer<GraphQLClientBumpingPlaceHolderFeedUnit> {
    public final void m6789a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLClientBumpingPlaceHolderFeedUnit graphQLClientBumpingPlaceHolderFeedUnit = (GraphQLClientBumpingPlaceHolderFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLClientBumpingPlaceHolderFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLClientBumpingPlaceHolderFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLClientBumpingPlaceHolderFeedUnit.m6785k() != null) {
            jsonGenerator.a("bump_story_deduplication_key", graphQLClientBumpingPlaceHolderFeedUnit.m6785k());
        }
        if (graphQLClientBumpingPlaceHolderFeedUnit.m6783g() != null) {
            jsonGenerator.a("cache_id", graphQLClientBumpingPlaceHolderFeedUnit.m6783g());
        }
        if (graphQLClientBumpingPlaceHolderFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLClientBumpingPlaceHolderFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLClientBumpingPlaceHolderFeedUnit.T_());
        if (graphQLClientBumpingPlaceHolderFeedUnit.m6786l() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLClientBumpingPlaceHolderFeedUnit.m6786l());
        }
        if (graphQLClientBumpingPlaceHolderFeedUnit.m6787m() != null) {
            jsonGenerator.a("tracking", graphQLClientBumpingPlaceHolderFeedUnit.m6787m());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLClientBumpingPlaceHolderFeedUnit.class, new GraphQLClientBumpingPlaceHolderFeedUnitSerializer());
    }
}
