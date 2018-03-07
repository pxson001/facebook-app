package com.facebook.groups.info.util;

import android.text.Spannable;
import android.text.TextUtils;

/* compiled from: Tap to enable manual controls (see notification) */
public class GroupInfoDescriptionUtil {
    public static CharSequence m24004a(CharSequence charSequence, Spannable spannable) {
        if (spannable.length() + 150 < charSequence.length()) {
            return TextUtils.concat(new CharSequence[]{charSequence.subSequence(0, 150), " ", spannable});
        }
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (charSequence.charAt(i2) == '\n') {
                i++;
            }
            if (i >= 3) {
                return TextUtils.concat(new CharSequence[]{charSequence.subSequence(0, i2), " ", spannable});
            }
        }
        return charSequence;
    }
}
