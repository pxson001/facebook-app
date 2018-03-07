package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_silent */
public class GraphQLArticleChainingFeedUnitSerializer extends JsonSerializer<GraphQLArticleChainingFeedUnit> {
    public final void m6603a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLArticleChainingFeedUnit graphQLArticleChainingFeedUnit = (GraphQLArticleChainingFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLArticleChainingFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLArticleChainingFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLArticleChainingFeedUnit.o() != null) {
            jsonGenerator.a("articleChainingTitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLArticleChainingFeedUnit.o(), true);
        }
        if (graphQLArticleChainingFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLArticleChainingFeedUnit.g());
        }
        if (graphQLArticleChainingFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLArticleChainingFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLArticleChainingFeedUnit.T_());
        if (graphQLArticleChainingFeedUnit.p() != null) {
            jsonGenerator.a("id", graphQLArticleChainingFeedUnit.p());
        }
        if (graphQLArticleChainingFeedUnit.q() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLArticleChainingFeedUnit.q());
        }
        if (graphQLArticleChainingFeedUnit.r() != null) {
            jsonGenerator.a("suggested_content");
            GraphQLSuggestedContentConnection__JsonHelper.m22018a(jsonGenerator, graphQLArticleChainingFeedUnit.r(), true);
        }
        if (graphQLArticleChainingFeedUnit.s() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLArticleChainingFeedUnit.s(), true);
        }
        if (graphQLArticleChainingFeedUnit.t() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLArticleChainingFeedUnit.t(), true);
        }
        if (graphQLArticleChainingFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLArticleChainingFeedUnit.k());
        }
        if (graphQLArticleChainingFeedUnit.u() != null) {
            jsonGenerator.a("url", graphQLArticleChainingFeedUnit.u());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLArticleChainingFeedUnit.class, new GraphQLArticleChainingFeedUnitSerializer());
    }
}
