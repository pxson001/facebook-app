package com.facebook.ufiservices.util;

import android.content.Context;
import android.content.Intent;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;

/* compiled from: cropProfilePictureParams */
public class UfiIntentBuilder {
    public static UfiIntentBuilder m26957a(InjectorLike injectorLike) {
        return new UfiIntentBuilder();
    }

    public static Intent m26956a(Context context, boolean z) {
        Builder k = new Builder(z ? SimplePickerSource.MEDIA_COMMENT : SimplePickerSource.PHOTO_COMMENT).m18374a(Action.NONE).m18382h().m18385k();
        if (!z) {
            k.m18383i();
        }
        return SimplePickerIntent.m18370a(context, k);
    }
}
