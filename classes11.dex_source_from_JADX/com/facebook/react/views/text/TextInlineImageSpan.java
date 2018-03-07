package com.facebook.react.views.text;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.style.ReplacementSpan;
import android.widget.TextView;
import javax.annotation.Nullable;

/* compiled from: REVIEWS */
public abstract class TextInlineImageSpan extends ReplacementSpan {
    @Nullable
    public abstract Drawable mo317a();

    public abstract void mo318a(TextView textView);

    public abstract void mo319b();

    public abstract void mo320c();

    public abstract void mo321d();

    public abstract void mo322e();

    public static void m12020a(Spannable spannable, TextView textView) {
        int i = 0;
        TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) spannable.getSpans(0, spannable.length(), TextInlineImageSpan.class);
        int length = textInlineImageSpanArr.length;
        while (i < length) {
            TextInlineImageSpan textInlineImageSpan = textInlineImageSpanArr[i];
            textInlineImageSpan.mo321d();
            textInlineImageSpan.mo318a(textView);
            i++;
        }
    }
}
