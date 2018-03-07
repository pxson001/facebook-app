package com.facebook.contacts.ccu.logging;

/* compiled from: privacy_kind */
public class CCULoggingConstants {

    /* compiled from: privacy_kind */
    public enum Events {
        CCU_SETTING("ccu_setting_enable_disable_event"),
        CCU_CREATE_SESSION_CHECK_SYNC("ccu_create_session_check_sync_event"),
        CCU_CONTACTS_UPLOAD_SUCCEEDED("ccu_contacts_upload_succeeded_event"),
        CCU_CONTACTS_UPLOAD_FAILED("ccu_contacts_upload_failed_event"),
        CCU_INVALID_CONTACT_ID("ccu_invalid_contact_id_event"),
        CCU_CONTACTS_UPLOAD_INFORMATION("ccu_contacts_upload_information_event");
        
        private final String mEventName;

        private Events(String str) {
            this.mEventName = str;
        }

        public final String getName() {
            return this.mEventName;
        }
    }
}
