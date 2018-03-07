package com.facebook.tablet.sideshow.ads.model;

/* compiled from: onSubmitEditing */
public class AppAdsSideshowSecondaryAction {
    public int f4662a;
    private SecondaryActionType f4663b;
    public String f4664c;
    private String f4665d;

    /* compiled from: onSubmitEditing */
    public enum SecondaryActionType {
        LEARN_MORE,
        HIDE,
        HIDE_AD,
        HIDE_ADVERTISER,
        SHOW_AD_PREFERENCES,
        ADS_PREFERENCES_FEEDBACK_USEFUL
    }

    public AppAdsSideshowSecondaryAction(SecondaryActionType secondaryActionType, String str, String str2) {
        this.f4663b = secondaryActionType;
        this.f4662a = secondaryActionType.ordinal();
        this.f4664c = str;
        this.f4665d = str2;
    }
}
