package com.facebook.contacts.upload.logging;

/* compiled from: tap_top_left_nav */
public class ContactsUploadLoggingConstants {
    public static int f2216a = 3600;
    public static String f2217b = "fb4a_ccu";
    public static String f2218c = "messenger_ccu";
    public static String f2219d = "server_sync_check_enabled";
    public static String f2220e = "server_sync_check_not_enabled";
    public static String f2221f = "out_of_sync";
    public static String f2222g = "in_sync_and_no_change_since_last_upload";
    public static String f2223h = "in_sync_with_change_since_last_upload";
    public static String f2224i = "nodemodel_null_and_no_change_since_last_upload";
    public static String f2225j = "nodemodel_null_with_change_since_last_upload";

    /* compiled from: tap_top_left_nav */
    public enum Events {
        SEND_ROOTHASH_TO_SERVER("send_roothash_to_server"),
        SYNC_CHECK_SERVER_RESPONSE_RECEIVED("sync_check_server_response_received"),
        SYNC_CHECK_SERVER_RESPONSE_NOT_RECEIVED("sync_check_server_response_not_received"),
        UPDATE_SNAPSHOT_DB_WITH_SERVER_ENTRIES("update_snapshot_db_with_server_entries"),
        START_UPLOAD_CONTACTS("start_upload_contacts"),
        CCU_UPLOAD_SUCCESSS("ccu_upload_success"),
        CCU_UPLOAD_FAIL("ccu_upload_fail"),
        SNAPSHOT_AND_IMPORT_ID_DELETED("snapshot_and_import_id_deleted"),
        TURN_OFF_CCU_AFTER_EXCEPTION("turn_off_ccu_after_exception"),
        OVERALL_UPLOAD_START("overall_upload_start"),
        OVERALL_UPLOAD_FINISH("overall_upload_finish"),
        COMPUTE_DELTA_AND_UPLOAD("compute_delta_and_upload"),
        BATCH_UPLOAD_START("batch_upload_start"),
        BATCH_UPLOAD_FINISH("batch_upload_finish"),
        BATCH_UPLOAD_ATTEMPT_ERROR("batch_upload_attempt_error"),
        BATCH_UPLOAD_FAIL("batch_upload_fail");
        
        private final String mEventName;

        private Events(String str) {
            this.mEventName = str;
        }

        public final String getEventName() {
            return this.mEventName;
        }
    }
}
