package com.facebook.composer.metatext;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.facebook.imagepipeline.image.CloseableImage;

/* compiled from: translateY */
public class MinutiaeIconMetaTextFormatter {
    Resources f1318a;

    public MinutiaeIconMetaTextFormatter(Resources resources) {
        this.f1318a = resources;
    }

    public static SpannableStringBuilder m1386a(Drawable drawable, SpannableStringBuilder spannableStringBuilder, CloseableImage closeableImage, Uri uri, float f) {
        Uri[] uriArr = (Uri[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), Uri.class);
        if (uriArr.length > 0 && uriArr[0].equals(uri)) {
            float abs = Math.abs(f);
            drawable.setBounds(0, 0, (int) ((abs / ((float) closeableImage.g())) * ((float) closeableImage.f())), (int) abs);
            spannableStringBuilder.setSpan(new ImageSpan(drawable, 1), spannableStringBuilder.getSpanStart(uriArr[0]), spannableStringBuilder.getSpanEnd(uriArr[0]), 33);
        }
        return spannableStringBuilder;
    }
}
