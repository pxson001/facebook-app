package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLCallToActionStyle;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType;
import com.facebook.graphql.enums.GraphQLStoryActionLinkDestinationType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: Unable to retrieve screen power stats */
public final class GraphQLStoryActionLink__JsonHelper {
    public static GraphQLStoryActionLink m21847a(JsonParser jsonParser) {
        GraphQLStoryActionLink graphQLStoryActionLink = new GraphQLStoryActionLink();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("__type__".equals(i)) {
                GraphQLObjectType graphQLObjectType;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLObjectType = null;
                } else {
                    graphQLObjectType = GraphQLObjectType.a(jsonParser);
                }
                graphQLStoryActionLink.d = graphQLObjectType;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "__type__", graphQLStoryActionLink.a_, 0, false);
            } else if ("action_link_type".equals(i)) {
                graphQLStoryActionLink.e = GraphQLProfilePictureActionLinkType.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "action_link_type", graphQLStoryActionLink.a_, 1, false);
            } else if ("ad_id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "ad_id", graphQLStoryActionLink.a_, 2, false);
            } else if ("agree_to_privacy_text".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "agree_to_privacy_text", graphQLStoryActionLink.a_, 3, false);
            } else if ("android_minimal_screen_form_height".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLStoryActionLink.h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "android_minimal_screen_form_height", graphQLStoryActionLink.a_, 4, false);
            } else if ("android_small_screen_phone_threshold".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLStoryActionLink.i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "android_small_screen_phone_threshold", graphQLStoryActionLink.a_, 5, false);
            } else if ("can_viewer_add_contributors".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLStoryActionLink.j = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "can_viewer_add_contributors", graphQLStoryActionLink.a_, 6, false);
            } else if ("can_watch_and_browse".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLStoryActionLink.k = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "can_watch_and_browse", graphQLStoryActionLink.a_, 7, false);
            } else if ("collection".equals(i)) {
                GraphQLTimelineAppCollection graphQLTimelineAppCollection;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLTimelineAppCollection = null;
                } else {
                    graphQLTimelineAppCollection = GraphQLTimelineAppCollection__JsonHelper.m22160a(FieldAccessQueryTracker.a(jsonParser, "collection"));
                }
                graphQLStoryActionLink.l = graphQLTimelineAppCollection;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "collection", graphQLStoryActionLink.a_, 8, true);
            } else if ("coupon".equals(i)) {
                GraphQLCoupon graphQLCoupon;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLCoupon = null;
                } else {
                    graphQLCoupon = GraphQLCoupon__JsonHelper.m6891a(FieldAccessQueryTracker.a(jsonParser, "coupon"));
                }
                graphQLStoryActionLink.m = graphQLCoupon;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "coupon", graphQLStoryActionLink.a_, 9, true);
            } else if ("default_expiration_time".equals(i)) {
                long j;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    j = 0;
                } else {
                    j = jsonParser.F();
                }
                graphQLStoryActionLink.n = j;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "default_expiration_time", graphQLStoryActionLink.a_, 10, false);
            } else if ("description".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "description"));
                }
                graphQLStoryActionLink.o = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "description", graphQLStoryActionLink.a_, 11, true);
            } else if ("destination_type".equals(i)) {
                graphQLStoryActionLink.p = GraphQLStoryActionLinkDestinationType.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "destination_type", graphQLStoryActionLink.a_, 12, false);
            } else if ("disclaimer_accept_button_text".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.q = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "disclaimer_accept_button_text", graphQLStoryActionLink.a_, 13, false);
            } else if ("disclaimer_continue_button_text".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.r = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "disclaimer_continue_button_text", graphQLStoryActionLink.a_, 14, false);
            } else if ("error_codes".equals(i)) {
                r3 = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r3 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLLeadGenErrorNode a = GraphQLLeadGenErrorNode__JsonHelper.m8833a(FieldAccessQueryTracker.a(jsonParser, "error_codes"));
                        if (a != null) {
                            r3.add(a);
                        }
                    }
                }
                if (r3 == null) {
                    r3 = null;
                } else {
                    r3 = ImmutableList.copyOf(r3);
                }
                graphQLStoryActionLink.s = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "error_codes", graphQLStoryActionLink.a_, 15, true);
            } else if ("error_message_brief".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.t = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "error_message_brief", graphQLStoryActionLink.a_, 16, false);
            } else if ("error_message_detail".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.u = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "error_message_detail", graphQLStoryActionLink.a_, 17, false);
            } else if ("event".equals(i)) {
                GraphQLEvent graphQLEvent;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLEvent = null;
                } else {
                    graphQLEvent = GraphQLEvent__JsonHelper.m7344a(FieldAccessQueryTracker.a(jsonParser, "event"));
                }
                graphQLStoryActionLink.v = graphQLEvent;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "event", graphQLStoryActionLink.a_, 18, true);
            } else if ("fb_data_policy_setting_description".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.w = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "fb_data_policy_setting_description", graphQLStoryActionLink.a_, 19, false);
            } else if ("fb_data_policy_url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.x = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "fb_data_policy_url", graphQLStoryActionLink.a_, 20, false);
            } else if ("feedback".equals(i)) {
                GraphQLFeedback graphQLFeedback;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLFeedback = null;
                } else {
                    graphQLFeedback = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
                }
                graphQLStoryActionLink.y = graphQLFeedback;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "feedback", graphQLStoryActionLink.a_, 21, true);
            } else if ("follow_up_action_text".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.z = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "follow_up_action_text", graphQLStoryActionLink.a_, 22, false);
            } else if ("follow_up_action_url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.A = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "follow_up_action_url", graphQLStoryActionLink.a_, 23, false);
            } else if ("group".equals(i)) {
                graphQLStoryActionLink.B = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLGroup__JsonHelper.m8518a(FieldAccessQueryTracker.a(jsonParser, "group"));
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "group", graphQLStoryActionLink.a_, 24, true);
            } else if ("group_story_chattable_members".equals(i)) {
                graphQLStoryActionLink.C = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLGroupMessageChattableMembersConnection__JsonHelper.m8475a(FieldAccessQueryTracker.a(jsonParser, "group_story_chattable_members"));
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "group_story_chattable_members", graphQLStoryActionLink.a_, 25, true);
            } else if ("info".equals(i)) {
                graphQLStoryActionLink.D = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLOverlayCallToActionInfo__JsonHelper.m9427a(FieldAccessQueryTracker.a(jsonParser, "info"));
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "info", graphQLStoryActionLink.a_, 26, true);
            } else if ("item".equals(i)) {
                graphQLStoryActionLink.E = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLNode__JsonHelper.m9292a(FieldAccessQueryTracker.a(jsonParser, "item"));
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "item", graphQLStoryActionLink.a_, 27, true);
            } else if ("landing_page_cta".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.F = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "landing_page_cta", graphQLStoryActionLink.a_, 28, false);
            } else if ("landing_page_redirect_instruction".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.G = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "landing_page_redirect_instruction", graphQLStoryActionLink.a_, 29, false);
            } else if ("lead_gen_data".equals(i)) {
                GraphQLLeadGenData graphQLLeadGenData;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLLeadGenData = null;
                } else {
                    graphQLLeadGenData = GraphQLLeadGenData__JsonHelper.m8820a(FieldAccessQueryTracker.a(jsonParser, "lead_gen_data"));
                }
                graphQLStoryActionLink.H = graphQLLeadGenData;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "lead_gen_data", graphQLStoryActionLink.a_, 30, true);
            } else if ("lead_gen_data_id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.I = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "lead_gen_data_id", graphQLStoryActionLink.a_, 31, false);
            } else if ("lead_gen_deep_link_user_status".equals(i)) {
                GraphQLLeadGenDeepLinkUserStatus graphQLLeadGenDeepLinkUserStatus;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLLeadGenDeepLinkUserStatus = null;
                } else {
                    graphQLLeadGenDeepLinkUserStatus = GraphQLLeadGenDeepLinkUserStatus__JsonHelper.m8827a(FieldAccessQueryTracker.a(jsonParser, "lead_gen_deep_link_user_status"));
                }
                graphQLStoryActionLink.J = graphQLLeadGenDeepLinkUserStatus;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "lead_gen_deep_link_user_status", graphQLStoryActionLink.a_, 32, true);
            } else if ("lead_gen_user_status".equals(i)) {
                GraphQLLeadGenUserStatus graphQLLeadGenUserStatus;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLLeadGenUserStatus = null;
                } else {
                    graphQLLeadGenUserStatus = GraphQLLeadGenUserStatus__JsonHelper.m8908a(FieldAccessQueryTracker.a(jsonParser, "lead_gen_user_status"));
                }
                graphQLStoryActionLink.K = graphQLLeadGenUserStatus;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "lead_gen_user_status", graphQLStoryActionLink.a_, 33, true);
            } else if ("link_description".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.L = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "link_description", graphQLStoryActionLink.a_, 34, false);
            } else if ("link_display".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.M = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "link_display", graphQLStoryActionLink.a_, 35, false);
            } else if ("link_icon_image".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "link_icon_image"));
                }
                graphQLStoryActionLink.N = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "link_icon_image", graphQLStoryActionLink.a_, 36, true);
            } else if ("link_style".equals(i)) {
                graphQLStoryActionLink.O = GraphQLCallToActionStyle.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "link_style", graphQLStoryActionLink.a_, 37, false);
            } else if ("link_target_store_data".equals(i)) {
                GraphQLLinkTargetStoreData graphQLLinkTargetStoreData;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLLinkTargetStoreData = null;
                } else {
                    graphQLLinkTargetStoreData = GraphQLLinkTargetStoreData__JsonHelper.m8947a(FieldAccessQueryTracker.a(jsonParser, "link_target_store_data"));
                }
                graphQLStoryActionLink.P = graphQLLinkTargetStoreData;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "link_target_store_data", graphQLStoryActionLink.a_, 38, true);
            } else if ("link_title".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.Q = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "link_title", graphQLStoryActionLink.a_, 39, false);
            } else if ("link_type".equals(i)) {
                graphQLStoryActionLink.R = GraphQLCallToActionType.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "link_type", graphQLStoryActionLink.a_, 40, false);
            } else if ("link_video_endscreen_icon".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "link_video_endscreen_icon"));
                }
                graphQLStoryActionLink.S = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "link_video_endscreen_icon", graphQLStoryActionLink.a_, 41, true);
            } else if ("message".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
                }
                graphQLStoryActionLink.T = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "message", graphQLStoryActionLink.a_, 42, true);
            } else if ("nux_description".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.U = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "nux_description", graphQLStoryActionLink.a_, 43, false);
            } else if ("nux_title".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.V = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "nux_title", graphQLStoryActionLink.a_, 44, false);
            } else if ("page".equals(i)) {
                GraphQLPage graphQLPage;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPage = null;
                } else {
                    graphQLPage = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "page"));
                }
                graphQLStoryActionLink.W = graphQLPage;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "page", graphQLStoryActionLink.a_, 45, true);
            } else if ("parent_story".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "parent_story"));
                }
                graphQLStoryActionLink.X = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "parent_story", graphQLStoryActionLink.a_, 46, true);
            } else if ("primary_button_text".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.Y = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "primary_button_text", graphQLStoryActionLink.a_, 47, false);
            } else if ("privacy_checkbox_error".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.Z = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "privacy_checkbox_error", graphQLStoryActionLink.a_, 48, false);
            } else if ("privacy_scope".equals(i)) {
                GraphQLPrivacyScope graphQLPrivacyScope;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPrivacyScope = null;
                } else {
                    graphQLPrivacyScope = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "privacy_scope"));
                }
                graphQLStoryActionLink.aa = graphQLPrivacyScope;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "privacy_scope", graphQLStoryActionLink.a_, 49, true);
            } else if ("privacy_setting_description".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.ab = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "privacy_setting_description", graphQLStoryActionLink.a_, 50, false);
            } else if ("profile".equals(i)) {
                GraphQLProfile graphQLProfile;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLProfile = null;
                } else {
                    graphQLProfile = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "profile"));
                }
                graphQLStoryActionLink.ac = graphQLProfile;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "profile", graphQLStoryActionLink.a_, 51, true);
            } else if ("progress_text".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.ad = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "progress_text", graphQLStoryActionLink.a_, 52, false);
            } else if ("promotion_tag".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.ae = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "promotion_tag", graphQLStoryActionLink.a_, 53, false);
            } else if ("review".equals(i)) {
                GraphQLContactRecommendationField graphQLContactRecommendationField;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLContactRecommendationField = null;
                } else {
                    graphQLContactRecommendationField = GraphQLContactRecommendationField__JsonHelper.m6880a(FieldAccessQueryTracker.a(jsonParser, "review"));
                }
                graphQLStoryActionLink.af = graphQLContactRecommendationField;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "review", graphQLStoryActionLink.a_, 54, true);
            } else if ("secure_sharing_text".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.ag = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "secure_sharing_text", graphQLStoryActionLink.a_, 55, false);
            } else if ("select_text_hint".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.ah = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "select_text_hint", graphQLStoryActionLink.a_, 56, false);
            } else if ("send_description".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.ai = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "send_description", graphQLStoryActionLink.a_, 57, false);
            } else if ("sent_text".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.aj = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "sent_text", graphQLStoryActionLink.a_, 58, false);
            } else if ("share_id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.ak = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "share_id", graphQLStoryActionLink.a_, 59, false);
            } else if ("short_secure_sharing_text".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.al = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "short_secure_sharing_text", graphQLStoryActionLink.a_, 60, false);
            } else if ("show_even_if_installed".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLStoryActionLink.am = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "show_even_if_installed", graphQLStoryActionLink.a_, 61, false);
            } else if ("show_in_feed".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLStoryActionLink.an = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "show_in_feed", graphQLStoryActionLink.a_, 62, false);
            } else if ("show_in_permalink".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLStoryActionLink.ao = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "show_in_permalink", graphQLStoryActionLink.a_, 63, false);
            } else if ("skip_experiments".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLStoryActionLink.ap = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "skip_experiments", graphQLStoryActionLink.a_, 64, false);
            } else if ("split_flow_landing_page_hint_text".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.aq = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "split_flow_landing_page_hint_text", graphQLStoryActionLink.a_, 65, false);
            } else if ("split_flow_landing_page_hint_title".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.ar = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "split_flow_landing_page_hint_title", graphQLStoryActionLink.a_, 66, false);
            } else if ("stateful_title".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.as = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "stateful_title", graphQLStoryActionLink.a_, 67, false);
            } else if ("sticker".equals(i)) {
                GraphQLImageOverlay graphQLImageOverlay;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLImageOverlay = null;
                } else {
                    graphQLImageOverlay = GraphQLImageOverlay__JsonHelper.m8630a(FieldAccessQueryTracker.a(jsonParser, "sticker"));
                }
                graphQLStoryActionLink.at = graphQLImageOverlay;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "sticker", graphQLStoryActionLink.a_, 68, true);
            } else if ("submit_card_instruction_text".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.au = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "submit_card_instruction_text", graphQLStoryActionLink.a_, 69, false);
            } else if ("tagged_and_mentioned_users".equals(i)) {
                GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection = null;
                } else {
                    graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection = C0272xa537f5eb.m6580a(FieldAccessQueryTracker.a(jsonParser, "tagged_and_mentioned_users"));
                }
                graphQLStoryActionLink.av = graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "tagged_and_mentioned_users", graphQLStoryActionLink.a_, 70, true);
            } else if ("temporal_event_info".equals(i)) {
                GraphQLTemporalEventInfo graphQLTemporalEventInfo;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLTemporalEventInfo = null;
                } else {
                    graphQLTemporalEventInfo = GraphQLTemporalEventInfo__JsonHelper.m22103a(FieldAccessQueryTracker.a(jsonParser, "temporal_event_info"));
                }
                graphQLStoryActionLink.aw = graphQLTemporalEventInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "temporal_event_info", graphQLStoryActionLink.a_, 71, true);
            } else if ("title".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.ax = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "title", graphQLStoryActionLink.a_, 72, false);
            } else if ("topic".equals(i)) {
                GraphQLTopic graphQLTopic;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLTopic = null;
                } else {
                    graphQLTopic = GraphQLTopic__JsonHelper.m22278a(FieldAccessQueryTracker.a(jsonParser, "topic"));
                }
                graphQLStoryActionLink.ay = graphQLTopic;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "topic", graphQLStoryActionLink.a_, 73, true);
            } else if ("unsubscribe_description".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.az = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "unsubscribe_description", graphQLStoryActionLink.a_, 74, false);
            } else if ("url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.aA = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "url", graphQLStoryActionLink.a_, 75, false);
            } else if ("prompt_id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.aB = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "prompt_id", graphQLStoryActionLink.a_, 76, false);
            } else if ("page_outcome_button".equals(i)) {
                GraphQLPageOutcomeButton graphQLPageOutcomeButton;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPageOutcomeButton = null;
                } else {
                    graphQLPageOutcomeButton = GraphQLPageOutcomeButton__JsonHelper.m9506a(FieldAccessQueryTracker.a(jsonParser, "page_outcome_button"));
                }
                graphQLStoryActionLink.aC = graphQLPageOutcomeButton;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "page_outcome_button", graphQLStoryActionLink.a_, 77, true);
            } else if ("frame_id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.aD = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "frame_id", graphQLStoryActionLink.a_, 78, false);
            } else if ("video_annotations".equals(i)) {
                r3 = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r3 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLVideoAnnotation a2 = GraphQLVideoAnnotation__JsonHelper.m22429a(FieldAccessQueryTracker.a(jsonParser, "video_annotations"));
                        if (a2 != null) {
                            r3.add(a2);
                        }
                    }
                }
                if (r3 == null) {
                    r3 = null;
                } else {
                    r3 = ImmutableList.copyOf(r3);
                }
                graphQLStoryActionLink.aE = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "video_annotations", graphQLStoryActionLink.a_, 79, true);
            } else if ("story".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "story"));
                }
                graphQLStoryActionLink.aF = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "story", graphQLStoryActionLink.a_, 80, true);
            } else if ("hoisted_story_ids".equals(i)) {
                r3 = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r3 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                        if (r4 != null) {
                            r3.add(r4);
                        }
                    }
                }
                if (r3 == null) {
                    r3 = null;
                } else {
                    r3 = ImmutableList.copyOf(r3);
                }
                graphQLStoryActionLink.aG = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "hoisted_story_ids", graphQLStoryActionLink.a_, 81, false);
            } else if ("followup_choices".equals(i)) {
                r3 = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r3 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                        if (r4 != null) {
                            r3.add(r4);
                        }
                    }
                }
                if (r3 == null) {
                    r3 = null;
                } else {
                    r3 = ImmutableList.copyOf(r3);
                }
                graphQLStoryActionLink.aH = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "followup_choices", graphQLStoryActionLink.a_, 82, false);
            } else if ("followup_question".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.aI = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "followup_question", graphQLStoryActionLink.a_, 83, false);
            } else if ("main_choices".equals(i)) {
                r3 = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r3 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                        if (r4 != null) {
                            r3.add(r4);
                        }
                    }
                }
                if (r3 == null) {
                    r3 = null;
                } else {
                    r3 = ImmutableList.copyOf(r3);
                }
                graphQLStoryActionLink.aJ = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "main_choices", graphQLStoryActionLink.a_, 84, false);
            } else if ("main_question".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.aK = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "main_question", graphQLStoryActionLink.a_, 85, false);
            } else if ("featured_instant_article_element".equals(i)) {
                GraphQLDocumentElement graphQLDocumentElement;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLDocumentElement = null;
                } else {
                    graphQLDocumentElement = GraphQLDocumentElement__JsonHelper.m6954a(FieldAccessQueryTracker.a(jsonParser, "featured_instant_article_element"));
                }
                graphQLStoryActionLink.aL = graphQLDocumentElement;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "featured_instant_article_element", graphQLStoryActionLink.a_, 86, true);
            } else if ("instant_article".equals(i)) {
                GraphQLInstantArticle graphQLInstantArticle;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLInstantArticle = null;
                } else {
                    graphQLInstantArticle = GraphQLInstantArticle__JsonHelper.m8732a(FieldAccessQueryTracker.a(jsonParser, "instant_article"));
                }
                graphQLStoryActionLink.aM = graphQLInstantArticle;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "instant_article", graphQLStoryActionLink.a_, 87, true);
            } else if ("header_color".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.aN = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "header_color", graphQLStoryActionLink.a_, 88, false);
            } else if ("logo_uri".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLStoryActionLink.aO = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "logo_uri", graphQLStoryActionLink.a_, 89, false);
            } else if ("rating".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLStoryActionLink.aP = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryActionLink, "rating", graphQLStoryActionLink.a_, 90, false);
            }
            jsonParser.f();
        }
        return graphQLStoryActionLink;
    }

    public static void m21848a(JsonGenerator jsonGenerator, GraphQLStoryActionLink graphQLStoryActionLink, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLStoryActionLink.a() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLStoryActionLink.a().e());
            jsonGenerator.g();
        }
        if (graphQLStoryActionLink.j() != null) {
            jsonGenerator.a("action_link_type", graphQLStoryActionLink.j().toString());
        }
        if (graphQLStoryActionLink.k() != null) {
            jsonGenerator.a("ad_id", graphQLStoryActionLink.k());
        }
        if (graphQLStoryActionLink.l() != null) {
            jsonGenerator.a("agree_to_privacy_text", graphQLStoryActionLink.l());
        }
        jsonGenerator.a("android_minimal_screen_form_height", graphQLStoryActionLink.m());
        jsonGenerator.a("android_small_screen_phone_threshold", graphQLStoryActionLink.n());
        jsonGenerator.a("can_viewer_add_contributors", graphQLStoryActionLink.o());
        jsonGenerator.a("can_watch_and_browse", graphQLStoryActionLink.p());
        if (graphQLStoryActionLink.q() != null) {
            jsonGenerator.a("collection");
            GraphQLTimelineAppCollection__JsonHelper.m22161a(jsonGenerator, graphQLStoryActionLink.q(), true);
        }
        if (graphQLStoryActionLink.r() != null) {
            jsonGenerator.a("coupon");
            GraphQLCoupon__JsonHelper.m6892a(jsonGenerator, graphQLStoryActionLink.r(), true);
        }
        jsonGenerator.a("default_expiration_time", graphQLStoryActionLink.s());
        if (graphQLStoryActionLink.t() != null) {
            jsonGenerator.a("description");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStoryActionLink.t(), true);
        }
        if (graphQLStoryActionLink.u() != null) {
            jsonGenerator.a("destination_type", graphQLStoryActionLink.u().toString());
        }
        if (graphQLStoryActionLink.v() != null) {
            jsonGenerator.a("disclaimer_accept_button_text", graphQLStoryActionLink.v());
        }
        if (graphQLStoryActionLink.w() != null) {
            jsonGenerator.a("disclaimer_continue_button_text", graphQLStoryActionLink.w());
        }
        jsonGenerator.a("error_codes");
        if (graphQLStoryActionLink.x() != null) {
            jsonGenerator.d();
            for (GraphQLLeadGenErrorNode graphQLLeadGenErrorNode : graphQLStoryActionLink.x()) {
                if (graphQLLeadGenErrorNode != null) {
                    GraphQLLeadGenErrorNode__JsonHelper.m8834a(jsonGenerator, graphQLLeadGenErrorNode, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStoryActionLink.y() != null) {
            jsonGenerator.a("error_message_brief", graphQLStoryActionLink.y());
        }
        if (graphQLStoryActionLink.z() != null) {
            jsonGenerator.a("error_message_detail", graphQLStoryActionLink.z());
        }
        if (graphQLStoryActionLink.A() != null) {
            jsonGenerator.a("event");
            GraphQLEvent__JsonHelper.m7345a(jsonGenerator, graphQLStoryActionLink.A(), true);
        }
        if (graphQLStoryActionLink.B() != null) {
            jsonGenerator.a("fb_data_policy_setting_description", graphQLStoryActionLink.B());
        }
        if (graphQLStoryActionLink.C() != null) {
            jsonGenerator.a("fb_data_policy_url", graphQLStoryActionLink.C());
        }
        if (graphQLStoryActionLink.D() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLStoryActionLink.D(), true);
        }
        if (graphQLStoryActionLink.E() != null) {
            jsonGenerator.a("follow_up_action_text", graphQLStoryActionLink.E());
        }
        if (graphQLStoryActionLink.F() != null) {
            jsonGenerator.a("follow_up_action_url", graphQLStoryActionLink.F());
        }
        if (graphQLStoryActionLink.G() != null) {
            jsonGenerator.a("group");
            GraphQLGroup__JsonHelper.m8519a(jsonGenerator, graphQLStoryActionLink.G(), true);
        }
        if (graphQLStoryActionLink.H() != null) {
            jsonGenerator.a("group_story_chattable_members");
            GraphQLGroupMessageChattableMembersConnection__JsonHelper.m8476a(jsonGenerator, graphQLStoryActionLink.H(), true);
        }
        if (graphQLStoryActionLink.I() != null) {
            jsonGenerator.a("info");
            GraphQLOverlayCallToActionInfo__JsonHelper.m9428a(jsonGenerator, graphQLStoryActionLink.I(), true);
        }
        if (graphQLStoryActionLink.J() != null) {
            jsonGenerator.a("item");
            GraphQLNode__JsonHelper.m9293a(jsonGenerator, graphQLStoryActionLink.J(), true);
        }
        if (graphQLStoryActionLink.K() != null) {
            jsonGenerator.a("landing_page_cta", graphQLStoryActionLink.K());
        }
        if (graphQLStoryActionLink.L() != null) {
            jsonGenerator.a("landing_page_redirect_instruction", graphQLStoryActionLink.L());
        }
        if (graphQLStoryActionLink.M() != null) {
            jsonGenerator.a("lead_gen_data");
            GraphQLLeadGenData__JsonHelper.m8821a(jsonGenerator, graphQLStoryActionLink.M(), true);
        }
        if (graphQLStoryActionLink.N() != null) {
            jsonGenerator.a("lead_gen_data_id", graphQLStoryActionLink.N());
        }
        if (graphQLStoryActionLink.O() != null) {
            jsonGenerator.a("lead_gen_deep_link_user_status");
            GraphQLLeadGenDeepLinkUserStatus__JsonHelper.m8828a(jsonGenerator, graphQLStoryActionLink.O(), true);
        }
        if (graphQLStoryActionLink.P() != null) {
            jsonGenerator.a("lead_gen_user_status");
            GraphQLLeadGenUserStatus__JsonHelper.m8909a(jsonGenerator, graphQLStoryActionLink.P(), true);
        }
        if (graphQLStoryActionLink.Q() != null) {
            jsonGenerator.a("link_description", graphQLStoryActionLink.Q());
        }
        if (graphQLStoryActionLink.R() != null) {
            jsonGenerator.a("link_display", graphQLStoryActionLink.R());
        }
        if (graphQLStoryActionLink.S() != null) {
            jsonGenerator.a("link_icon_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLStoryActionLink.S(), true);
        }
        if (graphQLStoryActionLink.T() != null) {
            jsonGenerator.a("link_style", graphQLStoryActionLink.T().toString());
        }
        if (graphQLStoryActionLink.U() != null) {
            jsonGenerator.a("link_target_store_data");
            GraphQLLinkTargetStoreData__JsonHelper.m8948a(jsonGenerator, graphQLStoryActionLink.U(), true);
        }
        if (graphQLStoryActionLink.V() != null) {
            jsonGenerator.a("link_title", graphQLStoryActionLink.V());
        }
        if (graphQLStoryActionLink.W() != null) {
            jsonGenerator.a("link_type", graphQLStoryActionLink.W().toString());
        }
        if (graphQLStoryActionLink.X() != null) {
            jsonGenerator.a("link_video_endscreen_icon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLStoryActionLink.X(), true);
        }
        if (graphQLStoryActionLink.Y() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStoryActionLink.Y(), true);
        }
        if (graphQLStoryActionLink.Z() != null) {
            jsonGenerator.a("nux_description", graphQLStoryActionLink.Z());
        }
        if (graphQLStoryActionLink.aa() != null) {
            jsonGenerator.a("nux_title", graphQLStoryActionLink.aa());
        }
        if (graphQLStoryActionLink.ab() != null) {
            jsonGenerator.a("page");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLStoryActionLink.ab(), true);
        }
        if (graphQLStoryActionLink.ac() != null) {
            jsonGenerator.a("parent_story");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLStoryActionLink.ac(), true);
        }
        if (graphQLStoryActionLink.ad() != null) {
            jsonGenerator.a("primary_button_text", graphQLStoryActionLink.ad());
        }
        if (graphQLStoryActionLink.ae() != null) {
            jsonGenerator.a("privacy_checkbox_error", graphQLStoryActionLink.ae());
        }
        if (graphQLStoryActionLink.af() != null) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLStoryActionLink.af(), true);
        }
        if (graphQLStoryActionLink.ag() != null) {
            jsonGenerator.a("privacy_setting_description", graphQLStoryActionLink.ag());
        }
        if (graphQLStoryActionLink.ah() != null) {
            jsonGenerator.a("profile");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLStoryActionLink.ah(), true);
        }
        if (graphQLStoryActionLink.ai() != null) {
            jsonGenerator.a("progress_text", graphQLStoryActionLink.ai());
        }
        if (graphQLStoryActionLink.aj() != null) {
            jsonGenerator.a("promotion_tag", graphQLStoryActionLink.aj());
        }
        if (graphQLStoryActionLink.ak() != null) {
            jsonGenerator.a("review");
            GraphQLContactRecommendationField__JsonHelper.m6881a(jsonGenerator, graphQLStoryActionLink.ak(), true);
        }
        if (graphQLStoryActionLink.al() != null) {
            jsonGenerator.a("secure_sharing_text", graphQLStoryActionLink.al());
        }
        if (graphQLStoryActionLink.am() != null) {
            jsonGenerator.a("select_text_hint", graphQLStoryActionLink.am());
        }
        if (graphQLStoryActionLink.an() != null) {
            jsonGenerator.a("send_description", graphQLStoryActionLink.an());
        }
        if (graphQLStoryActionLink.ao() != null) {
            jsonGenerator.a("sent_text", graphQLStoryActionLink.ao());
        }
        if (graphQLStoryActionLink.ap() != null) {
            jsonGenerator.a("share_id", graphQLStoryActionLink.ap());
        }
        if (graphQLStoryActionLink.aq() != null) {
            jsonGenerator.a("short_secure_sharing_text", graphQLStoryActionLink.aq());
        }
        jsonGenerator.a("show_even_if_installed", graphQLStoryActionLink.b());
        jsonGenerator.a("show_in_feed", graphQLStoryActionLink.ar());
        jsonGenerator.a("show_in_permalink", graphQLStoryActionLink.as());
        jsonGenerator.a("skip_experiments", graphQLStoryActionLink.at());
        if (graphQLStoryActionLink.au() != null) {
            jsonGenerator.a("split_flow_landing_page_hint_text", graphQLStoryActionLink.au());
        }
        if (graphQLStoryActionLink.av() != null) {
            jsonGenerator.a("split_flow_landing_page_hint_title", graphQLStoryActionLink.av());
        }
        if (graphQLStoryActionLink.aw() != null) {
            jsonGenerator.a("stateful_title", graphQLStoryActionLink.aw());
        }
        if (graphQLStoryActionLink.ax() != null) {
            jsonGenerator.a("sticker");
            GraphQLImageOverlay__JsonHelper.m8631a(jsonGenerator, graphQLStoryActionLink.ax(), true);
        }
        if (graphQLStoryActionLink.ay() != null) {
            jsonGenerator.a("submit_card_instruction_text", graphQLStoryActionLink.ay());
        }
        if (graphQLStoryActionLink.az() != null) {
            jsonGenerator.a("tagged_and_mentioned_users");
            C0272xa537f5eb.m6581a(jsonGenerator, graphQLStoryActionLink.az(), true);
        }
        if (graphQLStoryActionLink.aA() != null) {
            jsonGenerator.a("temporal_event_info");
            GraphQLTemporalEventInfo__JsonHelper.m22104a(jsonGenerator, graphQLStoryActionLink.aA(), true);
        }
        if (graphQLStoryActionLink.aB() != null) {
            jsonGenerator.a("title", graphQLStoryActionLink.aB());
        }
        if (graphQLStoryActionLink.aC() != null) {
            jsonGenerator.a("topic");
            GraphQLTopic__JsonHelper.m22279a(jsonGenerator, graphQLStoryActionLink.aC(), true);
        }
        if (graphQLStoryActionLink.aD() != null) {
            jsonGenerator.a("unsubscribe_description", graphQLStoryActionLink.aD());
        }
        if (graphQLStoryActionLink.aE() != null) {
            jsonGenerator.a("url", graphQLStoryActionLink.aE());
        }
        if (graphQLStoryActionLink.aF() != null) {
            jsonGenerator.a("prompt_id", graphQLStoryActionLink.aF());
        }
        if (graphQLStoryActionLink.aG() != null) {
            jsonGenerator.a("page_outcome_button");
            GraphQLPageOutcomeButton__JsonHelper.m9507a(jsonGenerator, graphQLStoryActionLink.aG(), true);
        }
        if (graphQLStoryActionLink.aH() != null) {
            jsonGenerator.a("frame_id", graphQLStoryActionLink.aH());
        }
        jsonGenerator.a("video_annotations");
        if (graphQLStoryActionLink.aI() != null) {
            jsonGenerator.d();
            for (GraphQLVideoAnnotation graphQLVideoAnnotation : graphQLStoryActionLink.aI()) {
                if (graphQLVideoAnnotation != null) {
                    GraphQLVideoAnnotation__JsonHelper.m22430a(jsonGenerator, graphQLVideoAnnotation, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStoryActionLink.aJ() != null) {
            jsonGenerator.a("story");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLStoryActionLink.aJ(), true);
        }
        jsonGenerator.a("hoisted_story_ids");
        if (graphQLStoryActionLink.aK() != null) {
            jsonGenerator.d();
            for (String str : graphQLStoryActionLink.aK()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("followup_choices");
        if (graphQLStoryActionLink.aL() != null) {
            jsonGenerator.d();
            for (String str2 : graphQLStoryActionLink.aL()) {
                if (str2 != null) {
                    jsonGenerator.b(str2);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStoryActionLink.aM() != null) {
            jsonGenerator.a("followup_question", graphQLStoryActionLink.aM());
        }
        jsonGenerator.a("main_choices");
        if (graphQLStoryActionLink.aN() != null) {
            jsonGenerator.d();
            for (String str22 : graphQLStoryActionLink.aN()) {
                if (str22 != null) {
                    jsonGenerator.b(str22);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStoryActionLink.aO() != null) {
            jsonGenerator.a("main_question", graphQLStoryActionLink.aO());
        }
        if (graphQLStoryActionLink.aP() != null) {
            jsonGenerator.a("featured_instant_article_element");
            GraphQLDocumentElement__JsonHelper.m6955a(jsonGenerator, graphQLStoryActionLink.aP(), true);
        }
        if (graphQLStoryActionLink.aQ() != null) {
            jsonGenerator.a("instant_article");
            GraphQLInstantArticle__JsonHelper.m8733a(jsonGenerator, graphQLStoryActionLink.aQ(), true);
        }
        if (graphQLStoryActionLink.aR() != null) {
            jsonGenerator.a("header_color", graphQLStoryActionLink.aR());
        }
        if (graphQLStoryActionLink.aS() != null) {
            jsonGenerator.a("logo_uri", graphQLStoryActionLink.aS());
        }
        jsonGenerator.a("rating", graphQLStoryActionLink.aT());
        if (z) {
            jsonGenerator.g();
        }
    }
}
