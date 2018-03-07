package com.facebook.composer.util;

import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import com.facebook.common.util.StringUtil;

/* compiled from: tapped_friend_likers_or_visitors */
public class ComposerUserNameUtil {
    public static SpannableStringBuilder m2087a(String str) {
        CharSequence charSequence;
        if (StringUtil.a(str)) {
            charSequence = "";
        } else {
            Object obj = str;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.setSpan(new StyleSpan(1), 0, str == null ? 0 : str.length(), 33);
        return spannableStringBuilder;
    }
}
