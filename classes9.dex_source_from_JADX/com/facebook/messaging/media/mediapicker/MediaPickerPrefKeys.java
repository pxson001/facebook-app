package com.facebook.messaging.media.mediapicker;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: mBarCodeValue */
public class MediaPickerPrefKeys {
    public static final PrefKey f11716a;
    public static final PrefKey f11717b;
    public static final PrefKey f11718c = ((PrefKey) f11716a.a("media_picker_next_open_timestamp"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("media_picker/");
        f11716a = prefKey;
        f11717b = (PrefKey) prefKey.a("media_picker_last_open_timestamp");
    }
}
