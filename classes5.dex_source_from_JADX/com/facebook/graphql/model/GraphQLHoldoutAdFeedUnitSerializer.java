package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: footer_close_button */
public class GraphQLHoldoutAdFeedUnitSerializer extends JsonSerializer<GraphQLHoldoutAdFeedUnit> {
    public final void m8608a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLHoldoutAdFeedUnit graphQLHoldoutAdFeedUnit = (GraphQLHoldoutAdFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLHoldoutAdFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLHoldoutAdFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLHoldoutAdFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLHoldoutAdFeedUnit.g());
        }
        if (graphQLHoldoutAdFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLHoldoutAdFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLHoldoutAdFeedUnit.T_());
        if (graphQLHoldoutAdFeedUnit.m() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLHoldoutAdFeedUnit.m());
        }
        if (graphQLHoldoutAdFeedUnit.A() != null) {
            jsonGenerator.a("sponsored_data");
            GraphQLSponsoredData__JsonHelper.m21757a(jsonGenerator, graphQLHoldoutAdFeedUnit.A(), true);
        }
        if (graphQLHoldoutAdFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLHoldoutAdFeedUnit.k());
        }
        if (graphQLHoldoutAdFeedUnit.n() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLHoldoutAdFeedUnit.n());
        }
        if (graphQLHoldoutAdFeedUnit.r() != null) {
            jsonGenerator.a("local_story_visibility", graphQLHoldoutAdFeedUnit.r());
        }
        jsonGenerator.a("local_story_visible_height", graphQLHoldoutAdFeedUnit.s());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLHoldoutAdFeedUnit.class, new GraphQLHoldoutAdFeedUnitSerializer());
    }
}
