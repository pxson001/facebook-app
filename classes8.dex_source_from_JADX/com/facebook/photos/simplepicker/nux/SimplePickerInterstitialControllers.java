package com.facebook.photos.simplepicker.nux;

import com.facebook.photos.prefs.PhotosPrefKeys;
import com.facebook.prefs.shared.PrefKey;

/* compiled from: set_token */
public enum SimplePickerInterstitialControllers {
    SOUVENIR_NUX(SimplePickerSouvenirInterstitialController.class, "3993", PhotosPrefKeys.d, "Souvenir NUX"),
    MULTIMEDIA_NUX(SimplePickerMultimediaInterstitialController.class, "3883", PhotosPrefKeys.e, "Multi media post NUX"),
    SLIDESHOW_NUX(SimplePickerSlideshowInterstitialController.class, "4194", PhotosPrefKeys.f, "Slidshow post NUX"),
    HD_UPLOAD_NUX(SimplePickerHDUploadInterstitialController.class, "4169", PhotosPrefKeys.g, "HD photo upload NUX");
    
    public final Class<? extends SimplePickerNux> controllerClass;
    public final String description;
    public final String interstitialId;
    public final PrefKey prefKey;

    private SimplePickerInterstitialControllers(Class<? extends SimplePickerNux> cls, String str, PrefKey prefKey, String str2) {
        this.controllerClass = cls;
        this.interstitialId = str;
        this.prefKey = prefKey;
        this.description = str2;
    }

    public static SimplePickerInterstitialControllers forControllerClass(Class<? extends SimplePickerNux> cls) {
        for (SimplePickerInterstitialControllers simplePickerInterstitialControllers : values()) {
            if (simplePickerInterstitialControllers.controllerClass == cls) {
                return simplePickerInterstitialControllers;
            }
        }
        throw new IllegalArgumentException("Unknown controller class: " + cls);
    }
}
