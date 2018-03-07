package com.facebook.fbservice.service;

/* compiled from: network_subtype */
public enum ErrorCode {
    NO_ERROR(100001),
    API_ERROR(100002),
    HTTP_400_AUTHENTICATION(100003),
    HTTP_400_OTHER(100004),
    HTTP_500_CLASS(100005),
    CONNECTION_FAILURE(100006),
    ORCA_SERVICE_UNKNOWN_OPERATION(100007),
    ORCA_SERVICE_IPC_FAILURE(100008),
    OUT_OF_MEMORY(100009),
    OTHER(100010),
    CANCELLED(100011),
    CACHE_DISK_ERROR(100012),
    MQTT_SEND_FAILURE(100013),
    WORK_AUTH_FAILED(100014),
    WORK_AUTH_COMMUNITY_ID_REQUIRED(100015),
    DATE_ERROR(100016);
    
    private final int mAsInt;

    private ErrorCode(int i) {
        this.mAsInt = i;
    }

    public final int getAsInt() {
        return this.mAsInt;
    }
}
