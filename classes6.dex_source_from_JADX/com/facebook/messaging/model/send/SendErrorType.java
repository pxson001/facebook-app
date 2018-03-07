package com.facebook.messaging.model.send;

import com.google.common.base.Objects;

/* compiled from: upload/ */
public enum SendErrorType {
    NONE("none", false),
    EARLIER_MESSAGE_FROM_THREAD_FAILED("earlier_message_from_thread_failed", false),
    PENDING_SEND_ON_STARTUP("pending_send_on_startup", false),
    MEDIA_UPLOAD_FAILED("media_upload_failed", false),
    PERMANENT_FAILURE("permanent_failure", true),
    P2P_PAYMENT_FAILURE("p2p_payment_failure", true),
    P2P_PAYMENT_RISK_FAILURE("p2p_payment_risk_failure", true),
    HTTP_4XX_ERROR("http_4xx", false),
    HTTP_5XX_ERROR("http_5xx", false),
    API_EXCEPTION("api_exception", false),
    IO_EXCEPTION("io_exception", false),
    SMS_SEND_FAILED("sms_send_failed", false),
    TINCAN_RETRYABLE("tincan_send_failed_retryable", false),
    TINCAN_NONRETRYABLE("tincan_send_failed_nonretriable", true),
    MQTT_PRICING_RESET("mqtt_pricing_reset", false),
    OTHER("other", false);
    
    public final String serializedString;
    public final boolean shouldNotBeRetried;

    public static SendErrorType fromSerializedString(String str) {
        for (SendErrorType sendErrorType : values()) {
            if (Objects.equal(str, sendErrorType.serializedString)) {
                return sendErrorType;
            }
        }
        return OTHER;
    }

    private SendErrorType(String str, boolean z) {
        this.serializedString = str;
        this.shouldNotBeRetried = z;
    }
}
