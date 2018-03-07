package com.facebook.appdiscovery.lite.common.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

/* compiled from: is_phonetic_matched_entity */
public abstract class NoUnderlineClickableSpan extends ClickableSpan {
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
    }
}
