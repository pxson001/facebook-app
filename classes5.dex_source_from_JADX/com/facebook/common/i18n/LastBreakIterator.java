package com.facebook.common.i18n;

import java.text.BreakIterator;

/* compiled from: speller_confidence */
public class LastBreakIterator {
    private final BreakIterator f2618a;
    private final CharSequence f2619b;

    public LastBreakIterator(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.f2619b = charSequence;
        this.f2618a = BreakIterator.getWordInstance();
        this.f2618a.setText(this.f2619b.toString());
        this.f2618a.last();
    }

    private boolean m3726a(int i) {
        return !Character.isLetterOrDigit(this.f2619b.charAt(i));
    }

    public final CharSequence m3727a() {
        int previous = this.f2618a.previous();
        while (previous != -1) {
            if (m3726a(previous) && (previous - 1 == -1 || !m3726a(previous - 1))) {
                return this.f2619b.subSequence(0, previous);
            }
            previous = this.f2618a.previous();
        }
        return "";
    }
}
