package com.facebook.video.abtest;

/* compiled from: response_number_on_body */
public enum SourceType {
    HTTP,
    HTTP_1RT_INTERCEPTING;

    public static SourceType of(String str) {
        for (SourceType sourceType : values()) {
            if (sourceType.toString().equalsIgnoreCase(str)) {
                return sourceType;
            }
        }
        return HTTP;
    }
}
