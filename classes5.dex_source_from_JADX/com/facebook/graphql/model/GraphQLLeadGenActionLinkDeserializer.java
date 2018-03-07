package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLCallToActionStyle;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: option_icon */
public class GraphQLLeadGenActionLinkDeserializer extends FbJsonDeserializer {
    public Object m8800a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLLeadGenActionLink graphQLLeadGenActionLink = new GraphQLLeadGenActionLink();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLLeadGenActionLink = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                String o;
                if ("ad_id".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4340d = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "ad_id", graphQLLeadGenActionLink.a_, 0, false);
                } else if ("agree_to_privacy_text".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4341e = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "agree_to_privacy_text", graphQLLeadGenActionLink.a_, 1, false);
                } else if ("android_minimal_screen_form_height".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = 0;
                    } else {
                        r4 = jsonParser.E();
                    }
                    graphQLLeadGenActionLink.f4342f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "android_minimal_screen_form_height", graphQLLeadGenActionLink.a_, 2, false);
                } else if ("android_small_screen_phone_threshold".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = 0;
                    } else {
                        r4 = jsonParser.E();
                    }
                    graphQLLeadGenActionLink.f4343g = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "android_small_screen_phone_threshold", graphQLLeadGenActionLink.a_, 3, false);
                } else if ("disclaimer_accept_button_text".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4344h = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "disclaimer_accept_button_text", graphQLLeadGenActionLink.a_, 4, false);
                } else if ("disclaimer_continue_button_text".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4345i = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "disclaimer_continue_button_text", graphQLLeadGenActionLink.a_, 5, false);
                } else if ("error_codes".equals(i)) {
                    List list;
                    Collection collection = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        collection = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            GraphQLLeadGenErrorNode a = GraphQLLeadGenErrorNode__JsonHelper.m8833a(FieldAccessQueryTracker.a(jsonParser, "error_codes"));
                            if (a != null) {
                                collection.add(a);
                            }
                        }
                    }
                    if (collection == null) {
                        list = null;
                    } else {
                        list = ImmutableList.copyOf(collection);
                    }
                    graphQLLeadGenActionLink.f4346j = list;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "error_codes", graphQLLeadGenActionLink.a_, 6, true);
                } else if ("error_message_brief".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4347k = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "error_message_brief", graphQLLeadGenActionLink.a_, 7, false);
                } else if ("error_message_detail".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4348l = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "error_message_detail", graphQLLeadGenActionLink.a_, 8, false);
                } else if ("fb_data_policy_setting_description".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4349m = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "fb_data_policy_setting_description", graphQLLeadGenActionLink.a_, 9, false);
                } else if ("fb_data_policy_url".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4350n = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "fb_data_policy_url", graphQLLeadGenActionLink.a_, 10, false);
                } else if ("follow_up_action_text".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4351o = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "follow_up_action_text", graphQLLeadGenActionLink.a_, 11, false);
                } else if ("follow_up_action_url".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4352p = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "follow_up_action_url", graphQLLeadGenActionLink.a_, 12, false);
                } else if ("landing_page_cta".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4353q = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "landing_page_cta", graphQLLeadGenActionLink.a_, 13, false);
                } else if ("landing_page_redirect_instruction".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4354r = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "landing_page_redirect_instruction", graphQLLeadGenActionLink.a_, 14, false);
                } else if ("lead_gen_data".equals(i)) {
                    GraphQLLeadGenData graphQLLeadGenData;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLLeadGenData = null;
                    } else {
                        graphQLLeadGenData = GraphQLLeadGenData__JsonHelper.m8820a(FieldAccessQueryTracker.a(jsonParser, "lead_gen_data"));
                    }
                    graphQLLeadGenActionLink.f4355s = graphQLLeadGenData;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "lead_gen_data", graphQLLeadGenActionLink.a_, 15, true);
                } else if ("lead_gen_data_id".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4356t = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "lead_gen_data_id", graphQLLeadGenActionLink.a_, 16, false);
                } else if ("lead_gen_deep_link_user_status".equals(i)) {
                    GraphQLLeadGenDeepLinkUserStatus graphQLLeadGenDeepLinkUserStatus;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLLeadGenDeepLinkUserStatus = null;
                    } else {
                        graphQLLeadGenDeepLinkUserStatus = GraphQLLeadGenDeepLinkUserStatus__JsonHelper.m8827a(FieldAccessQueryTracker.a(jsonParser, "lead_gen_deep_link_user_status"));
                    }
                    graphQLLeadGenActionLink.f4357u = graphQLLeadGenDeepLinkUserStatus;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "lead_gen_deep_link_user_status", graphQLLeadGenActionLink.a_, 17, true);
                } else if ("lead_gen_user_status".equals(i)) {
                    GraphQLLeadGenUserStatus graphQLLeadGenUserStatus;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLLeadGenUserStatus = null;
                    } else {
                        graphQLLeadGenUserStatus = GraphQLLeadGenUserStatus__JsonHelper.m8908a(FieldAccessQueryTracker.a(jsonParser, "lead_gen_user_status"));
                    }
                    graphQLLeadGenActionLink.f4358v = graphQLLeadGenUserStatus;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "lead_gen_user_status", graphQLLeadGenActionLink.a_, 18, true);
                } else if ("link_description".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4359w = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "link_description", graphQLLeadGenActionLink.a_, 19, false);
                } else if ("link_display".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4360x = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "link_display", graphQLLeadGenActionLink.a_, 20, false);
                } else if ("link_style".equals(i)) {
                    graphQLLeadGenActionLink.f4361y = GraphQLCallToActionStyle.fromString(jsonParser.o());
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "link_style", graphQLLeadGenActionLink.a_, 21, false);
                } else if ("link_title".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4362z = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "link_title", graphQLLeadGenActionLink.a_, 22, false);
                } else if ("link_type".equals(i)) {
                    graphQLLeadGenActionLink.f4318A = GraphQLCallToActionType.fromString(jsonParser.o());
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "link_type", graphQLLeadGenActionLink.a_, 23, false);
                } else if ("link_video_endscreen_icon".equals(i)) {
                    graphQLLeadGenActionLink.f4319B = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "link_video_endscreen_icon"));
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "link_video_endscreen_icon", graphQLLeadGenActionLink.a_, 24, true);
                } else if ("nux_description".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4320C = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "nux_description", graphQLLeadGenActionLink.a_, 25, false);
                } else if ("nux_title".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4321D = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "nux_title", graphQLLeadGenActionLink.a_, 26, false);
                } else if ("page".equals(i)) {
                    graphQLLeadGenActionLink.f4322E = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "page"));
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "page", graphQLLeadGenActionLink.a_, 27, true);
                } else if ("primary_button_text".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4323F = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "primary_button_text", graphQLLeadGenActionLink.a_, 28, false);
                } else if ("privacy_checkbox_error".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4324G = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "privacy_checkbox_error", graphQLLeadGenActionLink.a_, 29, false);
                } else if ("privacy_setting_description".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4325H = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "privacy_setting_description", graphQLLeadGenActionLink.a_, 30, false);
                } else if ("progress_text".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4326I = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "progress_text", graphQLLeadGenActionLink.a_, 31, false);
                } else if ("secure_sharing_text".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4327J = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "secure_sharing_text", graphQLLeadGenActionLink.a_, 32, false);
                } else if ("select_text_hint".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4328K = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "select_text_hint", graphQLLeadGenActionLink.a_, 33, false);
                } else if ("send_description".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4329L = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "send_description", graphQLLeadGenActionLink.a_, 34, false);
                } else if ("sent_text".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4330M = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "sent_text", graphQLLeadGenActionLink.a_, 35, false);
                } else if ("share_id".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4331N = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "share_id", graphQLLeadGenActionLink.a_, 36, false);
                } else if ("short_secure_sharing_text".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4332O = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "short_secure_sharing_text", graphQLLeadGenActionLink.a_, 37, false);
                } else if ("skip_experiments".equals(i)) {
                    boolean z;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        z = false;
                    } else {
                        z = jsonParser.H();
                    }
                    graphQLLeadGenActionLink.f4333P = z;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "skip_experiments", graphQLLeadGenActionLink.a_, 38, false);
                } else if ("split_flow_landing_page_hint_text".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4334Q = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "split_flow_landing_page_hint_text", graphQLLeadGenActionLink.a_, 39, false);
                } else if ("split_flow_landing_page_hint_title".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4335R = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "split_flow_landing_page_hint_title", graphQLLeadGenActionLink.a_, 40, false);
                } else if ("submit_card_instruction_text".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4336S = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "submit_card_instruction_text", graphQLLeadGenActionLink.a_, 41, false);
                } else if ("title".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4337T = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "title", graphQLLeadGenActionLink.a_, 42, false);
                } else if ("unsubscribe_description".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4338U = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "unsubscribe_description", graphQLLeadGenActionLink.a_, 43, false);
                } else if ("url".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLLeadGenActionLink.f4339V = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenActionLink, "url", graphQLLeadGenActionLink.a_, 44, false);
                }
                jsonParser.f();
            }
        }
        return graphQLLeadGenActionLink;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLeadGenActionLink.class, new GraphQLLeadGenActionLinkDeserializer());
    }

    public GraphQLLeadGenActionLinkDeserializer() {
        a(GraphQLLeadGenActionLink.class);
    }
}
