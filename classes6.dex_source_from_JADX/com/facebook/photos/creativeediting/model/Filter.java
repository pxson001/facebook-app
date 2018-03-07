package com.facebook.photos.creativeediting.model;

/* compiled from: survey_token_params */
public enum Filter {
    PassThrough,
    AE08bit,
    VintageRGB,
    SpringRGB,
    SummerRGB,
    FallRGB,
    WinterRGB,
    ZebraBW;

    public static Filter getValue(String str) {
        for (Filter filter : values()) {
            if (filter.name().equals(str)) {
                return filter;
            }
        }
        return PassThrough;
    }

    public static boolean isFilter(String str) {
        for (Filter name : values()) {
            if (name.name().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
