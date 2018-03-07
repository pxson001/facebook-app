package com.facebook.widget.tokenizedtypeahead;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import com.facebook.inject.InjectorLike;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: com.facebook.reportaproblem.base.dialog.CurrentScreen */
public class TokenPickerEditableUtil {

    /* compiled from: com.facebook.reportaproblem.base.dialog.CurrentScreen */
    public class Range {
        public final int f20002a;
        public final int f20003b;

        public Range(int i, int i2) {
            this.f20002a = i;
            this.f20003b = i2;
        }
    }

    public static TokenPickerEditableUtil m28694a(InjectorLike injectorLike) {
        return new TokenPickerEditableUtil();
    }

    static Range m28693a(CharSequence charSequence) {
        if (!(charSequence instanceof Spannable)) {
            return new Range(0, charSequence.length());
        }
        Spannable spannable = (Spannable) charSequence;
        int selectionStart = Selection.getSelectionStart(spannable);
        if (selectionStart != Selection.getSelectionEnd(spannable)) {
            return null;
        }
        int length = charSequence.length();
        int i = length;
        length = 0;
        int i2 = i;
        for (Object obj : (TokenSpan[]) spannable.getSpans(0, charSequence.length(), TokenSpan.class)) {
            int spanStart = spannable.getSpanStart(obj);
            int spanEnd = spannable.getSpanEnd(obj);
            if (spanStart < selectionStart && spanEnd > selectionStart) {
                return null;
            }
            if (spanStart < selectionStart) {
                length = Math.max(length, spanEnd);
            } else if (spanEnd > selectionStart) {
                i2 = Math.min(i2, spanStart);
            }
        }
        while (length < i2 && Character.isWhitespace(spannable.charAt(length))) {
            length++;
        }
        while (length < i2 - 1 && Character.isWhitespace(spannable.charAt(i2 - 1))) {
            i2--;
        }
        return new Range(length, i2);
    }

    final CharSequence m28697b(CharSequence charSequence) {
        Range a = m28693a(charSequence);
        if (a == null) {
            return "";
        }
        return charSequence.subSequence(a.f20002a, a.f20003b);
    }

    public final void m28696a(Editable editable) {
        for (Object obj : m28695c(editable)) {
            int spanStart = editable.getSpanStart(obj);
            int spanEnd = editable.getSpanEnd(obj);
            if (spanEnd - spanStart == 1 && editable.charAt(spanStart) == ' ') {
                editable.removeSpan(obj);
                editable.replace(spanStart, spanEnd, "");
            }
        }
    }

    public final void m28698b(Editable editable) {
        TokenSpan[] c = m28695c(editable);
        if (c.length == 0) {
            editable.clear();
        } else {
            editable.delete(editable.getSpanEnd(c[0]), editable.length());
        }
    }

    private TokenSpan[] m28695c(final Editable editable) {
        TokenSpan[] tokenSpanArr = (TokenSpan[]) editable.getSpans(0, editable.length(), TokenSpan.class);
        Arrays.sort(tokenSpanArr, new Comparator<TokenSpan>(this) {
            final /* synthetic */ TokenPickerEditableUtil f20001b;

            public int compare(Object obj, Object obj2) {
                TokenSpan tokenSpan = (TokenSpan) obj2;
                return editable.getSpanStart(tokenSpan) - editable.getSpanStart((TokenSpan) obj);
            }
        });
        return tokenSpanArr;
    }
}
