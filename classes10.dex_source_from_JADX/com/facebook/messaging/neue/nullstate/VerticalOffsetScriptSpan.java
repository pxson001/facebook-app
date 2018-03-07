package com.facebook.messaging.neue.nullstate;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* compiled from: richdocument_fragment_tag */
public class VerticalOffsetScriptSpan extends MetricAffectingSpan {
    private int f3358a;

    public VerticalOffsetScriptSpan(int i) {
        this.f3358a = i;
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.baselineShift += this.f3358a;
    }

    public void updateMeasureState(TextPaint textPaint) {
        textPaint.baselineShift += this.f3358a;
    }
}
