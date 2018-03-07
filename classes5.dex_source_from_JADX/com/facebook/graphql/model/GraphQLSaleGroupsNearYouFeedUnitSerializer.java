package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO */
public class GraphQLSaleGroupsNearYouFeedUnitSerializer extends JsonSerializer<GraphQLSaleGroupsNearYouFeedUnit> {
    public final void m21530a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit = (GraphQLSaleGroupsNearYouFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLSaleGroupsNearYouFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLSaleGroupsNearYouFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLSaleGroupsNearYouFeedUnit.o() != null) {
            jsonGenerator.a("all_sale_groups");
            GraphQLSaleGroupsNearYouFeedUnitGroupsConnection__JsonHelper.m21518a(jsonGenerator, graphQLSaleGroupsNearYouFeedUnit.o(), true);
        }
        if (graphQLSaleGroupsNearYouFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLSaleGroupsNearYouFeedUnit.g());
        }
        if (graphQLSaleGroupsNearYouFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLSaleGroupsNearYouFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLSaleGroupsNearYouFeedUnit.T_());
        if (graphQLSaleGroupsNearYouFeedUnit.p() != null) {
            jsonGenerator.a("id", graphQLSaleGroupsNearYouFeedUnit.p());
        }
        if (graphQLSaleGroupsNearYouFeedUnit.q() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLSaleGroupsNearYouFeedUnit.q());
        }
        if (graphQLSaleGroupsNearYouFeedUnit.r() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLSaleGroupsNearYouFeedUnit.r(), true);
        }
        if (graphQLSaleGroupsNearYouFeedUnit.s() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLSaleGroupsNearYouFeedUnit.s(), true);
        }
        if (graphQLSaleGroupsNearYouFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLSaleGroupsNearYouFeedUnit.k());
        }
        if (graphQLSaleGroupsNearYouFeedUnit.t() != null) {
            jsonGenerator.a("url", graphQLSaleGroupsNearYouFeedUnit.t());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLSaleGroupsNearYouFeedUnit.class, new GraphQLSaleGroupsNearYouFeedUnitSerializer());
    }
}
