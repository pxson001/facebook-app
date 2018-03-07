package com.facebook.iorg.common.upsell.model;

/* compiled from: mCanTag */
public enum PromoLocation {
    UNKNOWN("unknown"),
    MEGAPHONE("megaphone"),
    INTERSTITIAL("interstitial"),
    CARRIER_MANAGER("carrier_manager");
    
    private final String mLocation;

    private PromoLocation(String str) {
        this.mLocation = str;
    }

    public static PromoLocation fromString(String str) {
        if (str != null) {
            for (PromoLocation promoLocation : values()) {
                if (str.equalsIgnoreCase(promoLocation.mLocation)) {
                    return promoLocation;
                }
            }
        }
        return UNKNOWN;
    }

    public final String getParamName() {
        return this.mLocation;
    }
}
