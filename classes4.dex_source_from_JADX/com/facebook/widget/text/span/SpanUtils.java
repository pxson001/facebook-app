package com.facebook.widget.text.span;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ParagraphStyle;

/* compiled from: encryptedMachineId */
public class SpanUtils {
    public static CharSequence m13922a(CharSequence charSequence, int i, int i2) {
        Object obj = null;
        if (!(charSequence instanceof Spanned)) {
            return charSequence.subSequence(i, i2);
        }
        Spanned spanned = (Spanned) charSequence;
        ParagraphStyle[] paragraphStyleArr = (ParagraphStyle[]) spanned.getSpans(i, i2, ParagraphStyle.class);
        int length = paragraphStyleArr.length;
        if (length == 0) {
            return charSequence.subSequence(i, i2);
        }
        Editable spannableStringBuilder = new SpannableStringBuilder(spanned);
        int i3 = 0;
        Object obj2 = null;
        while (obj == null && obj2 == null && i3 < length) {
            int spanStart = spanned.getSpanStart(paragraphStyleArr[i3]);
            int spanEnd = spanned.getSpanEnd(paragraphStyleArr[i3]);
            if (obj2 == null && spanStart < i && i < spanEnd) {
                spannableStringBuilder.replace(i, i + 1, "\n");
                obj2 = 1;
            }
            if (obj == null && spanStart < i2 && i2 < spanEnd) {
                spannableStringBuilder.replace(i2 - 1, i2, "\n");
                obj = 1;
            }
            i3++;
        }
        return spannableStringBuilder.subSequence(i, i2);
    }

    public static Editable m13921a(Editable editable) {
        int length = editable.length();
        if (length == 0 || editable.charAt(length - 1) != '\n') {
            editable.append('\n');
        }
        return editable;
    }
}
