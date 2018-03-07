package com.facebook.placetips.upsell;

import com.facebook.location.gmsupsell.GooglePlayLocationServicesSettingsManager.StatusCode;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.GoogleLocationDialogResult;

/* compiled from: candidateContactPoints */
public /* synthetic */ class PlaceTipsUpsellAnalyticsLogger$1 {
    static final /* synthetic */ int[] f18496a = new int[GoogleLocationDialogResult.values().length];
    public static final /* synthetic */ int[] f18497b = new int[StatusCode.values().length];

    static {
        try {
            f18497b[StatusCode.EASY_RESOLUTION_POSSIBLE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f18497b[StatusCode.EASY_RESOLUTION_ATTEMPTED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f18497b[StatusCode.LOCATION_SETTINGS_OK.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f18497b[StatusCode.EASY_RESOLUTION_UNAVAILABLE.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f18497b[StatusCode.UNKNOWN.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f18496a[GoogleLocationDialogResult.DIALOG_SUCCESS.ordinal()] = 1;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f18496a[GoogleLocationDialogResult.DIALOG_CANCEL.ordinal()] = 2;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f18496a[GoogleLocationDialogResult.DIALOG_NOT_NEEDED.ordinal()] = 3;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f18496a[GoogleLocationDialogResult.DIALOG_NOT_POSSIBLE.ordinal()] = 4;
        } catch (NoSuchFieldError e9) {
        }
    }
}
