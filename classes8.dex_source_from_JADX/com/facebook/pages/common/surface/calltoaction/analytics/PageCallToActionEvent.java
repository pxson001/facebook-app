package com.facebook.pages.common.surface.calltoaction.analytics;

/* compiled from: create_welcome_header */
public enum PageCallToActionEvent {
    EVENT_ADMIN_CALL_TO_ACTION_CREATE("custom_cta_view_create_mobile"),
    EVENT_ADMIN_CALL_TO_ACTION_CHANGE("custom_cta_change_cta_type_mobile"),
    EVENT_ADMIN_CALL_TO_ACTION_ERROR("custom_cta_mobile_admin_flow_error"),
    EVENT_ADMIN_CALL_TO_ACTION_SAVE("custom_cta_click_save_mobile"),
    EVENT_ADMIN_CALL_TO_ACTION_EDIT("custom_cta_click_edit_mobile"),
    EVENT_ADMIN_CALL_TO_ACTION_EDIT_CANCEL("custom_cta_click_edit_cancel_mobile"),
    EVENT_ADMIN_CALL_TO_ACTION_SWITCH_TYPES("custom_cta_switch_types_mobile"),
    EVENT_ADMIN_CALL_TO_ACTION_DELETE("custom_cta_click_delete_mobile"),
    EVENT_ADMIN_CALL_TO_ACTION_SWITCH_TO_LINKOUT("custom_cta_switch_to_linkout"),
    EVENT_ADMIN_CALL_TO_ACTION_SWITCH_FROM_LINKOUT("custom_cta_switch_from_linkout"),
    EVENT_ADMIN_CALL_TO_ACTION_CHECK_DEEPLINK("custom_cta_check_setup_deeplink"),
    EVENT_ADMIN_CALL_TO_ACTION_UNCHECK_DEEPLINK("custom_cta_uncheck_setup_deeplink"),
    EVENT_ADMIN_CALL_TO_ACTION_BACK_BUTTON("custom_cta_mobile_click_back_button"),
    EVENT_ADMIN_CALL_TO_ACTION_NEXT_BUTTON("custom_cta_mobile_click_next_button"),
    EVENT_ADMIN_CALL_TO_ACTION_DELETE_CONFIRM("custom_cta_click_confirm_delete_mobile"),
    EVENT_ADMIN_CALL_TO_ACTION_DELETE_CANCEL("custom_cta_click_cancel_delete_mobile"),
    EVENT_VIEWER_CALL_TO_ACTION_BACK_BUTTON("custom_cta_mobile_click_back_button"),
    EVENT_VIEWER_CALL_TO_ACTION_BACK_CLICK_YES("custom_cta_mobile_back_click_yes"),
    EVENT_VIEWER_CALL_TO_ACTION_BACK_CLICK_NO("custom_cta_mobile_back_click_no"),
    EVENT_CALL_TO_ACTION_INVALID_URL("custom_cta_mobile_invalid_url"),
    EVENT_CALL_TO_ACTION_INVALID_EMAIL("custom_cta_mobile_invalid_email"),
    EVENT_CALL_TO_ACTION_SWITCH_SELECT_OPTIONS("custom_cta_mobile_switch_select_options"),
    EVENT_CALL_TO_ACTION_TAP_ENTITY_LINK("custom_cta_mobile_click_entity_link");
    
    private String mEventName;

    private PageCallToActionEvent(String str) {
        this.mEventName = str;
    }

    public final String getName() {
        return this.mEventName;
    }
}
