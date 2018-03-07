package com.facebook.messaging.payment.analytics;

/* compiled from: unsave */
public enum PaymentFlowType {
    MONEY_PENNY("money_penny", "mp_pay"),
    MESSENGER_COMMERCE("messenger_commerce", "mc_pay"),
    GROUP_COMMERCE("group_commerce", "p2p_group_commerce_send"),
    SEND("send", "p2p_send"),
    INCENTIVES("incentives", "p2p_incentives"),
    NUX("nux", "p2p_receive"),
    SENDER_INCENTIVES_REDEEM("sender_incentives_redeem", "p2p_sender_incentives_redeem"),
    SETTINGS("settings", "p2p_settings"),
    REQUEST("request", "p2p_request"),
    REQUEST_ACK("request_ack", "p2p_request"),
    UNLOCK("unlock", "p2p_unlock");
    
    public final String analyticsModule;
    private final String type;

    public static PaymentFlowType fromString(String str) {
        for (PaymentFlowType paymentFlowType : values()) {
            if (paymentFlowType.type.equals(str)) {
                return paymentFlowType;
            }
        }
        return SETTINGS;
    }

    private PaymentFlowType(String str, String str2) {
        this.type = str;
        this.analyticsModule = str2;
    }
}
