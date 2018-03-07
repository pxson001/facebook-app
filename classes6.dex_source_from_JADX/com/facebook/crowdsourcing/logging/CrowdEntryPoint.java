package com.facebook.crowdsourcing.logging;

/* compiled from: opt_out */
public enum CrowdEntryPoint {
    ADD_INFO_BUTTON("android_add_info_button"),
    CONTEXT_ROW_SUGGEST_EDITS("android_context_row_suggest_edits"),
    ENTITY_CARD_EDIT_ACTION_BUTTON("android_entity_card_edit_action_button"),
    FEATHER_PLACE_TIP_QUESTION("android_feather_place_tip_question"),
    FEATHER_POST_COMPOSE("android_feather_post_compose"),
    FEATHER_SUGGEST_EDITS_UPSELL("android_feather_suggest_edits_upsell"),
    FEED_ADD_PHOTO_BUTTON("android_feed_add_photo_button"),
    MAP_REPORT_BUTTON_MENU("android_map_report_button_menu"),
    MGE_SUGGEST_EDITS_BUTTON("mge_suggest_edits_button"),
    PAGE_ACTION_MENU_SUGGEST_EDITS("android_page_action_menu_suggest_edits"),
    PAGE_HEADER_ADD_PHOTO_BUTTON("android_page_header_add_photo_button"),
    PAGE_MORE_INFORMATION_SUGGEST_EDITS("android_page_more_information_suggest_edits"),
    PHONE_APP_POST_CALL_SCREEN("android_phone_app_post_call_screen"),
    PLACE_FEED_THANK_YOU_CARD_BUTTON("place_feed_thank_you_card_button"),
    PLACE_PICKER_ADD_BUTTON("android_place_picker_add_button"),
    PLACE_PICKER_LONG_PRESS("android_place_picker_long_press"),
    PLACE_PICKER_LONG_PRESS_SUGGEST_EDITS("android_place_picker_long_press_suggest_edits"),
    PLACE_PICKER_LONG_PRESS_REPORT_DUPLICATES("android_place_picker_long_press_report_duplicates"),
    PLACE_PICKER_EDIT_MENU("android_place_picker_edit_menu"),
    PLACE_PICKER_EDIT_MENU_SUGGEST_EDITS("android_place_picker_edit_menu_suggest_edits"),
    PLACE_PICKER_EDIT_MENU_REPORT_DUPLICATES("android_place_picker_edit_menu_report_duplicates"),
    PLACE_TIPS("android_place_tips"),
    POPOVER_PLACE_PICKER_ADD_BUTTON("android_popover_place_picker_add_button"),
    POPOVER_PLACE_PICKER_LONG_PRESS("android_popover_place_picker_long_press"),
    POPOVER_PLACE_PICKER_LONG_PRESS_SUGGEST_EDITS("android_popover_place_picker_long_press_suggest_edits"),
    POPOVER_PLACE_PICKER_LONG_PRESS_REPORT_DUPLICATES("android_popover_place_picker_long_press_report_duplicates"),
    POST_CALL("android_post_call"),
    POST_SUGGEST_EDITS_UPSELL("android_post_suggest_edits_upsell"),
    REPORT_PLACE_INCORRECT_INFORMATION("android_report_place_incorrect_information"),
    TIMELINE_ACTION_MENU_REPORT_PAGE("android_timeline_action_menu_report_page"),
    UNKNOWN("unknown");
    
    private String mEntryPoint;

    private CrowdEntryPoint(String str) {
        this.mEntryPoint = str;
    }

    public final String getFullName() {
        return this.mEntryPoint;
    }

    public static CrowdEntryPoint fromFullName(String str) {
        for (CrowdEntryPoint crowdEntryPoint : values()) {
            if (crowdEntryPoint.getFullName().equals(str)) {
                return crowdEntryPoint;
            }
        }
        return null;
    }
}
