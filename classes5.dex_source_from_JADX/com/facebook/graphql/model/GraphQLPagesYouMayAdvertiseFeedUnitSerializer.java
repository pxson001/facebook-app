package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: eglMakeCurrent failed */
public class GraphQLPagesYouMayAdvertiseFeedUnitSerializer extends JsonSerializer<GraphQLPagesYouMayAdvertiseFeedUnit> {
    public final void m9573a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPagesYouMayAdvertiseFeedUnit graphQLPagesYouMayAdvertiseFeedUnit = (GraphQLPagesYouMayAdvertiseFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLPagesYouMayAdvertiseFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLPagesYouMayAdvertiseFeedUnit.getType().e());
            jsonGenerator.g();
        }
        jsonGenerator.a("action_links");
        if (graphQLPagesYouMayAdvertiseFeedUnit.l() != null) {
            jsonGenerator.d();
            for (GraphQLStoryActionLink graphQLStoryActionLink : graphQLPagesYouMayAdvertiseFeedUnit.l()) {
                if (graphQLStoryActionLink != null) {
                    GraphQLStoryActionLink__JsonHelper.m21848a(jsonGenerator, graphQLStoryActionLink, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPagesYouMayAdvertiseFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLPagesYouMayAdvertiseFeedUnit.g());
        }
        if (graphQLPagesYouMayAdvertiseFeedUnit.r() != null) {
            jsonGenerator.a("category", graphQLPagesYouMayAdvertiseFeedUnit.r().toString());
        }
        if (graphQLPagesYouMayAdvertiseFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLPagesYouMayAdvertiseFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLPagesYouMayAdvertiseFeedUnit.T_());
        if (graphQLPagesYouMayAdvertiseFeedUnit.y() != null) {
            jsonGenerator.a("hideable_token", graphQLPagesYouMayAdvertiseFeedUnit.y());
        }
        jsonGenerator.a("items");
        if (graphQLPagesYouMayAdvertiseFeedUnit.s() != null) {
            jsonGenerator.d();
            for (GraphQLPagesYouMayAdvertiseFeedUnitItem graphQLPagesYouMayAdvertiseFeedUnitItem : graphQLPagesYouMayAdvertiseFeedUnit.s()) {
                if (graphQLPagesYouMayAdvertiseFeedUnitItem != null) {
                    GraphQLPagesYouMayAdvertiseFeedUnitItem__JsonHelper.m9571a(jsonGenerator, graphQLPagesYouMayAdvertiseFeedUnitItem, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPagesYouMayAdvertiseFeedUnit.t() != null) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9244a(jsonGenerator, graphQLPagesYouMayAdvertiseFeedUnit.t(), true);
        }
        if (graphQLPagesYouMayAdvertiseFeedUnit.u() != null) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLPagesYouMayAdvertiseFeedUnit.u(), true);
        }
        if (graphQLPagesYouMayAdvertiseFeedUnit.x() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLPagesYouMayAdvertiseFeedUnit.x());
        }
        if (graphQLPagesYouMayAdvertiseFeedUnit.z() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPagesYouMayAdvertiseFeedUnit.z(), true);
        }
        if (graphQLPagesYouMayAdvertiseFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLPagesYouMayAdvertiseFeedUnit.k());
        }
        if (graphQLPagesYouMayAdvertiseFeedUnit.A() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLPagesYouMayAdvertiseFeedUnit.A());
        }
        if (graphQLPagesYouMayAdvertiseFeedUnit.B() != null) {
            jsonGenerator.a("local_story_visibility", graphQLPagesYouMayAdvertiseFeedUnit.B());
        }
        jsonGenerator.a("local_story_visible_height", graphQLPagesYouMayAdvertiseFeedUnit.C());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLPagesYouMayAdvertiseFeedUnit.class, new GraphQLPagesYouMayAdvertiseFeedUnitSerializer());
    }
}
