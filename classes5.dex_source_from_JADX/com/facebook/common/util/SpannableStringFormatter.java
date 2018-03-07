package com.facebook.common.util;

import android.content.res.Resources;
import android.text.SpannableString;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: shadow_backstack */
public class SpannableStringFormatter {
    public static SpannableString m3912a(Resources resources, int i, SpannableStringSubstitution... spannableStringSubstitutionArr) {
        Map hashMap = new HashMap();
        Object[] objArr = new Object[spannableStringSubstitutionArr.length];
        for (int i2 = 0; i2 < spannableStringSubstitutionArr.length; i2++) {
            SpannableStringSubstitution spannableStringSubstitution = spannableStringSubstitutionArr[i2];
            if (spannableStringSubstitution.f2786c == null) {
                objArr[i2] = m3913a(resources, spannableStringSubstitution);
            } else {
                String str = "[[placeholder_" + i2 + "]]";
                objArr[i2] = str;
                hashMap.put(str, spannableStringSubstitution);
            }
        }
        CharSequence string = resources.getString(i, objArr);
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(resources);
        styledStringBuilder.m3921a(string);
        for (Entry entry : hashMap.entrySet()) {
            SpannableStringSubstitution spannableStringSubstitution2 = (SpannableStringSubstitution) entry.getValue();
            styledStringBuilder.m3925a((String) entry.getKey(), m3913a(resources, spannableStringSubstitution2).toString(), spannableStringSubstitution2.f2786c, spannableStringSubstitution2.f2787d);
        }
        return styledStringBuilder.m3926b();
    }

    private static Object m3913a(Resources resources, SpannableStringSubstitution spannableStringSubstitution) {
        if (spannableStringSubstitution.f2784a != null) {
            return spannableStringSubstitution.f2784a;
        }
        return resources.getString(spannableStringSubstitution.f2785b);
    }
}
