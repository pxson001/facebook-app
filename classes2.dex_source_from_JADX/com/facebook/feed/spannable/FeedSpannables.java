package com.facebook.feed.spannable;

import android.text.Spannable;
import android.text.SpannableString;

/* compiled from: gravity_android_settings_notifications */
public class FeedSpannables {
    public static Spannable m29597a(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
    }
}
