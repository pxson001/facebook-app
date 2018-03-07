package com.facebook.messaging.payment.model.verification;

/* compiled from: hashtags */
public enum RiskScreen {
    INTRODUCTION(false),
    REQUEST_CC_CVV(false),
    REQUEST_CC_FIRST_SIX(false),
    REQUEST_LEGAL_NAME(false),
    REQUEST_SSN_LAST_FOUR(false),
    PENDING_MANUAL_REVIEW(true),
    FAILURE(true),
    SUCCESS(true),
    UNKNOWN_SCREEN(false);
    
    public final boolean isTerminal;

    private RiskScreen(boolean z) {
        this.isTerminal = z;
    }

    public static RiskScreen fromString(String str) {
        for (RiskScreen riskScreen : values()) {
            if (riskScreen.name().equalsIgnoreCase(str)) {
                return riskScreen;
            }
        }
        return UNKNOWN_SCREEN;
    }
}
