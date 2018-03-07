package com.facebook.pages.common.logging.analytics;

import com.facebook.pages.common.logging.analytics.PageAnalyticsEvent.PageEventType;

/* compiled from: message_after */
public enum AdminContactInboxEvent implements PageAnalyticsEvent {
    EVENT_ADMIN_CONTACT_INBOX_TAPPED_ENTRY_POINT("custom_cta_mobile_contact_us_tapped_all_requests"),
    EVENT_ADMIN_CONTACT_INBOX_TAPPED_ONE_REQUEST("custom_cta_mobile_contact_us_tapped_request"),
    EVENT_ADMIN_CONTACT_INBOX_TAPPED_SEND_EMAIL("custom_cta_mobile_contact_us_tapped_email"),
    EVENT_ADMIN_CONTACT_INBOX_TAPPED_PHONE_NUMBER("custom_cta_mobile_contact_us_tapped_phone"),
    EVENT_ADMIN_CONTACT_INBOX_TOGGLE_RESPONDED("custom_cta_mobile_contact_us_toggle_responded"),
    EVENT_ADMIN_CONTACT_INBOX_TAPPED_BAN_USER("custom_cta_mobile_contact_us_tapped_ban_from_page");
    
    private String mEventName;

    private AdminContactInboxEvent(String str) {
        this.mEventName = str;
    }

    public final String getName() {
        return this.mEventName;
    }

    public final PageEventType getType() {
        return PageEventType.ADMIN_CONTACT_INBOX;
    }
}
