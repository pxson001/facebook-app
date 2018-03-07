package com.facebook.common.i18n;

import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.text.BreakIterator;
import java.util.Locale;

/* compiled from: getBucketIndex */
public class BreakIteratorHelper {
    private final BreakIterator f11237a = BreakIterator.getWordInstance(Locale.US);

    public static BreakIteratorHelper m11656a(InjectorLike injectorLike) {
        return new BreakIteratorHelper();
    }

    public final ImmutableList<String> m11658a(String str) {
        return m11657a(str, false);
    }

    public final ImmutableList<String> m11659b(String str) {
        return m11657a(str, true);
    }

    private ImmutableList<String> m11657a(String str, boolean z) {
        Builder builder = new Builder();
        this.f11237a.setText(str);
        int first = this.f11237a.first();
        int i = first;
        first = this.f11237a.next();
        while (first != -1) {
            if (Character.isLetterOrDigit(str.charAt(i))) {
                Object substring = str.substring(i, first);
                if (z) {
                    substring = substring.toLowerCase(Locale.US);
                }
                builder.c(substring);
            }
            i = first;
            first = this.f11237a.next();
        }
        return builder.b();
    }
}
