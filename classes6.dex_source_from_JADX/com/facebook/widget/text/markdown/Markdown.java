package com.facebook.widget.text.markdown;

import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.facebook.widget.text.html.BaseTagHandler;
import com.facebook.widget.text.html.FbHtml;
import com.facebook.widget.text.html.HtmlContentHandler;
import com.facebook.widget.text.html.HtmlTagHandler;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: com.google.android.gms.location.places.PlaceBuffer.ATTRIBUTIONS_EXTRA_KEY */
public class Markdown {

    /* compiled from: com.google.android.gms.location.places.PlaceBuffer.ATTRIBUTIONS_EXTRA_KEY */
    final class C14951 implements Comparator<Object> {
        final /* synthetic */ Spanned f19888a;

        C14951(Spanned spanned) {
            this.f19888a = spanned;
        }

        public final int compare(Object obj, Object obj2) {
            return this.f19888a.getSpanStart(obj) - this.f19888a.getSpanStart(obj2);
        }
    }

    private static Spannable m28621a(Spanned spanned, Spanned spanned2) {
        int i = 0;
        if (spanned2 == null) {
            return new SpannableStringBuilder();
        }
        if (spanned == null) {
            return new SpannableStringBuilder(spanned2);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spanned2);
        Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
        Arrays.sort(spans, new C14951(spanned));
        int length = spans.length;
        String obj = spanned2.toString();
        String obj2 = spanned.toString();
        for (int i2 = 0; i2 < length; i2++) {
            int spanStart = spanned.getSpanStart(spans[i2]);
            int spanEnd = spanned.getSpanEnd(spans[i2]);
            int indexOf = obj.indexOf(obj2.substring(spanStart, spanEnd), i);
            if (indexOf != -1) {
                spannableStringBuilder.setSpan(spans[i2], indexOf, (spanEnd + indexOf) - spanStart, spanned.getSpanFlags(spans[i2]));
            }
            if (i2 < length - 1) {
                i = (spanned.getSpanStart(spans[i2 + 1]) - spanStart) + indexOf;
            }
        }
        return spannableStringBuilder;
    }

    public static Spannable m28622a(Spanned spanned, String str) {
        BaseTagHandler baseTagHandler = FbHtml.f19875a;
        HtmlContentHandler htmlContentHandler = new HtmlContentHandler();
        htmlContentHandler.f19879c = baseTagHandler;
        return m28621a(spanned, Html.fromHtml("<" + "fbhtml>" + str + "</fbhtml" + ">", null, new HtmlTagHandler(htmlContentHandler)));
    }
}
