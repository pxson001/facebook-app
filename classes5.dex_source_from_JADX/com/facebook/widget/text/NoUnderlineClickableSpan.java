package com.facebook.widget.text;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

/* compiled from: com.facebook.imagepipeline.animated.factory.AnimatedFactoryImpl */
public abstract class NoUnderlineClickableSpan extends ClickableSpan {
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }
}
