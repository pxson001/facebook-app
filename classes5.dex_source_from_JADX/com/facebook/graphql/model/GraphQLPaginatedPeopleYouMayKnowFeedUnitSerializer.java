package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WRAPPER_ARRAY */
public class GraphQLPaginatedPeopleYouMayKnowFeedUnitSerializer extends JsonSerializer<GraphQLPaginatedPeopleYouMayKnowFeedUnit> {
    public final void m20616a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit = (GraphQLPaginatedPeopleYouMayKnowFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLPaginatedPeopleYouMayKnowFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLPaginatedPeopleYouMayKnowFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLPaginatedPeopleYouMayKnowFeedUnit.o() != null) {
            jsonGenerator.a("all_users");
            C1160xc690a2f6.m20624a(jsonGenerator, graphQLPaginatedPeopleYouMayKnowFeedUnit.o(), true);
        }
        if (graphQLPaginatedPeopleYouMayKnowFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLPaginatedPeopleYouMayKnowFeedUnit.g());
        }
        if (graphQLPaginatedPeopleYouMayKnowFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLPaginatedPeopleYouMayKnowFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLPaginatedPeopleYouMayKnowFeedUnit.T_());
        if (graphQLPaginatedPeopleYouMayKnowFeedUnit.p() != null) {
            jsonGenerator.a("id", graphQLPaginatedPeopleYouMayKnowFeedUnit.p());
        }
        if (graphQLPaginatedPeopleYouMayKnowFeedUnit.q() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLPaginatedPeopleYouMayKnowFeedUnit.q());
        }
        if (graphQLPaginatedPeopleYouMayKnowFeedUnit.r() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPaginatedPeopleYouMayKnowFeedUnit.r(), true);
        }
        if (graphQLPaginatedPeopleYouMayKnowFeedUnit.s() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPaginatedPeopleYouMayKnowFeedUnit.s(), true);
        }
        if (graphQLPaginatedPeopleYouMayKnowFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLPaginatedPeopleYouMayKnowFeedUnit.k());
        }
        if (graphQLPaginatedPeopleYouMayKnowFeedUnit.t() != null) {
            jsonGenerator.a("url", graphQLPaginatedPeopleYouMayKnowFeedUnit.t());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLPaginatedPeopleYouMayKnowFeedUnit.class, new GraphQLPaginatedPeopleYouMayKnowFeedUnitSerializer());
    }
}
