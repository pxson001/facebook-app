package com.facebook.messaging.payment.value.input;

/* compiled from: exception_domain */
public enum MessengerPayState {
    PREPARE_PAYMENT(true, true, true, true),
    CHECK_RECIPIENT_ELIGIBILITY(true, false, true, false),
    PROCESSING_CHECK_RECIPIENT_ELIGIBILITY(true, false, true, false),
    CARD_VERIFY(true, false, false, true),
    PROCESSING_CARD_VERIFY(true, false, false, true),
    CHECK_AMOUNT(true, false, false, false),
    PROCESSING_CHECK_AMOUNT(true, false, false, false),
    CHECK_PIN(true, true, false, false),
    PROCESSING_CHECK_PIN(true, true, false, false),
    SEND_PAYMENT(true, true, true, true),
    PROCESSING_SEND_PAYMENT(true, true, true, true);
    
    private boolean mIsForCommerce;
    private boolean mIsForOrionRequest;
    private boolean mIsForOrionSend;
    private boolean mIsForPagesCommerce;

    private MessengerPayState(boolean z, boolean z2, boolean z3, boolean z4) {
        this.mIsForOrionSend = z;
        this.mIsForCommerce = z2;
        this.mIsForOrionRequest = z3;
        this.mIsForPagesCommerce = z4;
    }

    public final MessengerPayState next(MessengerPayType messengerPayType) {
        for (int ordinal = ordinal() + 1; ordinal < values().length; ordinal++) {
            switch (messengerPayType) {
                case MP:
                case MC:
                    if (!values()[ordinal].mIsForCommerce) {
                        break;
                    }
                    return values()[ordinal];
                case PAGES_COMMERCE:
                    if (!values()[ordinal].mIsForPagesCommerce) {
                        break;
                    }
                    return values()[ordinal];
                case ORION_REQUEST:
                case GROUP_COMMERCE_REQUEST:
                    if (!values()[ordinal].mIsForOrionRequest) {
                        break;
                    }
                    return values()[ordinal];
                default:
                    if (!values()[ordinal].mIsForOrionSend) {
                        break;
                    }
                    return values()[ordinal];
            }
        }
        throw new IllegalStateException("Reaches the end of the state machine without findinga valid state with MessengerPayType: " + messengerPayType);
    }
}
