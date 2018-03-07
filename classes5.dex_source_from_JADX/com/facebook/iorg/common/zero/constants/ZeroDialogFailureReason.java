package com.facebook.iorg.common.zero.constants;

/* compiled from: TOPIC_ARTS_ENTERTAINMENT */
public enum ZeroDialogFailureReason {
    UNKNOWN("UNKNOWN"),
    DATA_CONTROL_FAILURE("DATA_CONTROL_WITHOUT_UPSELL"),
    UPSELL_FAILURE("NO_DATA_CONTROL_NO_UPSELL");
    
    public final String failureReason;

    private ZeroDialogFailureReason(String str) {
        this.failureReason = str;
    }
}
