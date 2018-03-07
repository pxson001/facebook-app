package com.facebook.messaging.payment.model;

/* compiled from: homeTeamInfo */
public enum TransferStatus {
    R_PENDING(false),
    R_PENDING_VERIFICATION(false),
    R_PENDING_VERIFICATION_PROCESSING(false),
    R_PENDING_MANUAL_REVIEW(false),
    R_CANCELED(true),
    R_CANCELED_SENDER_RISK(true),
    R_CANCELED_RECIPIENT_RISK(true),
    R_CANCELED_DECLINED(true),
    R_CANCELED_EXPIRED(true),
    R_CANCELED_SAME_CARD(true),
    R_CANCELED_CUSTOMER_SERVICE(true),
    R_CANCELED_CHARGEBACK(true),
    R_CANCELED_SYSTEM_FAIL(true),
    R_COMPLETED(true),
    R_PENDING_NUX(false),
    R_PENDING_PROCESSING(false),
    R_PENDING_PUSH_FAIL(false),
    R_PENDING_PUSH_FAIL_CARD_EXPIRED(false),
    S_PENDING(false),
    S_PENDING_VERIFICATION(false),
    S_PENDING_VERIFICATION_PROCESSING(false),
    S_PENDING_MANUAL_REVIEW(false),
    S_CANCELED(true),
    S_CANCELED_SENDER_RISK(true),
    S_CANCELED_RECIPIENT_RISK(true),
    S_CANCELED_DECLINED(true),
    S_CANCELED_EXPIRED(true),
    S_CANCELED_SAME_CARD(true),
    S_CANCELED_CUSTOMER_SERVICE(true),
    S_CANCELED_CHARGEBACK(true),
    S_CANCELED_SYSTEM_FAIL(true),
    S_COMPLETED(true),
    S_SENT(false),
    UNKNOWN_STATUS(false);
    
    public final boolean isTerminalStatus;

    public static TransferStatus fromString(String str) {
        for (TransferStatus transferStatus : values()) {
            if (transferStatus.name().equalsIgnoreCase(str)) {
                return transferStatus;
            }
        }
        return UNKNOWN_STATUS;
    }

    private TransferStatus(boolean z) {
        this.isTerminalStatus = z;
    }

    public final MessengerPayEntityType getMessengerPayEntityType() {
        return MessengerPayEntityType.PAYMENT_TRANSACTION;
    }
}
