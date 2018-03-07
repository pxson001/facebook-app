package com.facebook.leadgen.util;

/* compiled from: photo_item */
public enum LeadGenSplitFlowRequestMethodEnum {
    POST("POST"),
    GET("GET"),
    HASH("HASH"),
    AUTOFILL("AUTOFILL"),
    NONE("");
    
    private final String name;

    private LeadGenSplitFlowRequestMethodEnum(String str) {
        this.name = str;
    }

    public static LeadGenSplitFlowRequestMethodEnum fromValue(String str) {
        for (LeadGenSplitFlowRequestMethodEnum leadGenSplitFlowRequestMethodEnum : values()) {
            if (leadGenSplitFlowRequestMethodEnum.name.equals(str)) {
                return leadGenSplitFlowRequestMethodEnum;
            }
        }
        return NONE;
    }

    public final String toString() {
        return this.name;
    }
}
