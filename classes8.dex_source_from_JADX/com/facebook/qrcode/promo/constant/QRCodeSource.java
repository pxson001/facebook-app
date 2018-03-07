package com.facebook.qrcode.promo.constant;

/* compiled from: call_phone_tap */
public enum QRCodeSource {
    BOOKMARK("bookmark"),
    FRIENDS_CENTER("friends_center"),
    SEARCH("search"),
    UNKNOWN("unknown");
    
    public final String value;

    private QRCodeSource(String str) {
        this.value = str;
    }

    public static QRCodeSource fromString(String str) {
        for (QRCodeSource qRCodeSource : values()) {
            if (qRCodeSource.value.equalsIgnoreCase(str)) {
                return qRCodeSource;
            }
        }
        return UNKNOWN;
    }
}
