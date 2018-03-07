package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friendEventMaybesFirst5 */
public class GraphQLGroupTopStoriesFeedUnitSerializer extends JsonSerializer<GraphQLGroupTopStoriesFeedUnit> {
    public final void m8497a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupTopStoriesFeedUnit graphQLGroupTopStoriesFeedUnit = (GraphQLGroupTopStoriesFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLGroupTopStoriesFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLGroupTopStoriesFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLGroupTopStoriesFeedUnit.l() != null) {
            jsonGenerator.a("all_top_stories");
            GraphQLGroupTopStoriesFeedUnitStoriesConnection__JsonHelper.m8507a(jsonGenerator, graphQLGroupTopStoriesFeedUnit.l(), true);
        }
        if (graphQLGroupTopStoriesFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLGroupTopStoriesFeedUnit.g());
        }
        if (graphQLGroupTopStoriesFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLGroupTopStoriesFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLGroupTopStoriesFeedUnit.T_());
        if (graphQLGroupTopStoriesFeedUnit.r() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLGroupTopStoriesFeedUnit.r());
        }
        if (graphQLGroupTopStoriesFeedUnit.s() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGroupTopStoriesFeedUnit.s(), true);
        }
        if (graphQLGroupTopStoriesFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLGroupTopStoriesFeedUnit.k());
        }
        if (graphQLGroupTopStoriesFeedUnit.t() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLGroupTopStoriesFeedUnit.t());
        }
        if (graphQLGroupTopStoriesFeedUnit.u() != null) {
            jsonGenerator.a("local_story_visibility", graphQLGroupTopStoriesFeedUnit.u());
        }
        jsonGenerator.a("local_story_visible_height", graphQLGroupTopStoriesFeedUnit.x());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLGroupTopStoriesFeedUnit.class, new GraphQLGroupTopStoriesFeedUnitSerializer());
    }
}
