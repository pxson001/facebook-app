package com.facebook.common.util;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;

/* compiled from: sgm */
public class SpannableUtil {
    public static void m3915a(SpannableStringBuilder spannableStringBuilder, Object... objArr) {
        int length = spannableStringBuilder.length();
        for (Object span : objArr) {
            spannableStringBuilder.setSpan(span, 0, length, 33);
        }
    }

    public static void m3914a(int i, int i2, SpannableString spannableString, Object... objArr) {
        for (Object span : objArr) {
            spannableString.setSpan(span, i, i2, 33);
        }
    }
}
