package com.facebook.ads;

public enum AdSize {
    BANNER_320_50(320, 50),
    INTERSTITIAL(0, 0),
    BANNER_HEIGHT_50(-1, 50),
    BANNER_HEIGHT_90(-1, 90),
    RECTANGLE_HEIGHT_250(-1, 250);
    
    private final int f13898a;
    private final int f13899b;

    private AdSize(int i, int i2) {
        this.f13898a = i;
        this.f13899b = i2;
    }

    private static boolean m14171a(AdSize adSize, int i, int i2) {
        return adSize != null && adSize.f13898a == i && adSize.f13899b == i2;
    }

    public static AdSize fromWidthAndHeight(int i, int i2) {
        for (AdSize adSize : (AdSize[]) AdSize.class.getEnumConstants()) {
            if (m14171a(adSize, i, i2)) {
                return adSize;
            }
        }
        return null;
    }

    public final int getHeight() {
        return this.f13899b;
    }

    public final int getWidth() {
        return this.f13898a;
    }
}
