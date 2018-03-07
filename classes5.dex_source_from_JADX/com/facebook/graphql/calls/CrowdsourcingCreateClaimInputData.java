package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: real_time_activity_sentence */
public final class CrowdsourcingCreateClaimInputData extends GraphQlMutationCallInput {

    /* compiled from: real_time_activity_sentence */
    public enum Action implements JsonSerializable {
        SUGGESTION("suggestion"),
        VOTE("vote");
        
        protected final String serverValue;

        private Action(String str) {
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

    /* compiled from: real_time_activity_sentence */
    public enum Endpoint implements JsonSerializable {
        ANDROID_FEATHER("android_feather"),
        ANDROID_MARK_DUPLICATES("android_mark_duplicates"),
        ANDROID_PLACE_CREATION("android_place_creation"),
        ANDROID_PLACE_CREATION_V2("android_place_creation_v2"),
        ANDROID_PLACE_CREATION_V2_WITH_FORM("android_place_creation_v2_with_form"),
        ANDROID_SUGGEST_EDITS("android_suggest_edits"),
        ANDROID_SUGGEST_EDITS_V2("android_suggest_edits_v2"),
        ANDROID_SUGGEST_PROFILE_PICTURE("android_suggest_profile_picture"),
        ANDROID_TIMELINE_REPORT_DIALOG("android_timeline_report_dialog"),
        ANDROID_PLACE_PICKER_REPORT_DIALOG("android_place_picker_report_dialog"),
        ADMIN_DIALOG("admin_dialog"),
        BING_RESULTS("bing_results"),
        BROWSE_FEEDBACK("browse_feedback"),
        BROWSE_FEEDBACK_DIALOG("browse_feedback_dialog"),
        BROWSE_FEEDBACK_COMBINED_DIALOG("browse_feedback_combined_dialog"),
        COLLECTIONS_TYPEAHEAD("collections_typeahead"),
        COMMUNITY_EDITOR_GAME("community_editor_game"),
        COMMUNITY_EDITOR_MOBILE("community_editor_mobile"),
        EDIT_PAGE_DIALOG("edit_page_dialog"),
        EDUCATION_EDITOR_REVIEW_DUPLICATES_MODULE("education_editor_review_duplicates_module"),
        GRAPH_SUGGESTION_API("graph_suggestion_api"),
        GROUPS_RHC_MODULE("groups_rhc_module"),
        IOS_PLACE_PICKER_REPORT_DIALOG("ios_place_picker_report_dialog"),
        MEDIA_EDITOR_REVIEW_DUPLICATES_MODULE("media_editor_review_duplicates_module"),
        MEDIA_EDITOR_REVIEW_AND_SUGGEST_MODULE("media_editor_review_and_suggest_module"),
        MEDIA_EDITOR_REVIEW_AND_SUGGEST_MODULE_V2("media_editor_review_and_suggest_module_v2"),
        METAPAGE_REDIRECT_DIALOG("metapage_redirect_dialog"),
        METAPAGE_REDIRECT_DIALOG_LANG_Q("metapage_redirect_dialog_lang_q"),
        MOBILE_ANDROID("mobile_android"),
        MOBILE_IOS("mobile_ios"),
        MSITE_CHECKIN_PROMPT("msite_checkin_prompt"),
        MSITE_EDIT("msite_edit"),
        MSITE_SUGGEST_EDITS("msite_suggest_edits"),
        MTOUCH_PROFILE_PICTURE("mtouch_profile_picture"),
        PAGE_REPORT_DIALOG("page_report_dialog"),
        PLACE_EDIT_DIALOG("place_edit_dialog"),
        PLACE_EDIT_DIALOG_V2("place_edit_dialog_v2"),
        PLACE_REPORT_DIALOG("place_report_dialog"),
        PLACES_EDITOR_EVENT_CALLOUT("places_editor_event_callout"),
        PLACE_SUGGESTION_NETEGO("place_suggestion_netego"),
        PLACES_EDITOR_CATEGORY_MODULE("places_editor_category_module"),
        PLACES_EDITOR_DUPLICATE_MODULE("places_editor_duplicate_module"),
        PLACES_EDITOR_FIELDS_MODULE("places_editor_fields_module"),
        PLACES_EDITOR_HOURS_MODULE("places_editor_hours_module"),
        PLACES_EDITOR_PHOTOS_MODULE("places_editor_photos_module"),
        PLACES_EDITOR_REVIEW_AND_SUGGEST_MODULE("places_editor_review_and_suggest_module"),
        PLACES_EDITOR_REVIEW_AND_SUGGEST_MODULE_V2("places_editor_review_and_suggest_module_v2"),
        PLACES_EDITOR_REVIEW_AND_SUGGEST_MODULE_SIMPLE("places_editor_review_and_suggest_module_simple"),
        PLACES_EDITOR_REVIEW_DUPLICATES_MODULE("places_editor_review_duplicates_module"),
        PLACES_EDITOR_REVIEW_FIELD_MODULE("places_editor_review_field_module"),
        PLACES_EDITOR_REVIEW_SUGGESTIONS_MODULE("places_editor_review_suggestions_module"),
        PAGE_TAG_DIALOG("page_tag_dialog"),
        TOPIC_DIALOG("topic_dialog"),
        TOPIC_VOTE_DIALOG("topic_vote_dialog"),
        UNOWNED_PLACE_PHOTO_VOTING("unowned_place_photo_voting"),
        VERTEX_INLINE("vertex_inline"),
        VERTEX_INLINE_CARD("vertex_inline_card"),
        VERTEX_INLINE_CARD_VOTING("vertex_inline_card_voting"),
        VERTEX_PROFILE_PICTURE_DIALOG("vertex_profile_picture_dialog"),
        VERTEX_PHOTO_VOTING("vertex_photo_voting"),
        WEBSITE_DUPLICATE_REPORT("website_duplicate_report"),
        BULK_CLAIM_IMPORTER("bulk_claim_importer"),
        MENU_ITEM_PHOTO_SUGGESTION_NETEGO("menu_item_photo_suggestion_netego"),
        MEGAPHONE("megaphone"),
        MSITE_MENU_ITEM_ACTION("msite_menu_item_action"),
        MTOUCH_POST_CHECKIN_PROMPT("mtouch_post_checkin_prompt"),
        PROFILE_QUESTIONS_EDU_DEDUP("profile_questions_edu_dedup"),
        OG_NETEGO_MOVIE_RELEASE_DATE("og_netego_movie_release_date"),
        OBJECT_TOOL_NATIVE_LANGUAGE("object_tool_native_language"),
        AFTER_PARTY_PLACE_QUESTION("after_party_place_question"),
        AFTER_PARTY_PLACE_QUESTION_OLD_PRICE_RANGE("after_party_place_question_old_price_range"),
        LOCAL_SERP_PLACE_QUESTION("local_serp_place_question"),
        PAGE_CONTEXT_ROW_PLACE_QUESTION("page_context_row_place_question"),
        MOBILE_IOS_COMPOSER_EDIT("mobile_ios_composer_edit"),
        MOBILE_IOS_FINCH_EDIT("mobile_ios_finch_edit"),
        MOBILE_IOS_FINCH_PROFILE("mobile_ios_finch_profile"),
        MOBILE_IOS_PLACE_CREATION("mobile_ios_place_creation"),
        MOBILE_IOS_POST_CHECKIN("mobile_ios_post_checkin"),
        IOS_PLACES_SUGGEST_EDITS("ios_places_suggest_edits"),
        IOS_PAGE_HEADER("ios_page_header"),
        IOS_POST_CHECKIN_UPLOAD_PHOTO("ios_post_checkin_upload_photo"),
        IOS_REPORT_DUPLICATE("ios_report_duplicate"),
        IOS_PLACES_NEW_SUGGEST_EDITS("ios_places_new_suggest_edits"),
        IOS_CREATION_V1("ios_creation_v1"),
        IOS_CREATION_V1_WITH_PREFORM_CATEGORY_PICKER("ios_creation_v1_with_preform_category_picker"),
        IOS_CREATION_V2("ios_creation_v2"),
        IOS_FEATHER("ios_feather"),
        MOBILE_ANDROID_COMPOSER_EDIT("mobile_android_composer_edit"),
        MOBILE_ANDROID_FINCH_EDIT("mobile_android_finch_edit"),
        MOBILE_ANDROID_FINCH_PROFILE("mobile_android_finch_profile"),
        MOBILE_ANDROID_PLACE_CREATION("mobile_android_place_creation"),
        MOBILE_ANDROID_POST_CHECKIN("mobile_android_post_checkin"),
        ANDROID_POST_ACTION_VOTE("android_post_action_vote"),
        ANDROID_NEARBY_FRIENDS_SELF_VIEW_UNKNOWN_REGION("android_nearby_friends_self_view_unknown_region"),
        IOS_NEARBY_FRIENDS_SELF_VIEW_UNKNOWN_REGION("ios_nearby_friends_self_view_unknown_region"),
        MOBILE_PLACES_EDITOR_SINGLE_PHOTO_REVIEW_MODULE("mobile_places_editor_single_photo_review_module"),
        MOBILE_PLACES_EDITOR_REVIEW_MODULE("mobile_places_editor_review_module"),
        RN_MOBILE_PLACES_EDITOR_REVIEW_MODULE("rn_mobile_places_editor_review_module"),
        ANDROID_PHONE_APP("android_phone_app"),
        INTERN_MATCH_MANAGER("intern_match_manager"),
        IOS_SUGGESTIFIER_VOTING("ios_suggestifier_voting"),
        ANDROID_SUGGESTIFIER_VOTING("android_suggestifier_voting"),
        EMPLOYEE_LOCATION_HISTORY_VOTING("employee_location_history_voting"),
        MOBILE_PPD_TOOL("mobile_ppd_tool"),
        POPULAR_AT_ADD_ITEM("popular_at_add_item"),
        POPULAR_AT_ADD_DUPLICATE_ITEM("popular_at_add_duplicate_item"),
        POPULAR_AT_REMOVE_ITEM("popular_at_remove_item"),
        POPULAR_AT_LIKE_ITEM("popular_at_like_item"),
        POPULAR_AT_REPORT_ITEM("popular_at_report_item"),
        POPULAR_AT_REPORT_NOT_AVAILABLE("popular_at_report_not_available"),
        POPULAR_AT_REPORT_NOT_SPECIFIC("popular_at_report_not_specific"),
        POPULAR_AT_REPORT_WRONG_NAME("popular_at_report_wrong_name"),
        POPULAR_AT_REPORT_SPAM_OR_SCAM("popular_at_report_spam_or_scam"),
        POPULAR_AT_REPORT_NOT_HELPFUL("popular_at_report_not_helpful"),
        HARMONIZATION_EMPLOYEE_CURATION("harmonization_employee_curation"),
        MSITE_REPORT_MERGED_PAGES_URL("msite_report_merged_pages_url"),
        NETEGO_PRICE_RANGE_SURVEY("netego_price_range_survey"),
        UNKNOWN("unknown"),
        UNIT_TEST("unit_test"),
        UNIT_TEST2("unit_test2");
        
        protected final String serverValue;

        private Endpoint(String str) {
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

    /* compiled from: real_time_activity_sentence */
    public enum EntryPoint implements JsonSerializable {
        FEED_AD("feed_ad"),
        TIMELINE_ACTION_MENU_SUGGEST_EDITS("timeline_action_menu_suggest_edits"),
        ANDROID_PAGE_ACTION_MENU_SUGGEST_EDITS("android_page_action_menu_suggest_edits"),
        IOS_PAGE_EDIT_ACTION_BUTTON("ios_page_edit_action_button"),
        MSITE_PAGE_ACTION_MENU_SUGGEST_EDITS("msite_page_action_menu_suggest_edits"),
        TIMELINE_ABOUT_SECTION_SUGGEST_EDITS("timeline_about_section_suggest_edits"),
        TIMELINE_ABOUT_SECTION_SUGGEST_EDITS_V2("timeline_about_section_suggest_edits_v2"),
        TIMELINE_ABOUT_SECTION_ADD_PHONE("timeline_about_section_add_phone"),
        ANDROID_PAGE_MORE_INFORMATION_SUGGEST_EDITS("android_page_more_information_suggest_edits"),
        IOS_PAGE_EDIT_BUTTON("ios_page_edit_button"),
        MSITE_ABOUT_PAGE_SUGGEST_EDITS("msite_about_page_suggest_edits"),
        PAGE_TAG_DIALOG("page_tag_dialog"),
        IOS_ADD_INFO_BUTTON("ios_add_info_button"),
        ANDROID_ADD_INFO_BUTTON("android_add_info_button"),
        IOS_CONTEXT_ROW_SUGGEST_EDITS("ios_context_row_suggest_edits"),
        ANDROID_CONTEXT_ROW_SUGGEST_EDITS("android_context_row_suggest_edits"),
        MGE_SUGGEST_EDITS_BUTTON("mge_suggest_edits_button"),
        ANDROID_ENTITY_CARD_EDIT_ACTION_BUTTON("android_entity_card_edit_action_button"),
        IOS_ENTITY_CARD_EDIT_ACTION_BUTTON("ios_entity_card_edit_action_button"),
        IOS_PLACE_QUESTION_PAGE_CONTEXT_ROW("ios_place_question_page_context_row"),
        ANDROID_PLACE_QUESTION_PAGE_CONTEXT_ROW("android_place_question_page_context_row"),
        PAGE_CONTEXT_ITEM("page_context_item"),
        IOS_PLACE_PICKER_EDIT_SWIPE_BUTTON("ios_place_picker_edit_swipe_button"),
        ANDROID_PLACE_PICKER_LONG_PRESS_SUGGEST_EDITS("android_place_picker_long_press_suggest_edits"),
        ANDROID_PLACE_PICKER_CONTEXT_MENU_SUGGEST_EDITS("android_place_picker_context_menu_suggest_edits"),
        ANDROID_PLACE_PICKER_EDIT_MENU_SUGGEST_EDITS("android_place_picker_edit_menu_suggest_edits"),
        ANDROID_POPOVER_PLACE_PICKER_LONG_PRESS_SUGGEST_EDITS("android_popover_place_picker_long_press_suggest_edits"),
        IOS_PLACE_PICKER_CONTEXT_MENU_SUGGEST_EDITS("ios_place_picker_context_menu_suggest_edits"),
        IOS_POST_CHECKIN_UPLOAD_PHOTO_FLOW("ios_post_checkin_upload_photo_flow"),
        ANDROID_CONTEXT_ROW_POST_ACTION("android_context_row_post_action"),
        ANDROID_POST_CALL("android_post_call"),
        ANDROID_PAGE_HEADER_ADD_PHOTO_BUTTON("android_page_header_add_photo_button"),
        IOS_PAGE_HEADER("ios_page_header"),
        IOS_PAGE_HEADER_REMOVE_ACTION_BUTTON("ios_page_header_remove_action_button"),
        ANDROID_PLACE_PICKER_ADD_BUTTON("android_place_picker_add_button"),
        IOS_PLACE_CREATION_OLD_SOURCE("ios_place_creation_old_source"),
        ANDROID_POPOVER_PLACE_PICKER_ADD_BUTTON("android_popover_place_picker_add_button"),
        ANDROID_PLACE_PICKER_LONG_PRESS_REPORT_DUPLICATES("android_place_picker_long_press_report_duplicates"),
        ANDROID_PLACE_PICKER_CONTEXT_MENU_REPORT_DUPLICATES("android_place_picker_context_menu_report_duplicates"),
        ANDROID_PLACE_PICKER_EDIT_MENU_REPORT_DUPLICATES("android_place_picker_edit_menu_report_duplicates"),
        IOS_PLACE_PICKER_REPORT_SWIPE_BUTTON("ios_place_picker_report_swipe_button"),
        IOS_PLACE_PICKER_CONTEXT_MENU_REPORT_DUP("ios_place_picker_context_menu_report_dup"),
        IOS_CHECKIN_ADD_PLACE_BUTTON("ios_checkin_add_place_button"),
        ANDROID_POPOVER_PLACE_PICKER_LONG_PRESS_REPORT_DUPLICATES("android_popover_place_picker_long_press_report_duplicates"),
        ANDROID_PLACE_TIPS("android_place_tips"),
        IOS_PLACE_TIPS("ios_place_tips"),
        ANDROID_FEED_ADD_PHOTO_BUTTON("android_feed_add_photo_button"),
        IOS_FEED_ADD_PHOTO_BUTTON("ios_feed_add_photo_button"),
        ANDROID_REPORT_PLACE_INCORRECT_INFORMATION("android_report_place_incorrect_information"),
        ANDROID_TIMELINE_ACTION_MENU_REPORT_PAGE("android_timeline_action_menu_report_page"),
        ANDROID_PLACE_PICKER_LONG_PRESS("android_place_picker_long_press"),
        ANDROID_PLACE_PICKER_CONTEXT_MENU("android_place_picker_context_menu"),
        ANDROID_PLACE_PICKER_EDIT_MENU("android_place_picker_edit_menu"),
        MSITE_TIMELINE_ACTION_MENU_REPORT_PAGE("msite_timeline_action_menu_report_page"),
        ANDROID_POPOVER_PLACE_PICKER_LONG_PRESS("android_popover_place_picker_long_press"),
        ANDROID_MAP_REPORT_BUTTON_MENU("android_map_report_button_menu"),
        IOS_PLACE_PICKER_CONTEXT_MENU("ios_place_picker_context_menu"),
        MSITE_MAP_REPORT_BUTTON_MENU("msite_map_report_button_menu"),
        VERTEX_ADD_A_CATEGORY("vertex_add_a_category"),
        VERTEX_EDIT_BUTTON("vertex_edit_button"),
        VERTEX_GEAR_REPORT_PAGE("vertex_gear_report_page"),
        VERTEX_PERMANENTLY_CLOSED_DIALOG("vertex_permanently_closed_dialog"),
        VERTEX_V2_EDIT_BUTTON("vertex_v2_edit_button"),
        VERTEX_INLINE_CARD("vertex_inline_card"),
        UNOWNED_PAGE_ACTION_MENU_REPORT_PAGE("unowned_page_action_menu_report_page"),
        TIMELINE_ACTION_MENU_REPORT_PAGE("timeline_action_menu_report_page"),
        TIMELINE_MAP_PAGELET_LINK("timeline_map_pagelet_link"),
        GRAPH_EDITOR_EDIT_INFO_LINK("graph_editor_edit_info_link"),
        GRAPH_EDITOR_REPORT_PLACE_LINK("graph_editor_report_place_link"),
        MSITE_SUGGEST_EDITS_BOOKMARK("msite_suggest_edits_bookmark"),
        IOS_SUGGEST_EDITS_BOOKMARK("ios_suggest_edits_bookmark"),
        ANDROID_SUGGEST_EDITS_BOOKMARK("android_suggest_edits_bookmark"),
        ACCEPTED_NOTIFICATION("accepted_notification"),
        ASK_A_FRIEND_NOTIFICATION("ask_a_friend_notification"),
        COMMUNITY_PAGE_APP_LINK("community_page_app_link"),
        GRAPH_SEARCH_RESULT("graph_search_result"),
        GRAPH_SEARCH_FEEDBACK("graph_search_feedback"),
        EDIT_PAGE_DIALOG_CONFIRMATION("edit_page_dialog_confirmation"),
        GRAPH_EDITOR_URL("graph_editor_url"),
        GROUP_LEADERBOARD("group_leaderboard"),
        MEDIA_INVITATION_AFTER_EDIT_DIALOG("media_invitation_after_edit_dialog"),
        PLACES_INVITATION_AFTER_EDIT_DIALOG("places_invitation_after_edit_dialog"),
        SUGGEST_EDITS_BOOKMARK("suggest_edits_bookmark"),
        VERTEX_CITY_SUGGEST_EDITS_BUTTON("vertex_city_suggest_edits_button"),
        VERTEX_INLINE_CONFIRMATION("vertex_inline_confirmation"),
        VERTEX_PHOTO_INLINE("vertex_photo_inline"),
        VERTEX_PHOTO_VOTE_MODULE("vertex_photo_vote_module"),
        VERTEX_PLACE_INFORMATION("vertex_place_information"),
        UNOWNED_PLACE_INFORMATION("unowned_place_information"),
        UNOWNED_PLACE_PHOTO_VOTE_MODULE("unowned_place_photo_vote_module"),
        UNOWNED_PLACE_PHOTO_INLINE("unowned_place_photo_inline"),
        CITY_PAGE_SUGGEST_EDITS_BUTTON("city_page_suggest_edits_button"),
        METAPAGE_REDIRECTION_NOTIFICATION("metapage_redirection_notification"),
        UNOWNED_PAGE_INFORMATION_STORY_LINK("unowned_page_information_story_link"),
        COLLECTIONS_TYPEAHEAD_REPORT_DUPLICATES("collections_typeahead_report_duplicates"),
        MOBILE_GRAPH_EDITOR_URL("mobile_graph_editor_url"),
        ANDROID_POST_SUGGEST_EDITS_UPSELL("android_post_suggest_edits_upsell"),
        IOS_POST_SUGGEST_EDITS_UPSELL("ios_post_suggest_edits_upsell"),
        GRAPH_SEARCH_CHEVRON_REPORT_PLACE("graph_search_chevron_report_place"),
        GRAPH_SEARCH_CHEVRON_INCORRECT_LOCATION("graph_search_chevron_incorrect_location"),
        GRAPH_SEARCH_CHEVRON_INCORRECT_PAGE_CATEGORY("graph_search_chevron_incorrect_page_category"),
        GRAPH_SEARCH_CHEVRON_INCORRECT_NAME("graph_search_chevron_incorrect_name"),
        GRAPH_SEARCH_CHEVRON_INCORRECT_PLACE_CATEGORY("graph_search_chevron_incorrect_place_category"),
        ANDROID_SEARCH_RESULT_PICKER_LONG_PRESS_SUGGEST_EDITS("android_search_result_picker_long_press_suggest_edits"),
        SUGGEST_EDITS_WEBSITE_DUPLICATE_DIALOG("suggest_edits_website_duplicate_dialog"),
        MSITE_SUGGEST_EDITS_URL("msite_suggest_edits_url"),
        ANDROID_PHONE_APP_POST_CALL_SCREEN("android_phone_app_post_call_screen"),
        INTERN_MATCH_MANAGER_SUGGEST_PHONE("intern_match_manager_suggest_phone"),
        INTERN_MATCH_MANAGER_SUGGEST_MATCH("intern_match_manager_suggest_match"),
        AFTER_PARTY_POPULAR_AT_UNCATEGORIZED("after_party_popular_at_uncategorized"),
        AFTER_PARTY_POPULAR_AT_ANDROID("after_party_popular_at_android"),
        AFTER_PARTY_POPULAR_AT_IOS("after_party_popular_at_ios"),
        POPULAR_AT_INTERN_TEST_PAGE("popular_at_intern_test_page"),
        POPULAR_AT_NFX("popular_at_nfx"),
        CHECKIN_AFTER_PARTY("checkin_after_party"),
        PLACE_FEED("place_feed"),
        PLACE_FEED_THANK_YOU_CARD_BUTTON("place_feed_thank_you_card_button"),
        LOCAL_SERP("local_serp"),
        LOCAL_SERP_THANK_YOU_CARD_BUTTON("local_serp_thank_you_card_button"),
        ANDROID_FEATHER_POST_COMPOSE("android_feather_post_compose"),
        ANDROID_FEATHER_PLACE_TIP_QUESTION("android_feather_place_tip_question"),
        IOS_FEATHER_POST_COMPOSE("ios_feather_post_compose"),
        ANDROID_FEATHER_SUGGEST_EDITS_UPSELL("android_feather_suggest_edits_upsell"),
        IOS_FEATHER_SUGGEST_EDITS_UPSELL("ios_feather_suggest_edits_upsell"),
        ANDROID_NEARBY_FRIENDS_SELF_VIEW_CONTEXT_MENU("android_nearby_friends_self_view_context_menu"),
        IOS_NEARBY_FRIENDS_SELF_VIEW_CONTEXT_MENU("ios_nearby_friends_self_view_context_menu"),
        NETEGO("netego"),
        UNKNOWN_ADD_A_CATEGORY("unknown_add_a_category"),
        IOS_PAGE_OLD_SOURCE("ios_page_old_source"),
        UNKNOWN_REPORT_PAGE("unknown_report_page"),
        UNKNOWN_REPORT_PLACE("unknown_report_place"),
        MSITE_UNKNOWN_SUGGEST_EDITS("msite_unknown_suggest_edits"),
        MSITE_REPORT_MERGED_PAGES_URL("msite_report_merged_pages_url"),
        GROUPS_MALL_VIEW("groups_mall_view"),
        UNIT_TEST("unit_test"),
        UNKNOWN("unknown");
        
        protected final String serverValue;

        private EntryPoint(String str) {
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

    /* compiled from: real_time_activity_sentence */
    public enum Sentiment implements JsonSerializable {
        AGREE("agree"),
        DISAGREE("disagree"),
        UNSURE("unsure"),
        SPAM("spam"),
        FIVE_VERY_GOOD("five_very_good"),
        FIVE_GOOD("five_good"),
        FIVE_NEUTRAL("five_neutral"),
        FIVE_BAD("five_bad"),
        FIVE_VERY_BAD("five_very_bad"),
        MCSS_AGREE("mcss_agree"),
        MCSS_DISAGREE("mcss_disagree"),
        MCSS_UNSURE("mcss_unsure"),
        CHOSE_1("chose_1"),
        CHOSE_2("chose_2");
        
        protected final String serverValue;

        private Sentiment(String str) {
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

    public final CrowdsourcingCreateClaimInputData m4354a(String str) {
        a("session_id", str);
        return this;
    }

    public final CrowdsourcingCreateClaimInputData m4355b(String str) {
        a("page_id", str);
        return this;
    }

    public final CrowdsourcingCreateClaimInputData m4356c(String str) {
        a("field_type", str);
        return this;
    }

    public final CrowdsourcingCreateClaimInputData m4357d(String str) {
        a("knowledge_value", str);
        return this;
    }

    public final CrowdsourcingCreateClaimInputData m4353a(Sentiment sentiment) {
        a("sentiment", sentiment);
        return this;
    }

    public final CrowdsourcingCreateClaimInputData m4350a(Action action) {
        a("action", action);
        return this;
    }

    public final CrowdsourcingCreateClaimInputData m4351a(Endpoint endpoint) {
        a("endpoint", endpoint);
        return this;
    }

    public final CrowdsourcingCreateClaimInputData m4352a(EntryPoint entryPoint) {
        a("entry_point", entryPoint);
        return this;
    }
}
