package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: entity_card_context_items */
public final class GraphQLPageAdminInfo__JsonHelper {
    public static GraphQLPageAdminInfo m9467a(JsonParser jsonParser) {
        GraphQLPageAdminInfo graphQLPageAdminInfo = new GraphQLPageAdminInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m9469a(graphQLPageAdminInfo, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPageAdminInfo;
    }

    private static boolean m9469a(GraphQLPageAdminInfo graphQLPageAdminInfo, String str, JsonParser jsonParser) {
        GraphQLViewer graphQLViewer = null;
        if ("all_scheduled_posts".equals(str)) {
            GraphQLAllScheduledPostsConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLAllScheduledPostsConnection__JsonHelper.m6528a(FieldAccessQueryTracker.a(jsonParser, "all_scheduled_posts"));
            }
            graphQLPageAdminInfo.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPageAdminInfo, "all_scheduled_posts", graphQLPageAdminInfo.a_, 0, true);
            return true;
        } else if ("boosted_local_awareness_promotion_status_description".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPageAdminInfo.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPageAdminInfo, "boosted_local_awareness_promotion_status_description", graphQLPageAdminInfo.B_(), 1, false);
            return true;
        } else if ("boosted_page_like_promotion_status_description".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLPageAdminInfo.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPageAdminInfo, "boosted_page_like_promotion_status_description", graphQLPageAdminInfo.B_(), 2, false);
            return true;
        } else if ("boosted_post_default_audience".equals(str)) {
            graphQLPageAdminInfo.g = GraphQLBoostedPostAudienceOption.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPageAdminInfo, "boosted_post_default_audience", graphQLPageAdminInfo.B_(), 3, false);
            return true;
        } else if ("budget_recommendations".equals(str)) {
            GraphQLBudgetRecommendationsConnection a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLBudgetRecommendationsConnection__JsonHelper.m6688a(FieldAccessQueryTracker.a(jsonParser, "budget_recommendations"));
            }
            graphQLPageAdminInfo.h = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPageAdminInfo, "budget_recommendations", graphQLPageAdminInfo.B_(), 4, true);
            return true;
        } else if ("can_viewer_promote".equals(str)) {
            graphQLPageAdminInfo.i = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPageAdminInfo, "can_viewer_promote", graphQLPageAdminInfo.B_(), 5, false);
            return true;
        } else if ("can_viewer_promote_for_page_likes".equals(str)) {
            graphQLPageAdminInfo.j = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPageAdminInfo, "can_viewer_promote_for_page_likes", graphQLPageAdminInfo.B_(), 6, false);
            return true;
        } else if ("can_viewer_promote_local_awareness".equals(str)) {
            graphQLPageAdminInfo.k = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPageAdminInfo, "can_viewer_promote_local_awareness", graphQLPageAdminInfo.B_(), 7, false);
            return true;
        } else if ("can_viewer_promote_website".equals(str)) {
            graphQLPageAdminInfo.l = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPageAdminInfo, "can_viewer_promote_website", graphQLPageAdminInfo.B_(), 8, false);
            return true;
        } else if ("default_duration_for_boosted_post".equals(str)) {
            graphQLPageAdminInfo.m = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPageAdminInfo, "default_duration_for_boosted_post", graphQLPageAdminInfo.B_(), 9, false);
            return true;
        } else if ("does_viewer_pin".equals(str)) {
            graphQLPageAdminInfo.n = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPageAdminInfo, "does_viewer_pin", graphQLPageAdminInfo.B_(), 10, false);
            return true;
        } else if ("has_boosted_posts".equals(str)) {
            graphQLPageAdminInfo.o = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPageAdminInfo, "has_boosted_posts", graphQLPageAdminInfo.B_(), 11, false);
            return true;
        } else if ("is_likely_to_advertise".equals(str)) {
            graphQLPageAdminInfo.p = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPageAdminInfo, "is_likely_to_advertise", graphQLPageAdminInfo.B_(), 12, false);
            return true;
        } else if ("is_viewer_business_manager_admin".equals(str)) {
            graphQLPageAdminInfo.q = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPageAdminInfo, "is_viewer_business_manager_admin", graphQLPageAdminInfo.B_(), 13, false);
            return true;
        } else if ("messaging_enabled".equals(str)) {
            graphQLPageAdminInfo.r = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPageAdminInfo, "messaging_enabled", graphQLPageAdminInfo.B_(), 15, false);
            return true;
        } else if ("page_scheduled_deletion_time".equals(str)) {
            graphQLPageAdminInfo.s = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLPageAdminInfo, "page_scheduled_deletion_time", graphQLPageAdminInfo.B_(), 16, false);
            return true;
        } else if ("viewer".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLViewer = GraphQLViewer__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "viewer"));
            }
            graphQLPageAdminInfo.t = graphQLViewer;
            FieldAccessQueryTracker.a(jsonParser, graphQLPageAdminInfo, "viewer", graphQLPageAdminInfo.B_(), 17, true);
            return true;
        } else if (!"can_viewer_promote_cta".equals(str)) {
            return false;
        } else {
            graphQLPageAdminInfo.u = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPageAdminInfo, "can_viewer_promote_cta", graphQLPageAdminInfo.B_(), 18, false);
            return true;
        }
    }

    public static void m9468a(JsonGenerator jsonGenerator, GraphQLPageAdminInfo graphQLPageAdminInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPageAdminInfo.a() != null) {
            jsonGenerator.a("all_scheduled_posts");
            GraphQLAllScheduledPostsConnection__JsonHelper.m6529a(jsonGenerator, graphQLPageAdminInfo.a(), true);
        }
        if (graphQLPageAdminInfo.j() != null) {
            jsonGenerator.a("boosted_local_awareness_promotion_status_description", graphQLPageAdminInfo.j());
        }
        if (graphQLPageAdminInfo.k() != null) {
            jsonGenerator.a("boosted_page_like_promotion_status_description", graphQLPageAdminInfo.k());
        }
        if (graphQLPageAdminInfo.l() != null) {
            jsonGenerator.a("boosted_post_default_audience", graphQLPageAdminInfo.l().toString());
        }
        if (graphQLPageAdminInfo.m() != null) {
            jsonGenerator.a("budget_recommendations");
            GraphQLBudgetRecommendationsConnection__JsonHelper.m6689a(jsonGenerator, graphQLPageAdminInfo.m(), true);
        }
        jsonGenerator.a("can_viewer_promote", graphQLPageAdminInfo.n());
        jsonGenerator.a("can_viewer_promote_for_page_likes", graphQLPageAdminInfo.o());
        jsonGenerator.a("can_viewer_promote_local_awareness", graphQLPageAdminInfo.p());
        jsonGenerator.a("can_viewer_promote_website", graphQLPageAdminInfo.q());
        jsonGenerator.a("default_duration_for_boosted_post", graphQLPageAdminInfo.r());
        jsonGenerator.a("does_viewer_pin", graphQLPageAdminInfo.s());
        jsonGenerator.a("has_boosted_posts", graphQLPageAdminInfo.t());
        jsonGenerator.a("is_likely_to_advertise", graphQLPageAdminInfo.u());
        jsonGenerator.a("is_viewer_business_manager_admin", graphQLPageAdminInfo.v());
        jsonGenerator.a("messaging_enabled", graphQLPageAdminInfo.w());
        jsonGenerator.a("page_scheduled_deletion_time", graphQLPageAdminInfo.x());
        if (graphQLPageAdminInfo.y() != null) {
            jsonGenerator.a("viewer");
            GraphQLViewer__JsonHelper.a(jsonGenerator, graphQLPageAdminInfo.y(), true);
        }
        jsonGenerator.a("can_viewer_promote_cta", graphQLPageAdminInfo.z());
        if (z) {
            jsonGenerator.g();
        }
    }
}
