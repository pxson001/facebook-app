package com.facebook.common.util;

import android.text.SpannableStringBuilder;

/* compiled from: share_chaining */
public class SeparatedSpannableStringBuilder extends SpannableStringBuilder {
    private CharSequence f2783a;

    public SeparatedSpannableStringBuilder(CharSequence charSequence) {
        this.f2783a = charSequence;
    }

    public SeparatedSpannableStringBuilder() {
        this("  •  ");
    }

    public final SeparatedSpannableStringBuilder m3910a(CharSequence charSequence) {
        return m3911a(charSequence, null, 0);
    }

    public final SeparatedSpannableStringBuilder m3911a(CharSequence charSequence, Object obj, int i) {
        if (length() > 0) {
            append(this.f2783a);
        }
        int length = length();
        append(charSequence);
        if (obj != null) {
            setSpan(obj, length, charSequence.length() + length, i);
        }
        return this;
    }
}
