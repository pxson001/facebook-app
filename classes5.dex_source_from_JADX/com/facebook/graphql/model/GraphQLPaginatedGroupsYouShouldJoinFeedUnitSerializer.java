package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WRITE_CALLBACK_ERROR */
public class GraphQLPaginatedGroupsYouShouldJoinFeedUnitSerializer extends JsonSerializer<GraphQLPaginatedGroupsYouShouldJoinFeedUnit> {
    public final void m20609a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPaginatedGroupsYouShouldJoinFeedUnit graphQLPaginatedGroupsYouShouldJoinFeedUnit = (GraphQLPaginatedGroupsYouShouldJoinFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLPaginatedGroupsYouShouldJoinFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLPaginatedGroupsYouShouldJoinFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLPaginatedGroupsYouShouldJoinFeedUnit.o() != null) {
            jsonGenerator.a("all_groups");
            C1150x757fdcee.m20595a(jsonGenerator, graphQLPaginatedGroupsYouShouldJoinFeedUnit.o(), true);
        }
        if (graphQLPaginatedGroupsYouShouldJoinFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLPaginatedGroupsYouShouldJoinFeedUnit.g());
        }
        if (graphQLPaginatedGroupsYouShouldJoinFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLPaginatedGroupsYouShouldJoinFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLPaginatedGroupsYouShouldJoinFeedUnit.T_());
        if (graphQLPaginatedGroupsYouShouldJoinFeedUnit.p() != null) {
            jsonGenerator.a("id", graphQLPaginatedGroupsYouShouldJoinFeedUnit.p());
        }
        if (graphQLPaginatedGroupsYouShouldJoinFeedUnit.q() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLPaginatedGroupsYouShouldJoinFeedUnit.q());
        }
        if (graphQLPaginatedGroupsYouShouldJoinFeedUnit.r() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPaginatedGroupsYouShouldJoinFeedUnit.r(), true);
        }
        if (graphQLPaginatedGroupsYouShouldJoinFeedUnit.s() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPaginatedGroupsYouShouldJoinFeedUnit.s(), true);
        }
        if (graphQLPaginatedGroupsYouShouldJoinFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLPaginatedGroupsYouShouldJoinFeedUnit.k());
        }
        if (graphQLPaginatedGroupsYouShouldJoinFeedUnit.t() != null) {
            jsonGenerator.a("url", graphQLPaginatedGroupsYouShouldJoinFeedUnit.t());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLPaginatedGroupsYouShouldJoinFeedUnit.class, new GraphQLPaginatedGroupsYouShouldJoinFeedUnitSerializer());
    }
}
