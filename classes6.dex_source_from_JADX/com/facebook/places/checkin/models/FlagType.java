package com.facebook.places.checkin.models;

/* compiled from: framesOverlayItems */
public enum FlagType {
    INFO_INCORRECT("info_incorrect"),
    OFFENSIVE("offensive"),
    CLOSED("closed"),
    DUPLICATE("duplicate"),
    NOT_PUBLIC("not_public");
    
    public final String value;

    private FlagType(String str) {
        this.value = str;
    }
}
