package com.facebook.contactlogs.logging;

/* compiled from: profile_pic_source */
public class ContactLogsLoggingConstants {

    /* compiled from: profile_pic_source */
    public enum EventType {
        UPLOAD_STARTED("contact_logs_upload_started"),
        UPLOAD_SUCCEEDED("contact_logs_upload_succeeded"),
        UPLOAD_FAILED("contact_logs_upload_failed"),
        UPLOAD_SETTING_SET("contact_logs_upload_setting_set"),
        UPLOAD_TYPES("contact_logs_upload_types");
        
        private final String mEventName;

        private EventType(String str) {
            this.mEventName = str;
        }

        public final String getEventName() {
            return this.mEventName;
        }
    }
}
