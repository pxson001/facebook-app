package com.facebook.redspace.data;

/* compiled from: PrivacyCheckupProfileStepTTI */
public enum RedSpaceFriendsSection {
    TOP("top"),
    OTHERS("others"),
    TOP_OVERFLOW("top"),
    OTHERS_OVERFLOW("others");
    
    private final String mApiName;

    private RedSpaceFriendsSection(String str) {
        this.mApiName = str;
    }

    public final String toString() {
        return this.mApiName;
    }

    public final String getApiName() {
        return this.mApiName;
    }

    public final boolean isOverflow() {
        return this == TOP_OVERFLOW || this == OTHERS_OVERFLOW;
    }

    public final boolean isTop() {
        return this == TOP || this == TOP_OVERFLOW;
    }

    public final RedSpaceFriendsSection getOverflowVariant() {
        return isTop() ? TOP_OVERFLOW : OTHERS_OVERFLOW;
    }

    public final RedSpaceFriendsSection getNotOverflowVariant() {
        return isTop() ? TOP : OTHERS;
    }

    public final int serialize() {
        return ordinal();
    }

    public static RedSpaceFriendsSection deserialize(int i) {
        return values()[i];
    }
}
