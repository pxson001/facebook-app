package com.facebook.adinterfaces.external.logging;

/* compiled from: base64 */
public enum AdInterfacesExternalLogger$Event {
    EVENT_RENDER_CREATE_ENTRY_POINT("render_create_entry_button"),
    EVENT_RENDER_EDIT_ENTRY_POINT("render_edit_entry_button"),
    EVENT_RENDER_FAIL_ENTRY_POINT("render_entry_button_error"),
    EVENT_RENDER_INSIGHTS_ENTRY_POINT("render_insights_entry_button"),
    EVENT_CREATE_DIALOG_OPEN("create_dialog_open"),
    EVENT_CLIENT_INELIGIBLE_FLOW_ACTION_CLICK("client_ineligible_flow_action_click"),
    EVENT_CLIENT_INELIGIBLE_FLOW_CANCEL("client_ineligible_flow_cancel");
    
    private final String event;

    private AdInterfacesExternalLogger$Event(String str) {
        this.event = str;
    }

    public final String toString() {
        return this.event;
    }
}
