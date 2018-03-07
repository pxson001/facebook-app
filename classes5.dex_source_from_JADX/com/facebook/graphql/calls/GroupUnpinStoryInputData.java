package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: prompt_analytics */
public final class GroupUnpinStoryInputData extends GraphQlMutationCallInput {

    /* compiled from: prompt_analytics */
    public enum Source implements JsonSerializable {
        UNKNOWN("unknown"),
        ADD_FROM_PROFILE("add_from_profile"),
        APP_COMMUNITY_MANAGER("app_community_manager"),
        CHAT_WITH_GROUP("chat_with_group"),
        CREATE_FLOW("create_flow"),
        FULL_SUGGESTION("full_suggestion"),
        GYSJ("gysj"),
        GAME_GYSJ("game_gysj"),
        GROUP_BROWSE("group_browse"),
        GROUP_CONTEXT_ROWS("group_context_rows"),
        GROUP_MALL("group_mall"),
        SETTINGS_PAGE("settings_page"),
        GROUP_INFO_PAGE("group_info_page"),
        SUGGESTED_PURPOSE_MODAL("suggested_purpose_modal"),
        MARKETPLACE("marketplace"),
        TYPEAHEAD("typeahead"),
        DIALOG_TYPEAHEAD("dialog_typeahead"),
        DEFAULT_CHILD_GROUP("default_child_group"),
        SGNY("sgny"),
        PERMALINK("permalink"),
        DISCOVER_GROUPS("discover_groups"),
        MEMBER_ADD_UNDO("member_add_undo"),
        MEMBERBOX("memberbox"),
        PROFILE_BROWSER("profile_browser"),
        PROFILEBROWSER_BLOCKED("profilebrowser_blocked"),
        TAGBOX("tagbox"),
        GROUP_LIST_SUGGESTED_GROUPS("group_list_suggested_groups"),
        HOVERCARD("hovercard"),
        INVITE("invite"),
        MEMBER_SUMMARY("member_summary"),
        NF_HEADLINE("nf_headline"),
        NOTIFICATION("notification"),
        RELATED_GROUPS("related_groups"),
        REQUESTS_QUEUE("requests_queue"),
        RHC_TAG("rhc_tag"),
        SUGGESTED_GROUPS("suggested_groups"),
        SUGGESTED_GROUPS_NEW("suggested_groups_new"),
        FEED_SUGGESTED_GROUPS("feed_suggested_groups"),
        SUGGESTION("suggestion"),
        SEARCH("search"),
        SETTINGS("settings"),
        UNIT_TEST("unit_test"),
        FEED_ATTACHMENT("feed_attachment"),
        CHILD_SEARCH("child_search"),
        GROUP_JUMP_HEADER("group_jump_header"),
        MEMBER_LIST("member_list"),
        MEMBER_REQUEST("member_request"),
        PENDING_POST_REQUEST_QUEUE("pending_post_request_queue"),
        REPORTED_POST_REQUEST_QUEUE("reported_post_request_queue"),
        GROUP_COMMERCE_MAP("group_commerce_map"),
        GROUP_COMMERCE_SUGGESTED_GROUPS_CARD("group_commerce_suggested_groups_card"),
        GROUP_COMMERCE_MOBILE_LANDING_PAGE("group_commerce_mobile_landing_page"),
        ENTITY_CARD("entity_card"),
        MOBILE_ADD_MEMBERS("mobile_add_members"),
        MOBILE_CREATE_GROUP("mobile_create_group"),
        MOBILE_GROUP_JOIN("mobile_group_join"),
        MOBILE_SEE_ALL("mobile_see_all"),
        MOBILE_GROUPS_DASH("mobile_groups_dash"),
        FOF_INVITE_JOIN_DIALOGUE("fof_invite_join_dialogue"),
        EMAIL_INVITE_JOIN_DIALOGUE("email_invite_join_dialogue"),
        EMAIL_INVITE_JOIN_BAR("email_invite_join_bar"),
        INVITE_LINK_JOIN_BAR("invite_link_join_bar"),
        TREEHOUSE_GROUP_MALL("treehouse_group_mall"),
        TREEHOUSE_GROUP_INFO("treehouse_group_info"),
        TREEHOUSE_HOME("treehouse_home"),
        TREEHOUSE_NOTIF("treehouse_notif"),
        TREEHOUSE_DISCOVER_SEARCH("treehouse_discover_search"),
        TREEHOUSE_DISCOVER_SUGGESTION("treehouse_discover_suggestion"),
        TREEHOUSE_REPORTED_POSTS_QUEUE("treehouse_reported_posts_queue"),
        IPAD_SIDEFEED_GROUP_ABOUT("ipad_sidefeed_group_about"),
        IPAD_SIDEFEED_GROUP_GYMJ("ipad_sidefeed_group_gymj"),
        PAGES_PROFILE_GROUPS_TAB("pages_profile_groups_tab"),
        WORK_ADMIN_PANEL("work_admin_panel"),
        ATWORKNUX("atworknux"),
        WORK_COWORKER_INVITE("work_coworker_invite"),
        WORK_GROUP_CREATION_DIALOG("work_group_creation_dialog"),
        WORK_INVITE_LINK_SIGNUP("work_invite_link_signup"),
        WORK_NEWSFEED_NUX("work_newsfeed_nux"),
        WORK_SIGNUP_FLOW("work_signup_flow"),
        WORK_INTERNAL_SCRIPT("work_internal_script"),
        WORK_MANAGER_GROUP("work_manager_group"),
        FBAPP_DISCOVERY_LANDING_PAGE("fbapp_discovery_landing_page"),
        MESSENGER_GROUP_ATTACHMENT("messenger_group_attachment"),
        SOCIAL_PLUGIN("social_plugin"),
        SAFETY_CHECK("safety_check"),
        PULSE_DASHBOARD("pulse_dashboard"),
        API("api"),
        DISCOVER_SUGGESTION("discover_suggestion"),
        DISCOVER_SEARCH("discover_search"),
        CATEGORY_DISCOVER_LANDING("category_discover_landing"),
        CATEGORY_DISCOVER_CATEGORY("category_discover_category"),
        CATEGORY_DISCOVER_TAG("category_discover_tag"),
        GROUP_BROWSE_NEW("group_browse_new");
        
        protected final String serverValue;

        private Source(String str) {
            this.serverValue = str;
        }

        public final String toString() {
            return this.serverValue;
        }

        public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.b(this.serverValue);
        }

        public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            throw new UnsupportedOperationException("Serialization infrastructure does not support type serialization.");
        }
    }
}
