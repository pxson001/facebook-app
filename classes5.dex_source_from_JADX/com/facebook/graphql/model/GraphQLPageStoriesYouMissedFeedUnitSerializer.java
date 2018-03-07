package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: empty_feed */
public class GraphQLPageStoriesYouMissedFeedUnitSerializer extends JsonSerializer<GraphQLPageStoriesYouMissedFeedUnit> {
    public final void m9526a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageStoriesYouMissedFeedUnit graphQLPageStoriesYouMissedFeedUnit = (GraphQLPageStoriesYouMissedFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLPageStoriesYouMissedFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLPageStoriesYouMissedFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLPageStoriesYouMissedFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLPageStoriesYouMissedFeedUnit.g());
        }
        if (graphQLPageStoriesYouMissedFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLPageStoriesYouMissedFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLPageStoriesYouMissedFeedUnit.T_());
        if (graphQLPageStoriesYouMissedFeedUnit.l() != null) {
            jsonGenerator.a("page_stories");
            GraphQLPageStoriesYouMissedFeedUnitStoriesConnection__JsonHelper.m9536a(jsonGenerator, graphQLPageStoriesYouMissedFeedUnit.l(), true);
        }
        if (graphQLPageStoriesYouMissedFeedUnit.r() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLPageStoriesYouMissedFeedUnit.r());
        }
        if (graphQLPageStoriesYouMissedFeedUnit.s() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPageStoriesYouMissedFeedUnit.s(), true);
        }
        if (graphQLPageStoriesYouMissedFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLPageStoriesYouMissedFeedUnit.k());
        }
        if (graphQLPageStoriesYouMissedFeedUnit.t() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLPageStoriesYouMissedFeedUnit.t());
        }
        if (graphQLPageStoriesYouMissedFeedUnit.u() != null) {
            jsonGenerator.a("local_story_visibility", graphQLPageStoriesYouMissedFeedUnit.u());
        }
        jsonGenerator.a("local_story_visible_height", graphQLPageStoriesYouMissedFeedUnit.x());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLPageStoriesYouMissedFeedUnit.class, new GraphQLPageStoriesYouMissedFeedUnitSerializer());
    }
}
