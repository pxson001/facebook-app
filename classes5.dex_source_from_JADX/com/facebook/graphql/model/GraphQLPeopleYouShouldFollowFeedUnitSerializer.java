package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WITHIN_MINUTES */
public class GraphQLPeopleYouShouldFollowFeedUnitSerializer extends JsonSerializer<GraphQLPeopleYouShouldFollowFeedUnit> {
    public final void m20708a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPeopleYouShouldFollowFeedUnit graphQLPeopleYouShouldFollowFeedUnit = (GraphQLPeopleYouShouldFollowFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLPeopleYouShouldFollowFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLPeopleYouShouldFollowFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLPeopleYouShouldFollowFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLPeopleYouShouldFollowFeedUnit.g());
        }
        if (graphQLPeopleYouShouldFollowFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLPeopleYouShouldFollowFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLPeopleYouShouldFollowFeedUnit.T_());
        if (graphQLPeopleYouShouldFollowFeedUnit.p() != null) {
            jsonGenerator.a("id", graphQLPeopleYouShouldFollowFeedUnit.p());
        }
        if (graphQLPeopleYouShouldFollowFeedUnit.q() != null) {
            jsonGenerator.a("pysfItems");
            GraphQLPeopleToFollowConnection__JsonHelper.m20641a(jsonGenerator, graphQLPeopleYouShouldFollowFeedUnit.q(), true);
        }
        if (graphQLPeopleYouShouldFollowFeedUnit.r() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLPeopleYouShouldFollowFeedUnit.r());
        }
        if (graphQLPeopleYouShouldFollowFeedUnit.s() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPeopleYouShouldFollowFeedUnit.s(), true);
        }
        if (graphQLPeopleYouShouldFollowFeedUnit.t() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPeopleYouShouldFollowFeedUnit.t(), true);
        }
        if (graphQLPeopleYouShouldFollowFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLPeopleYouShouldFollowFeedUnit.k());
        }
        if (graphQLPeopleYouShouldFollowFeedUnit.u() != null) {
            jsonGenerator.a("url", graphQLPeopleYouShouldFollowFeedUnit.u());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLPeopleYouShouldFollowFeedUnit.class, new GraphQLPeopleYouShouldFollowFeedUnitSerializer());
    }
}
