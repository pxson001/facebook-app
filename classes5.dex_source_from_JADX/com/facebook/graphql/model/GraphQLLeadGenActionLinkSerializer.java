package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feedback_options */
public class GraphQLLeadGenActionLinkSerializer extends JsonSerializer<GraphQLLeadGenActionLink> {
    public final void m8801a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLeadGenActionLink graphQLLeadGenActionLink = (GraphQLLeadGenActionLink) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLLeadGenActionLink.m8781a() != null) {
            jsonGenerator.a("ad_id", graphQLLeadGenActionLink.m8781a());
        }
        if (graphQLLeadGenActionLink.m8783j() != null) {
            jsonGenerator.a("agree_to_privacy_text", graphQLLeadGenActionLink.m8783j());
        }
        jsonGenerator.a("android_minimal_screen_form_height", graphQLLeadGenActionLink.m8784k());
        jsonGenerator.a("android_small_screen_phone_threshold", graphQLLeadGenActionLink.m8785l());
        if (graphQLLeadGenActionLink.m8786m() != null) {
            jsonGenerator.a("disclaimer_accept_button_text", graphQLLeadGenActionLink.m8786m());
        }
        if (graphQLLeadGenActionLink.m8787n() != null) {
            jsonGenerator.a("disclaimer_continue_button_text", graphQLLeadGenActionLink.m8787n());
        }
        jsonGenerator.a("error_codes");
        if (graphQLLeadGenActionLink.m8788o() != null) {
            jsonGenerator.d();
            for (GraphQLLeadGenErrorNode graphQLLeadGenErrorNode : graphQLLeadGenActionLink.m8788o()) {
                if (graphQLLeadGenErrorNode != null) {
                    GraphQLLeadGenErrorNode__JsonHelper.m8834a(jsonGenerator, graphQLLeadGenErrorNode, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLLeadGenActionLink.m8789p() != null) {
            jsonGenerator.a("error_message_brief", graphQLLeadGenActionLink.m8789p());
        }
        if (graphQLLeadGenActionLink.m8790q() != null) {
            jsonGenerator.a("error_message_detail", graphQLLeadGenActionLink.m8790q());
        }
        if (graphQLLeadGenActionLink.m8791r() != null) {
            jsonGenerator.a("fb_data_policy_setting_description", graphQLLeadGenActionLink.m8791r());
        }
        if (graphQLLeadGenActionLink.m8792s() != null) {
            jsonGenerator.a("fb_data_policy_url", graphQLLeadGenActionLink.m8792s());
        }
        if (graphQLLeadGenActionLink.m8793t() != null) {
            jsonGenerator.a("follow_up_action_text", graphQLLeadGenActionLink.m8793t());
        }
        if (graphQLLeadGenActionLink.m8794u() != null) {
            jsonGenerator.a("follow_up_action_url", graphQLLeadGenActionLink.m8794u());
        }
        if (graphQLLeadGenActionLink.m8795v() != null) {
            jsonGenerator.a("landing_page_cta", graphQLLeadGenActionLink.m8795v());
        }
        if (graphQLLeadGenActionLink.m8796w() != null) {
            jsonGenerator.a("landing_page_redirect_instruction", graphQLLeadGenActionLink.m8796w());
        }
        if (graphQLLeadGenActionLink.m8797x() != null) {
            jsonGenerator.a("lead_gen_data");
            GraphQLLeadGenData__JsonHelper.m8821a(jsonGenerator, graphQLLeadGenActionLink.m8797x(), true);
        }
        if (graphQLLeadGenActionLink.m8798y() != null) {
            jsonGenerator.a("lead_gen_data_id", graphQLLeadGenActionLink.m8798y());
        }
        if (graphQLLeadGenActionLink.m8799z() != null) {
            jsonGenerator.a("lead_gen_deep_link_user_status");
            GraphQLLeadGenDeepLinkUserStatus__JsonHelper.m8828a(jsonGenerator, graphQLLeadGenActionLink.m8799z(), true);
        }
        if (graphQLLeadGenActionLink.m8753A() != null) {
            jsonGenerator.a("lead_gen_user_status");
            GraphQLLeadGenUserStatus__JsonHelper.m8909a(jsonGenerator, graphQLLeadGenActionLink.m8753A(), true);
        }
        if (graphQLLeadGenActionLink.m8754B() != null) {
            jsonGenerator.a("link_description", graphQLLeadGenActionLink.m8754B());
        }
        if (graphQLLeadGenActionLink.m8755C() != null) {
            jsonGenerator.a("link_display", graphQLLeadGenActionLink.m8755C());
        }
        if (graphQLLeadGenActionLink.m8756D() != null) {
            jsonGenerator.a("link_style", graphQLLeadGenActionLink.m8756D().toString());
        }
        if (graphQLLeadGenActionLink.m8757E() != null) {
            jsonGenerator.a("link_title", graphQLLeadGenActionLink.m8757E());
        }
        if (graphQLLeadGenActionLink.m8758F() != null) {
            jsonGenerator.a("link_type", graphQLLeadGenActionLink.m8758F().toString());
        }
        if (graphQLLeadGenActionLink.m8759G() != null) {
            jsonGenerator.a("link_video_endscreen_icon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLLeadGenActionLink.m8759G(), true);
        }
        if (graphQLLeadGenActionLink.m8760H() != null) {
            jsonGenerator.a("nux_description", graphQLLeadGenActionLink.m8760H());
        }
        if (graphQLLeadGenActionLink.m8761I() != null) {
            jsonGenerator.a("nux_title", graphQLLeadGenActionLink.m8761I());
        }
        if (graphQLLeadGenActionLink.m8762J() != null) {
            jsonGenerator.a("page");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLLeadGenActionLink.m8762J(), true);
        }
        if (graphQLLeadGenActionLink.m8763K() != null) {
            jsonGenerator.a("primary_button_text", graphQLLeadGenActionLink.m8763K());
        }
        if (graphQLLeadGenActionLink.m8764L() != null) {
            jsonGenerator.a("privacy_checkbox_error", graphQLLeadGenActionLink.m8764L());
        }
        if (graphQLLeadGenActionLink.m8765M() != null) {
            jsonGenerator.a("privacy_setting_description", graphQLLeadGenActionLink.m8765M());
        }
        if (graphQLLeadGenActionLink.m8766N() != null) {
            jsonGenerator.a("progress_text", graphQLLeadGenActionLink.m8766N());
        }
        if (graphQLLeadGenActionLink.m8767O() != null) {
            jsonGenerator.a("secure_sharing_text", graphQLLeadGenActionLink.m8767O());
        }
        if (graphQLLeadGenActionLink.m8768P() != null) {
            jsonGenerator.a("select_text_hint", graphQLLeadGenActionLink.m8768P());
        }
        if (graphQLLeadGenActionLink.m8769Q() != null) {
            jsonGenerator.a("send_description", graphQLLeadGenActionLink.m8769Q());
        }
        if (graphQLLeadGenActionLink.m8770R() != null) {
            jsonGenerator.a("sent_text", graphQLLeadGenActionLink.m8770R());
        }
        if (graphQLLeadGenActionLink.m8771S() != null) {
            jsonGenerator.a("share_id", graphQLLeadGenActionLink.m8771S());
        }
        if (graphQLLeadGenActionLink.m8772T() != null) {
            jsonGenerator.a("short_secure_sharing_text", graphQLLeadGenActionLink.m8772T());
        }
        jsonGenerator.a("skip_experiments", graphQLLeadGenActionLink.m8773U());
        if (graphQLLeadGenActionLink.m8774V() != null) {
            jsonGenerator.a("split_flow_landing_page_hint_text", graphQLLeadGenActionLink.m8774V());
        }
        if (graphQLLeadGenActionLink.m8775W() != null) {
            jsonGenerator.a("split_flow_landing_page_hint_title", graphQLLeadGenActionLink.m8775W());
        }
        if (graphQLLeadGenActionLink.m8776X() != null) {
            jsonGenerator.a("submit_card_instruction_text", graphQLLeadGenActionLink.m8776X());
        }
        if (graphQLLeadGenActionLink.m8777Y() != null) {
            jsonGenerator.a("title", graphQLLeadGenActionLink.m8777Y());
        }
        if (graphQLLeadGenActionLink.m8778Z() != null) {
            jsonGenerator.a("unsubscribe_description", graphQLLeadGenActionLink.m8778Z());
        }
        if (graphQLLeadGenActionLink.aa() != null) {
            jsonGenerator.a("url", graphQLLeadGenActionLink.aa());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLLeadGenActionLink.class, new GraphQLLeadGenActionLinkSerializer());
    }
}
