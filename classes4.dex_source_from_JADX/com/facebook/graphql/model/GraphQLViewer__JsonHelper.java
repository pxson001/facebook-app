package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: sms_anonymous_chathead_rate_limit */
public final class GraphQLViewer__JsonHelper {
    public static GraphQLViewer m2232a(JsonParser jsonParser) {
        GraphQLViewer graphQLViewer = new GraphQLViewer();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m2234a(graphQLViewer, i, jsonParser);
            jsonParser.f();
        }
        return graphQLViewer;
    }

    private static boolean m2234a(GraphQLViewer graphQLViewer, String str, JsonParser jsonParser) {
        GraphQLEligibleClashUnitsConnection graphQLEligibleClashUnitsConnection = null;
        if ("account_user".equals(str)) {
            GraphQLUser a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLUser__JsonHelper.m3267a(FieldAccessQueryTracker.m2235a(jsonParser, "account_user"));
            }
            graphQLViewer.d = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "account_user", graphQLViewer.a_, 0, true);
            return true;
        } else if ("actor".equals(str)) {
            GraphQLActor a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLActor__JsonHelper.m3233a(FieldAccessQueryTracker.m2235a(jsonParser, "actor"));
            }
            graphQLViewer.e = a2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "actor", graphQLViewer.B_(), 1, true);
            return true;
        } else if ("additional_suggested_post_ads".equals(str)) {
            GraphQLAdditionalSuggestedPostAdItemsConnection a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLAdditionalSuggestedPostAdItemsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "additional_suggested_post_ads"));
            }
            graphQLViewer.f = a3;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "additional_suggested_post_ads", graphQLViewer.B_(), 2, true);
            return true;
        } else if ("audience_info".equals(str)) {
            GraphQLAudienceInfo a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLAudienceInfo__JsonHelper.m3913a(FieldAccessQueryTracker.m2235a(jsonParser, "audience_info"));
            }
            graphQLViewer.g = a4;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "audience_info", graphQLViewer.B_(), 3, true);
            return true;
        } else if ("composer_privacy_options".equals(str)) {
            GraphQLPrivacyOptionsComposerConnection a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLPrivacyOptionsComposerConnection__JsonHelper.m2240a(FieldAccessQueryTracker.m2235a(jsonParser, "composer_privacy_options"));
            }
            graphQLViewer.h = a5;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "composer_privacy_options", graphQLViewer.B_(), 4, true);
            return true;
        } else if ("current_location_page".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPage__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "current_location_page"));
            }
            graphQLViewer.i = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "current_location_page", graphQLViewer.B_(), 5, true);
            return true;
        } else if ("currently_processing_profile_video_content_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLViewer.j = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "currently_processing_profile_video_content_id", graphQLViewer.B_(), 6, false);
            return true;
        } else if ("daily_dialogue_pinned_unit".equals(str)) {
            GraphQLCustomizedStory a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLCustomizedStory__JsonHelper.m4778a(FieldAccessQueryTracker.m2235a(jsonParser, "daily_dialogue_pinned_unit"));
            }
            graphQLViewer.k = a6;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "daily_dialogue_pinned_unit", graphQLViewer.B_(), 7, true);
            return true;
        } else if ("debug_feed".equals(str)) {
            GraphQLDebugFeedConnection a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLDebugFeedConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "debug_feed"));
            }
            graphQLViewer.l = a7;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "debug_feed", graphQLViewer.B_(), 8, true);
            return true;
        } else if ("event_invitee_limit".equals(str)) {
            graphQLViewer.m = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "event_invitee_limit", graphQLViewer.B_(), 9, false);
            return true;
        } else if ("friending_possibilities".equals(str)) {
            GraphQLFriendingPossibilitiesConnection a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLFriendingPossibilitiesConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "friending_possibilities"));
            }
            graphQLViewer.n = a8;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "friending_possibilities", graphQLViewer.B_(), 10, true);
            return true;
        } else if ("group_commerce_suggested_location".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLPage__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "group_commerce_suggested_location"));
            }
            graphQLViewer.o = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "group_commerce_suggested_location", graphQLViewer.B_(), 11, true);
            return true;
        } else if ("happy_birthday_card".equals(str)) {
            GraphQLGoodwillHappyBirthdayCard a9;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a9 = GraphQLGoodwillHappyBirthdayCard__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "happy_birthday_card"));
            }
            graphQLViewer.p = a9;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "happy_birthday_card", graphQLViewer.B_(), 13, true);
            return true;
        } else if ("has_editable_search_history".equals(str)) {
            graphQLViewer.q = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "has_editable_search_history", graphQLViewer.B_(), 14, false);
            return true;
        } else if ("is_fb_employee".equals(str)) {
            graphQLViewer.r = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "is_fb_employee", graphQLViewer.B_(), 15, false);
            return true;
        } else if ("is_work_user".equals(str)) {
            graphQLViewer.s = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "is_work_user", graphQLViewer.B_(), 16, false);
            return true;
        } else if ("large_image_page_like_ads".equals(str)) {
            GraphQLStatelessLargeImagePLAsConnection a10;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a10 = GraphQLStatelessLargeImagePLAsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "large_image_page_like_ads"));
            }
            graphQLViewer.t = a10;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "large_image_page_like_ads", graphQLViewer.B_(), 17, true);
            return true;
        } else if ("megaphone".equals(str)) {
            GraphQLMegaphone a11;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a11 = GraphQLMegaphone__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "megaphone"));
            }
            graphQLViewer.u = a11;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "megaphone", graphQLViewer.B_(), 18, true);
            return true;
        } else if ("news_feed".equals(str)) {
            GraphQLNewsFeedConnection a12;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a12 = GraphQLNewsFeedConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "news_feed"));
            }
            graphQLViewer.v = a12;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "news_feed", graphQLViewer.B_(), 19, true);
            return true;
        } else if ("prefilled_greeting_card".equals(str)) {
            GraphQLGreetingCard a13;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a13 = GraphQLGreetingCard__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "prefilled_greeting_card"));
            }
            graphQLViewer.w = a13;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "prefilled_greeting_card", graphQLViewer.B_(), 21, true);
            return true;
        } else if ("primary_email".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLViewer.x = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "primary_email", graphQLViewer.B_(), 22, false);
            return true;
        } else if ("side_feed".equals(str)) {
            GraphQLSideFeedConnection a14;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a14 = GraphQLSideFeedConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "side_feed"));
            }
            graphQLViewer.y = a14;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "side_feed", graphQLViewer.B_(), 23, true);
            return true;
        } else if ("taggable_activities".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLTaggableActivity a15 = GraphQLTaggableActivity__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "taggable_activities"));
                    if (a15 != null) {
                        arrayList.add(a15);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLViewer.z = copyOf;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "taggable_activities", graphQLViewer.B_(), 24, true);
            return true;
        } else if ("video_home_badge_check_interval_s".equals(str)) {
            graphQLViewer.A = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "video_home_badge_check_interval_s", graphQLViewer.B_(), 25, false);
            return true;
        } else if ("video_home_badge_count".equals(str)) {
            graphQLViewer.B = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "video_home_badge_count", graphQLViewer.B_(), 26, false);
            return true;
        } else if ("video_home_max_badge_count".equals(str)) {
            graphQLViewer.C = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "video_home_max_badge_count", graphQLViewer.B_(), 27, false);
            return true;
        } else if ("video_home_prefetch_unit_count".equals(str)) {
            graphQLViewer.D = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "video_home_prefetch_unit_count", graphQLViewer.B_(), 28, false);
            return true;
        } else if ("video_home_stale_data_interval_s".equals(str)) {
            graphQLViewer.E = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "video_home_stale_data_interval_s", graphQLViewer.B_(), 29, false);
            return true;
        } else if ("viewer_tag_suggestions_mediaset".equals(str)) {
            GraphQLMediaSet a16;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a16 = GraphQLMediaSet__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "viewer_tag_suggestions_mediaset"));
            }
            graphQLViewer.F = a16;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "viewer_tag_suggestions_mediaset", graphQLViewer.B_(), 30, true);
            return true;
        } else if ("work_community".equals(str)) {
            GraphQLGroup a17;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a17 = GraphQLGroup__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "work_community"));
            }
            graphQLViewer.G = a17;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "work_community", graphQLViewer.B_(), 31, true);
            return true;
        } else if ("instream_video_ads".equals(str)) {
            GraphQLInstreamVideoAdsConnection a18;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a18 = GraphQLInstreamVideoAdsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "instream_video_ads"));
            }
            graphQLViewer.H = a18;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "instream_video_ads", graphQLViewer.B_(), 33, true);
            return true;
        } else if ("work_subdomain".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLViewer.I = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "work_subdomain", graphQLViewer.B_(), 35, false);
            return true;
        } else if (!"eligible_clash_units".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLEligibleClashUnitsConnection = GraphQLEligibleClashUnitsConnection__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "eligible_clash_units"));
            }
            graphQLViewer.J = graphQLEligibleClashUnitsConnection;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLViewer, "eligible_clash_units", graphQLViewer.B_(), 36, true);
            return true;
        }
    }

    public static void m2233a(JsonGenerator jsonGenerator, GraphQLViewer graphQLViewer, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLViewer.a() != null) {
            jsonGenerator.a("account_user");
            GraphQLUser__JsonHelper.m3268a(jsonGenerator, graphQLViewer.a(), true);
        }
        if (graphQLViewer.j() != null) {
            jsonGenerator.a("actor");
            GraphQLActor__JsonHelper.m3234a(jsonGenerator, graphQLViewer.j(), true);
        }
        if (graphQLViewer.k() != null) {
            jsonGenerator.a("additional_suggested_post_ads");
            GraphQLAdditionalSuggestedPostAdItemsConnection__JsonHelper.a(jsonGenerator, graphQLViewer.k(), true);
        }
        if (graphQLViewer.l() != null) {
            jsonGenerator.a("audience_info");
            GraphQLAudienceInfo__JsonHelper.m3914a(jsonGenerator, graphQLViewer.l(), true);
        }
        if (graphQLViewer.m() != null) {
            jsonGenerator.a("composer_privacy_options");
            GraphQLPrivacyOptionsComposerConnection__JsonHelper.m2241a(jsonGenerator, graphQLViewer.m(), true);
        }
        if (graphQLViewer.n() != null) {
            jsonGenerator.a("current_location_page");
            GraphQLPage__JsonHelper.a(jsonGenerator, graphQLViewer.n(), true);
        }
        if (graphQLViewer.o() != null) {
            jsonGenerator.a("currently_processing_profile_video_content_id", graphQLViewer.o());
        }
        if (graphQLViewer.p() != null) {
            jsonGenerator.a("daily_dialogue_pinned_unit");
            GraphQLCustomizedStory__JsonHelper.m4779a(jsonGenerator, graphQLViewer.p(), true);
        }
        if (graphQLViewer.q() != null) {
            jsonGenerator.a("debug_feed");
            GraphQLDebugFeedConnection__JsonHelper.a(jsonGenerator, graphQLViewer.q(), true);
        }
        jsonGenerator.a("event_invitee_limit", graphQLViewer.r());
        if (graphQLViewer.s() != null) {
            jsonGenerator.a("friending_possibilities");
            GraphQLFriendingPossibilitiesConnection__JsonHelper.a(jsonGenerator, graphQLViewer.s(), true);
        }
        if (graphQLViewer.t() != null) {
            jsonGenerator.a("group_commerce_suggested_location");
            GraphQLPage__JsonHelper.a(jsonGenerator, graphQLViewer.t(), true);
        }
        if (graphQLViewer.u() != null) {
            jsonGenerator.a("happy_birthday_card");
            GraphQLGoodwillHappyBirthdayCard__JsonHelper.a(jsonGenerator, graphQLViewer.u(), true);
        }
        jsonGenerator.a("has_editable_search_history", graphQLViewer.v());
        jsonGenerator.a("is_fb_employee", graphQLViewer.w());
        jsonGenerator.a("is_work_user", graphQLViewer.x());
        if (graphQLViewer.y() != null) {
            jsonGenerator.a("large_image_page_like_ads");
            GraphQLStatelessLargeImagePLAsConnection__JsonHelper.a(jsonGenerator, graphQLViewer.y(), true);
        }
        if (graphQLViewer.z() != null) {
            jsonGenerator.a("megaphone");
            GraphQLMegaphone__JsonHelper.a(jsonGenerator, graphQLViewer.z(), true);
        }
        if (graphQLViewer.A() != null) {
            jsonGenerator.a("news_feed");
            GraphQLNewsFeedConnection__JsonHelper.a(jsonGenerator, graphQLViewer.A(), true);
        }
        if (graphQLViewer.B() != null) {
            jsonGenerator.a("prefilled_greeting_card");
            GraphQLGreetingCard__JsonHelper.a(jsonGenerator, graphQLViewer.B(), true);
        }
        if (graphQLViewer.C() != null) {
            jsonGenerator.a("primary_email", graphQLViewer.C());
        }
        if (graphQLViewer.D() != null) {
            jsonGenerator.a("side_feed");
            GraphQLSideFeedConnection__JsonHelper.a(jsonGenerator, graphQLViewer.D(), true);
        }
        jsonGenerator.a("taggable_activities");
        if (graphQLViewer.E() != null) {
            jsonGenerator.d();
            for (GraphQLTaggableActivity graphQLTaggableActivity : graphQLViewer.E()) {
                if (graphQLTaggableActivity != null) {
                    GraphQLTaggableActivity__JsonHelper.a(jsonGenerator, graphQLTaggableActivity, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("video_home_badge_check_interval_s", graphQLViewer.F());
        jsonGenerator.a("video_home_badge_count", graphQLViewer.G());
        jsonGenerator.a("video_home_max_badge_count", graphQLViewer.H());
        jsonGenerator.a("video_home_prefetch_unit_count", graphQLViewer.I());
        jsonGenerator.a("video_home_stale_data_interval_s", graphQLViewer.J());
        if (graphQLViewer.K() != null) {
            jsonGenerator.a("viewer_tag_suggestions_mediaset");
            GraphQLMediaSet__JsonHelper.a(jsonGenerator, graphQLViewer.K(), true);
        }
        if (graphQLViewer.L() != null) {
            jsonGenerator.a("work_community");
            GraphQLGroup__JsonHelper.a(jsonGenerator, graphQLViewer.L(), true);
        }
        if (graphQLViewer.M() != null) {
            jsonGenerator.a("instream_video_ads");
            GraphQLInstreamVideoAdsConnection__JsonHelper.a(jsonGenerator, graphQLViewer.M(), true);
        }
        if (graphQLViewer.N() != null) {
            jsonGenerator.a("work_subdomain", graphQLViewer.N());
        }
        if (graphQLViewer.O() != null) {
            jsonGenerator.a("eligible_clash_units");
            GraphQLEligibleClashUnitsConnection__JsonHelper.a(jsonGenerator, graphQLViewer.O(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
