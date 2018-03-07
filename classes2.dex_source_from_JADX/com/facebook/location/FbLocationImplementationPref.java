package com.facebook.location;

import javax.annotation.Nullable;

/* compiled from: latitude */
public enum FbLocationImplementationPref {
    DEFAULT(0, "Default (Auto)", null),
    ANDROID_PLATFORM_PREF(1, "Android Platform", FbLocationImplementation.ANDROID_PLATFORM),
    GOOGLE_PLAY_PREF(2, "Google Play Services", FbLocationImplementation.GOOGLE_PLAY),
    MOCK_MPK_STATIC_PREF(3, "MPK Static", FbLocationImplementation.MOCK_MPK_STATIC);
    
    public final int key;
    @Nullable
    final FbLocationImplementation locationImplementation;
    public final String name;

    private FbLocationImplementationPref(int i, String str, FbLocationImplementation fbLocationImplementation) {
        this.name = str;
        this.key = i;
        this.locationImplementation = fbLocationImplementation;
    }

    public static FbLocationImplementationPref get(int i) {
        for (FbLocationImplementationPref fbLocationImplementationPref : values()) {
            if (fbLocationImplementationPref.key == i) {
                return fbLocationImplementationPref;
            }
        }
        return DEFAULT;
    }
}
