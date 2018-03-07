package com.facebook.iorg.common.zero.constants;

/* compiled from: TOPIC_APPLIANCES */
public enum ZeroDialogState {
    UNKOWN("UNKOWN"),
    DATA_CONTROL_WITHOUT_UPSELL("DATA_CONTROL_WITHOUT_UPSELL"),
    NO_DATA_CONTROL_NO_UPSELL("NO_DATA_CONTROL_NO_UPSELL"),
    UPSELL_WITH_DATA_CONTROL("UPSELL_WITH_DATA_CONTROL"),
    UPSELL_WITHOUT_DATA_CONTROL("UPSELL_WITHOUT_DATA_CONTROL");
    
    public final String dialogState;

    private ZeroDialogState(String str) {
        this.dialogState = str;
    }
}
